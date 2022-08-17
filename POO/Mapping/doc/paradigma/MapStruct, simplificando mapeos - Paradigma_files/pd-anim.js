/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.anim = {
    const: {
        elems: '[pd-anim]:not(.init)',
        letterDelay: 30,
        wordDelay: 20,
        cssAnimationDuration: 1000,
    },
    init: (wrap = document) => {
        let elems = wrap.querySelectorAll(pd.anim.const.elems);

        elems = [].slice.call(elems);

        if ('IntersectionObserver' in window) {
            pd.anim.observer = new IntersectionObserver((entries, observer) => {
                entries.forEach((entry) => {
                    if (entry.isIntersecting) {
                        pd.anim.animElem(entry.target);
                        pd.anim.observer.unobserve(entry.target);
                    }
                });
            });

            elems.forEach((lazyImage) => {
                pd.anim.observer.observe(lazyImage);
            });
        } else {
            elems.forEach((el) => {
                el.classList.add('init');
            });
        }
    },
    animElem: (elem) => {
        const type = elem.getAttribute('pd-anim');

        switch (type) {
        // pd-anim="fadeIn"
        case 'fadeIn':
            pd.anim.animate.fadeIn(elem);
            break;
        // pd-anim="slideUp"
        case 'slideUp':
            pd.anim.animate.slideUp(elem);
            break;
        case 'slideUp_reverse':
            pd.anim.animate.slideUp(elem);
            break;
        // pd-anim="slideUpLetters"
        case 'slideUpLetters':
        case 'slideDownLetters':
            pd.anim.animate.slideLetters(elem);
            break;

        case 'slideUpLetters_reverse':
        case 'slideDownLetters_reverse':
            pd.anim.animate.slideLetters_reverse(elem);
            break;

        // pd-anim="slideUpWords"
        case 'slideUpWords':
            pd.anim.animate.slideUpWords(elem);
            break;

        // pd-anim="lineThrough"
        case 'lineThrough':
            pd.anim.animate.lineThrough(elem);
            break;

        // pd-anim="lineThrough_reverse"
        case 'lineThrough_reverse':
            pd.anim.animate.lineThrough_reverse(elem);
            break;

        default:
            break;
        }
    },
    getDelay: (elem) => {
        const delay = elem.getAttribute('pd-anim-delay');

        if (!delay) {
            return 0;
        }
        return parseInt(delay, 10);
    },
    setDelay: (elem) => {
        const delay = pd.anim.getDelay(elem);
        elem.classList.remove('init');
        if (!delay && delay !== 0) {
            elem.classList.add('init');
            return;
        }

        elem.setAttribute('style', `${elem.getAttribute('style')}; animation-delay: ${delay}ms;`);

        setTimeout(() => {
            elem.classList.add('init');
        }, delay);
    },
    animate: {
        slideUp: (elem) => {
            pd.anim.setDelay(elem);
            pd.anim.setCallback(elem);
        },
        fadeIn: (elem) => {
            pd.anim.setDelay(elem);
        },
        slideLetters: (elem) => {
            elem.classList.remove('finished');
            let html = '';
            let delay = pd.anim.getDelay(elem);
            let wordSeparator = '';

            // No volver a separar en letras un elemento que ya ha sido divido
            if (elem.childNodes.length && elem.getAttribute('content')) {
                elem.innerHTML = elem.getAttribute('content');
            }

            const originHTML = elem.innerHTML;

            elem.setAttribute('content', elem.innerHTML);
            elem.setAttribute('aria-label', elem.innerHTML);

            originHTML.split('<br>').forEach((line) => {
                if (html) { html += '<br>'; }
                line.split(' ').forEach((word) => {
                    html += `${wordSeparator}<w aria-hidden="true">`;
                    delay += pd.anim.const.letterDelay;

                    if (word === '&amp;') {
                        delay += pd.anim.const.letterDelay;
                        html += `<l style="animation-delay: ${delay}ms">${word}</l>`;
                    } else {
                        word.split('').forEach((letter) => {
                            delay += pd.anim.const.letterDelay;
                            html += `<l style="animation-delay: ${delay}ms">${letter}</l>`;
                        });
                    }

                    html += '</w>';
                    // wordSeparator = '&nbsp;';
                    wordSeparator = '<w class="space" aria-hidden="true">&nbsp;</w>';
                });
                elem.innerHTML = html;
                elem.classList.add('init');
            });

            // evitar problema de espacio extra en salto de línea
            const words = elem.querySelectorAll('w');
            for (let i = 0; i < words.length; i++) {
                if (i && words[i].offsetTop > words[i - 1].offsetTop) {
                    words[i - 1].classList.add('prev-to-new-line');
                }
            }

            // si una web tiene muchos nodos va más lenta.
            // esto elimina los nodos creados para la animación una vez terminada
            // a veces causa un pequeño cambio en la posición de algunas palabras
            // usar con cautela.
            if (elem.getAttribute('pd-anim-reset') === 'true') {
                setTimeout(() => {
                    elem.innerHTML = originHTML;
                }, delay + pd.anim.const.cssAnimationDuration);
            }

            pd.anim.setCallback(elem, delay + pd.anim.const.cssAnimationDuration)
        },
        slideLetters_reverse: (elem) => {
            elem.classList.remove('init');
            elem.classList.remove('finished');
            let delay = pd.anim.getDelay(elem);

            let letters = elem.querySelectorAll('l');
            letters = Array.prototype.slice.call(letters, 0);
            letters.forEach((item, i) => {
                item.setAttribute('style', `animation-delay: ${delay}ms`);
                delay += pd.anim.const.letterDelay;
            });

            setTimeout(() => {
                elem.classList.add('init');
            }, 100);

            setTimeout(() => {
                elem.classList.add('finished');
                elem.classList.remove('init');
                if (elem.getAttribute('content')) {
                    elem.innerHTML = elem.getAttribute('content');
                }
            }, delay + 500);
        },
        slideUpWords: (elem) => {
            let html = '';
            let delay = pd.anim.getDelay(elem);
            let wordSeparator = '';
            const originHTML = elem.innerHTML;

            elem.setAttribute('content', originHTML);
            elem.setAttribute('aria-label', originHTML);

            originHTML.split(' ').forEach((word, i) => {
                delay += pd.anim.const.wordDelay;
                html += `${wordSeparator}<w aria-hidden="true"><l style="animation-delay: ${delay}ms">${word}</l></w>`;
                wordSeparator = '<w aria-hidden="true">&nbsp</w>';
            });
            elem.innerHTML = html;
            elem.classList.add('init');

            // si una web tiene muchos nodos va más lenta.
            // esto elimina los nodos creados para la animación una vez terminada
            // a veces causa un pequeño cambio en la posición de algunas palabras
            // usar con cautela.
            if (elem.getAttribute('pd-anim-reset') === 'true') {
                setTimeout(() => {
                    elem.innerHTML = originHTML;
                }, delay + pd.anim.const.cssAnimationDuration);
            }
        },
        lineThrough: (elem) => {
            // solo crea el span la primera vez
            if (!elem.querySelector('span')) {
                elem.innerHTML = `<span>${elem.innerHTML}</span>`;
            }

            pd.anim.setDelay(elem);
        },
        lineThrough_reverse: (elem) => {
            pd.anim.setDelay(elem);
            const delay = pd.anim.getDelay(elem);

            setTimeout(() => {
                elem.classList.add('finished');
                elem.classList.remove('init');
            }, delay + 500);
        },
    },
    panelRelease: {
        const: {
            durations: {
                show: 200,
                hide: 700,
                betweenListItems: 150,
                betweenItemElems: 50,
            },
            classes: {
                show: 'panel-release-visible',
                hide: 'panel-release-invisible',
                showContent: 'panel-release-showContent',
            },
        },
        toggle: (data) => {
            if (!data.wrap.classList.contains(pd.anim.panelRelease.const.classes.show)) {
                pd.anim.panelRelease.show(data);
            } else {
                pd.anim.panelRelease.hide(data);
                pd.overlay.hideOverlay(true);
            }
        },
        show: (data) => {
            // Se muestra el panel
            data.wrap.classList.remove(pd.anim.panelRelease.const.classes.hide);
            data.wrap.classList.add(pd.anim.panelRelease.const.classes.show);
            data.panel.classList.remove(pd.anim.panelRelease.const.classes.hide);
            data.panel.classList.add(pd.anim.panelRelease.const.classes.show);
            pd.overlay.showOverlay();

            // no mostramos el listado hasta que el panel está completamente visible
            setTimeout(() => {
                data.wrap.classList.add(pd.anim.panelRelease.const.classes.showContent);
                data.panel.classList.add(pd.anim.panelRelease.const.classes.showContent);

                pd.anim.panelRelease.showHeader(data.header);

                if (data.listItems) {
                    data.listItems.forEach((item, i) => {
                        requestAnimationFrame(() => {
                            pd.anim.panelRelease.animContentItems(data, item, i);
                        });
                    });
                }
            }, pd.anim.panelRelease.const.durations.show);
        },
        hide: (data) => {
            // que solo se cierre si está abierto
            if (!data.panel.classList.contains(pd.anim.panelRelease.const.classes.showContent)) {
                return;
            }

            if (data.listItems) {
                const listItems = Array.prototype.slice.call(data.listItems, 0);
                listItems.reverse().forEach((item, i) => {
                    pd.anim.panelRelease.revertAnimContentItems(data, item, i);
                });
            }

            // no ocultamos el listado hasta que el panel está completamente visible
            setTimeout(() => {
                data.wrap.classList.remove(pd.anim.panelRelease.const.classes.showContent);
                data.panel.classList.remove(pd.anim.panelRelease.const.classes.showContent);

                // Se oculta el panel
                data.wrap.classList.add(pd.anim.panelRelease.const.classes.hide);
                data.wrap.classList.remove(pd.anim.panelRelease.const.classes.show);
                data.panel.classList.add(pd.anim.panelRelease.const.classes.hide);
                data.panel.classList.remove(pd.anim.panelRelease.const.classes.show);
            }, pd.anim.panelRelease.const.durations.hide);
        },
        animContentItems: (data, item, itemIndex) => {
            const itemDelay = itemIndex * pd.anim.panelRelease.const.durations.betweenListItems;

            data.listItemsToShow.forEach((listItem, elemIndex) => {
                requestAnimationFrame(() => {
                    const selector = listItem[0];
                    const animateMode = listItem[1];

                    const elem = item.querySelector(selector);

                    if (!elem) { return; }
                    let elemDelay = itemDelay + (elemIndex * pd.anim.panelRelease.const.durations.betweenItemElems);
                    elemDelay = Math.max(elemDelay, 400);
                    elem.setAttribute('pd-anim-delay', elemDelay);
                    elem.setAttribute('pd-anim', animateMode);
                    pd.anim.animElem(elem);
                });
            });
        },
        revertAnimContentItems: (data, item, itemIndex) => {
            const arrToReverse = data.listItemsToShow.slice().reverse();
            arrToReverse.forEach((listItem, elemIndex) => {
                requestAnimationFrame(() => {
                    const selector = listItem[0];
                    const animateMode = `${listItem[1]}_reverse`;
                    const elem = item.querySelector(selector);

                    if (!elem) { return; }

                    const elemDelay = (elemIndex + 1) * pd.anim.panelRelease.const.durations.betweenItemElems;

                    elem.setAttribute('pd-anim-delay', elemDelay);
                    elem.setAttribute('pd-anim', animateMode);
                    pd.anim.animElem(elem);
                });
            });
        },
        showHeader: (header) => {
            if (!header) {
                return;
            }

            header.setAttribute('pd-anim', 'slideUp');
            pd.anim.animElem(header);
        },
    },
    setCallback: (elem, time) => {
        if (elem.getAttribute('pd-anim-callback')) {
            if (!time) {
                elem.addEventListener('webkitAnimationEnd', () => {
                    utils.executeFn(elem.getAttribute('pd-anim-callback'));
                });
                elem.addEventListener('animationend', () => {
                    utils.executeFn(elem.getAttribute('pd-anim-callback'));
                });
            } else {
                setTimeout(() => {
                    utils.executeFn(elem.getAttribute('pd-anim-callback'));
                }, time);
            }
        }
    },
};

pd.anim.init();
