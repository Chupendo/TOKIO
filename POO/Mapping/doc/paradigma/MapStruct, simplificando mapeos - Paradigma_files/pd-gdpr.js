/* global pd, ga, utils, _env */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.gdpr = {
    init: () => {
        if (typeof utils === 'undefined') {
            setTimeout(() => pd.gdpr.init(), 300);
            return;
        }
        const cookie = utils.getCookie('pd-cookies');

        if (!cookie) {
            const isCookiesPage = document.querySelector('body#legal-cookies');
            if (!isCookiesPage) {
                pd.gdpr.showPanel();
            }
        }

        pd.gdpr.sendCookiesConsentStatus();
        pd.gdpr.setCookiesInitSelection();
        pd.gdpr.setSaveCookiesSelection();
        pd.gdpr.setAcceptAll();
    },
    sendCookiesConsentStatus: () => {
        const cookie = utils.getCookie('pd-cookies');

        ga('send', 'event', 'Page', 'Cookies', (utils.getCookie('pd-cookies')) ? 1 : 0);

        if (!cookie) { return; }

        ga('send', 'event', 'Page', 'Cookies-preferences', (utils.getCookie('pd-cookies-preferences')) ? 1 : 0);
        ga('send', 'event', 'Page', 'Cookies-marketing', (utils.getCookie('pd-cookies-marketing')) ? 1 : 0);
        ga('send', 'event', 'Page', 'Cookies-analytics', (utils.getCookie('pd-cookies-analytics')) ? 1 : 0);
    },
    showPanel: () => {
        let msg = 'This page uses proprietary and third-party cookies to improve the user experience. You can activate all of them or configure their use.';
        let viewMoreLink = 'Set up.';
        let acceptLink = 'Activate all.';
        let configHref = `${_env.sitePath}/privacy-policy/#cookies-selection`;

        if (_env.siteLang === 'es') {
            msg = 'Usamos cookies propias y de terceros con fines analíticos y de personalización. Las puedes activar, configurar o rechazar.';

            acceptLink = 'Activar todas.';
            viewMoreLink = 'Configurar o rechazar.';
            configHref = `${_env.sitePath}/politica-de-privacidad/#cookies-selection`;
        }

        const html = `<div id='gdpr' class='fixed-bottom-msg'>
            <p class='small-txt'>
                <span>${msg}</span>
                <button class='bt bt-small bt-inverse js__cookies-accept-gdpr' id="accept-gdpr">${acceptLink}</button>
                <a class='bt bt-small' href="${configHref}">${viewMoreLink}</a>
            </p>
            </div>`;

        document.body.insertAdjacentHTML('beforeend', html);

        document.querySelector('.js__cookies-accept-gdpr').addEventListener('click', (e) => {
            e.preventDefault();
            pd.gdpr.hidePanel();
            pd.gdpr.accept();
        });
    },
    hidePanel: () => {
        document.getElementById('gdpr').classList.add('hidden');
    },
    accept: () => {
        pd.gdpr.hidePanel();
        utils.setCookie('pd-cookies', 1, 365);
        utils.setCookie('pd-cookies-preferences', 1, 365);
        utils.setCookie('pd-cookies-marketing', 1, 365);
        utils.setCookie('pd-cookies-analytics', 1, 365);

        location.reload();
    },
    setCookiesInitSelection: () => {
        if (utils.getCookie('pd-cookies-preferences')) {
            pd.gdpr.checkCookieType('preferences');
        }
        if (utils.getCookie('pd-cookies-marketing')) {
            pd.gdpr.checkCookieType('marketing');
        }
        if (utils.getCookie('pd-cookies-analytics')) {
            pd.gdpr.checkCookieType('analytics');
        }
    },
    checkCookieType: (type) => {
        const cookiesType = document.querySelector(`.js__cookie-type[id="cookie-type-${type}"]`);
        if (!cookiesType) { return; }

        cookiesType.checked = true;
    },
    setSaveCookiesSelection: () => {
        const saveTrigger = document.querySelector('.js__cookies-save');

        if (!saveTrigger) {
            return;
        }

        saveTrigger.addEventListener('click', (e) => {
            e.preventDefault();
            pd.gdpr.saveCookiesSelection();
        });
    },
    saveCookiesSelection: () => {
        const cookiesTypes = document.querySelectorAll('.js__cookie-type');

        cookiesTypes.forEach((cookiesType) => {
            const id = cookiesType.dataset.id;

            if (cookiesType.checked) {
                utils.setCookie(`pd-cookies-${id}`, 1, 365);
            } else {
                utils.deleteCookie(`pd-cookies-${id}`);
            }
        });

        utils.setCookie('pd-cookies', 1, 365);
        pd.gdpr.goBack();
    },
    goBack: () => {
        window.history.back();
    },
    setAcceptAll: () => {
        const acceptAllTrigger = document.querySelector('.js__cookies-accept-all');
        const rejectAllTrigger = document.querySelector('.js__cookies-reject-all');

        if (!acceptAllTrigger || !rejectAllTrigger) {
            return;
        }

        acceptAllTrigger.addEventListener('click', (e) => {
            e.preventDefault();
            pd.gdpr.checkAllTypes(true);
            pd.gdpr.saveCookiesSelection();
        });

        rejectAllTrigger.addEventListener('click', (e) => {
            e.preventDefault();
            pd.gdpr.checkAllTypes(false);
            pd.gdpr.saveCookiesSelection();
        });
    },
    checkAllTypes: (status) => {
        const cookiesTypes = document.querySelectorAll('.js__cookie-type');

        cookiesTypes.forEach((cookiesType) => {
            // eslint-disable-next-line no-param-reassign
            cookiesType.checked = status;
        });
    },
};

pd.gdpr.init();
