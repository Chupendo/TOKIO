/* global pd, _env */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.forms = {
    flags: {},
    constants: {preventSpamFieldName: 'validationFillField'},
    forms: [
        {
            selector: '#newsletter-form .vendor-form',
            options: {
                vendor: 'hubspot',
                gdprModal: true,
                renameLabels: 'newsletter-form',
            },
        },
        {
            selector: '#event-register .vendor-form',
            options: {
                vendor: 'hubspot',
                gdprModal: true,
                renameLabels: 'newsletter-form',
            },
        },
        {
            selector: '.cms-content .vendor-form',
            options: {
                vendor: 'hubspot',
                gdprModal: true,
            },
        },
        {
            selector: '#footer-newsletter .vendor-form',
            options: {
                vendor: 'hubspot',
                gdprModal: true,
            },
        },
        {
            selector: '#contact-form-wrap',
            options: {
                vendor: 'hubspot',
            },
        },
        {
            selector: '#spontaneousCvForm',
            options: {
                vendor: 'hubspot',
                formPanel: true,
                groupCheckboxList: true,
                hash: '#send-cv',
                wrap: 'body.careers-section',
                panel: document.querySelector('#careers-form-spontaneous-wrap'),
            },
        },
        {
            selector: '#offerCvForm',
            options: {
                vendor: 'hubspot',
                formPanel: true,
                groupCheckboxList: true,
                setOfferName: true,
                hash: '#apply-form',
                wrap: 'body.careers-section',
                panel: document.querySelector('#careers-form-offer-wrap'),
            },
        },
    ],
    init: () => {
        // check for dependencies
        if (typeof pd.track === 'undefined' || typeof pd.anim === 'undefined') {
            setTimeout(() => pd.forms.init(), 100);
            return;
        }
        pd.forms.forms.forEach((formData) => {
            const form = document.querySelector(formData.selector);
            if (form) {
                // eslint-disable-next-line no-inner-declarations
                function initHubspot() {
                    pd.forms.loadHubspot(form, formData.options);
                    window.removeEventListener('scroll', initHubspot, false);
                }

                window.addEventListener('scroll', initHubspot, false);

                const trigger = form.querySelector('.js__trigger-form');

                if (trigger) {
                    trigger.addEventListener('click', (e) => {
                        e.preventDefault();
                        initHubspot();
                    });
                }

                // si tien has cargarlo desde el inicio, para que se muestre el panel
                if (formData.options.hash) {
                    initHubspot();
                }
            }
        });
    },
    loadHubspot: (form, options) => {
        const trigger = form.querySelector('.js__trigger-form');
        if (trigger) { trigger.remove(); }

        // cargar librería de Hubspot si no está previamente cargada
        if (!window.hubspot && !pd.forms.flags.loadingHubspot) {
            pd.forms.flags.loadingHubspot = true;
            const script = document.createElement('script');
            script.src = 'https://js.hsforms.net/forms/v2.js';

            document.head.append(script);
        }
        // si todavía no está cargada del todo la librería volvemos a internarlo.
        if (!window.hubspot) {
            setTimeout(() => pd.forms.loadHubspot(form, options), 100);
            return;
        }

        if (form.querySelector('script')) {
            return;
        }

        pd.forms.injectHubspotCode(form);
        pd.forms.tryToReset(form, options);
    },
    injectHubspotCode: (form, id) => {
        const hubspotScript = document.createElement('script');
        const code = `hbspt.forms.create({
          portalId: "${form.getAttribute('hubspot-portal')}",
          formId: "${form.getAttribute('hubspot-form')}"
        });`;
        hubspotScript.appendChild(document.createTextNode(code));
        form.appendChild(hubspotScript);
    },
    tryToReset: (form, options) => {
        const resetNewsletterFormInterval = setInterval(() => {
            if (form.querySelector('form')) {
                pd.forms.reset(form, options);
                clearInterval(resetNewsletterFormInterval);
            }
        }, 100);
    },
    reset: (form, options) => {
        if (options.wrap) {
            // eslint-disable-next-line no-param-reassign
            options.wrap = document.querySelector(options.wrap);
        }

        if (options.formPanel) {
            pd.forms.setFormPanel(options);
        }

        if (options.groupCheckboxList) {
            pd.forms.setCheckBoxLists(options);
        }

        if (options.setOfferName) {
            pd.forms.setInputOfferName(options);
        }

        if (options.vendor === 'hubspot') {
            if (options.gdprModal) {
                pd.forms.hubspot.setGdprModal(form, options);
            }

            if (options.renameLabels) {
                pd.forms.hubspot.renameLabels(form, options);
            }

            pd.forms.hubspot.labelsPosition(form);
        }

        form.classList.add('init');
        pd.forms.setEvents(form);
    },
    hubspot: {
        labelsPosition: (wrap) => {
            const fields = wrap.querySelectorAll('.hs-fieldtype-text, .hs-fieldtype-select, .hs-fieldtype-textarea');

            fields.forEach((field) => {
                if (!field.classList.contains('labelsPosition_init')) {
                    field.classList.add('labelsPosition_init');
                    const input = field.querySelector('input, select, textarea');

                    if (input.value) {
                        field.classList.add('fill-field');
                    }

                    input.addEventListener('focus', (event) => {
                        field.classList.add('active-field');
                    });

                    input.addEventListener('blur', (event) => {
                        field.classList.remove('active-field');

                        if (input.value) {
                            field.classList.add('fill-field');
                        } else {
                            field.classList.remove('fill-field');
                        }
                    });

                    input.addEventListener('change', (event) => {
                        if (input.value) {
                            field.classList.add('fill-field');

                            // por los campos relacionados, que aparecen aveces.
                            setTimeout(() => {
                                pd.forms.hubspot.labelsPosition(wrap);
                            }, 500);
                        } else {
                            field.classList.remove('fill-field');
                        }
                    });
                }
            });
        },
        renameLabels: (wrap, options) => {
            const labels = wrap.querySelectorAll('.hs-form-booleancheckbox label, .hs-form-checkbox label');

            labels.forEach((label) => {
                const input = label.querySelector('input');
                const labelId = label.getAttribute('for');

                label.setAttribute('for', `${options.renameLabels}${labelId}`);
                input.setAttribute('id', `${options.renameLabels}${labelId}`);
            });
        },
        setGdprModal: (wrap, options) => {
            const checkbox = wrap.querySelector('.hs-consentimiento_legal_gdpr');

            if (!checkbox) { return; }

            let modalWrap = checkbox.nextElementSibling;

            if (!modalWrap) {
                // cuendo es multicolumna hay que usar otro selector
                modalWrap = checkbox.closest('fieldset').nextElementSibling.childNodes[0];

                if (!modalWrap) { return; }
            }

            modalWrap.classList.add('gdpr-modal-outer-wrap');

            let openTrigger = '<a class="gdpr-legal-note-open">+ info</a>';
            let closeTrigger = '<a class="gdpr-legal-note-close">✕</a>';

            modalWrap.innerHTML = `${openTrigger}<div class="gdpr-legal-note js__gdpr-modal-wrap">${modalWrap.innerHTML}${closeTrigger}</div>`;

            openTrigger = modalWrap.querySelector('.gdpr-legal-note-open');
            closeTrigger = modalWrap.querySelector('.gdpr-legal-note-close');
            const modal = modalWrap.querySelector('.js__gdpr-modal-wrap');
            modal.classList.add('hidden');

            openTrigger.addEventListener('mouseenter', (e) => {
                e.preventDefault();
                modal.classList.remove('hidden');
            }, false);

            openTrigger.addEventListener('click', (e) => {
                e.preventDefault();
            }, false);


            closeTrigger.addEventListener('click', (e) => {
                e.preventDefault();
                modal.classList.add('hidden');
            }, false);

            modal.addEventListener('mouseleave', (e) => {
                e.preventDefault();
                modal.classList.add('hidden');
            }, false);
        },
    },
    addCaptcha: (form) => {
        // se crea un campo oculto vacio.
        // antes de enviar el formulario revisar si el campo está relleno.
        // en caso de estar relleno entendemos que lo ha rellenado un bot para mandar spam.
        // lo llamo validationFillField por ser un nombre común, para intentar evitar la inteligencia de los softwares de spam.

        const firstInput = form.querySelector('input[type="text"], input[type="email"]');

        const captcha = document.createElement('INPUT');
        captcha.setAttribute('type', 'text');
        captcha.setAttribute('name', pd.forms.constants.preventSpamFieldName);
        captcha.setAttribute('tabindex', '-1');
        captcha.setAttribute('placeholder', 'Dejar vacio este campo. Creado para prevenir el envio de formularios por maquinitas');

        const styles = `border: solid 0px transparent; height: 0 !important;
            padding: 0;
            display: block;
            overflow: hidden;`;
        captcha.setAttribute('style', styles);

        firstInput.parentNode.appendChild(captcha);
    },
    addLine: (input, wrapClass) => {
        input.parentNode.classList.add(wrapClass);

        const lineNode = document.createElement('SPAN');
        lineNode.classList.add('line');
        input.parentNode.appendChild(lineNode);
    },
    setFormPanel: (options) => {
        pd.forms.checkHash(options.hash, options);

        window.addEventListener('hashchange', () => {
            pd.forms.checkHash(options.hash, options);
        });

        options.wrap.querySelectorAll('.close-trigger').forEach((closeTrigger) => {
            closeTrigger.addEventListener('click', () => {
                pd.forms.hide(options, true);
            });
        });

        document.querySelector('#overlay').addEventListener('click', () => {
            pd.forms.hide(options, true);
        });
    },
    setCheckBoxLists: (options) => {
        const perfilesWrap = options.panel.querySelector('.hs_perfiles_solicitud_espontanea');
        const conocimientosWrap = options.panel.querySelector('.hs_entorno_stack_tecnologico');

        pd.forms.setCheckBoxList(perfilesWrap, 'Selecciona algún perfil.');
        pd.forms.setCheckBoxList(conocimientosWrap, 'Selecciona tus conocimientos.');
    },
    setInputOfferName: (options) => {
        const offerNameField = options.panel.querySelector('#offerNameField');
        const hubspotOfferField = options.panel.querySelector("[name='nombre_oferta_de_empleo___candidatura']");

        if (!offerNameField || !hubspotOfferField) {
            return;
        }

        hubspotOfferField.value = offerNameField.value;
    },
    setCheckBoxList: (elem, defaultText) => {
        elem.classList.add('checkBoxListPopup');

        const node = document.createElement('p');
        const textnode = document.createTextNode(defaultText);
        node.appendChild(textnode);
        node.classList.add('checkBoxList-selected');

        elem.querySelector('label').after(node);

        const close = document.createElement('button');
        const closeText = document.createTextNode('✕');
        close.appendChild(closeText);
        close.classList.add('close-trigger');

        elem.querySelector('div.input').appendChild(close);

        node.addEventListener('click', (e) => {
            e.preventDefault();
            elem.classList.toggle('opened');
        });

        close.addEventListener('click', (e) => {
            e.preventDefault();
            elem.classList.toggle('opened');
        });

        const checkboxes = elem.querySelectorAll('.hs-input');
        const selectedItems = [];
        checkboxes.forEach((checkbox) => {
            checkbox.addEventListener('change', () => {
                if (selectedItems.includes(checkbox.value)) {
                    const index = selectedItems.indexOf(checkbox.value);
                    if (index !== -1) {
                        selectedItems.splice(index, 1);
                    }
                } else {
                    selectedItems.push(checkbox.value);
                }

                if (selectedItems.length) {
                    node.innerText = selectedItems.join(', ');
                } else {
                    node.innerText = defaultText;
                }
            });
        });
    },
    checkHash: (string, options) => {
        if (!string) { return; }
        const hash = window.location.hash;

        if (hash === string) {
            pd.forms.show(options);
        } else {
            pd.forms.hide(options, false);
        }
    },
    show: options => pd.anim.panelRelease.show(options),
    hide: (options, removeHash) => {
        pd.anim.panelRelease.hide(options);

        if (removeHash) {
            // quitar hash #send-cv de la url
            window.history.pushState('', document.title, window.location.pathname);
        }

        // eliminar mensaje de éxito
        const succesMsg = document.querySelector('#resultmessage');
        if (succesMsg) {
            succesMsg.remove();
        }
    },
    setEvents: (wrap) => {
        // if (pd.track) {
        //     pd.track.init(wrap);
        // }

        pd.forms.adjustTextareaHeight();
    },
    adjustTextareaHeight: () => {
        const fields = Array.prototype.slice.call(document.querySelectorAll('textarea'));
        fields.forEach((textarea) => {
            textarea.addEventListener('keyup', () => {
                textarea.style.height = '1px';
                textarea.style.height = `${textarea.scrollHeight}px`;
            });
        });
    },
};

pd.forms.init();
