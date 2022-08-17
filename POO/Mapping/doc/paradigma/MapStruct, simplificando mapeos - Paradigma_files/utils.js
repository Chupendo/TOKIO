/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

// eslint-disable-next-line no-unused-vars
const utils = {
    offset: (el, parentElem) => {
        const rect = el.getBoundingClientRect();
        const scrollLeft = window.pageXOffset || document.documentElement.scrollLeft;
        let scrollTop;
        if (parentElem) {
            scrollTop = window.pageYOffset || document.getElementById(parentElem).scrollTop || document.documentElement.scrollTop;
        } else {
            scrollTop = window.pageYOffset || document.documentElement.scrollTop;
        }

        return {
            top: rect.top + scrollTop,
            left: rect.left + scrollLeft,
            bottom: rect.bottom + scrollTop,
        };
    },
    fullOffsetTop: (elem) => {
        let offsetTop = 0;
        // eslint-disable-next-line no-cond-assign
        do {
            // eslint-disable-next-line no-restricted-globals
            if (!isNaN(elem.offsetTop)) {
                offsetTop += elem.offsetTop;
            }
        // eslint-disable-next-line no-param-reassign
        } while ((elem = elem.offsetParent));

        return offsetTop;
    },
    isBottomOfElemIntoView(el, offset = 0) {
        const rect = el.getBoundingClientRect();
        const elemBottom = parseInt(rect.bottom, 10);
        const isVisible = (elemBottom + (window.innerHeight * offset)) <= window.innerHeight && elemBottom > 0;

        return isVisible;
    },
    isTopOfElemIntoView(el, offset = 0) {
        const rect = el.getBoundingClientRect();
        const elemTop = parseInt(rect.top, 10);
        const isVisible = (elemTop - (window.innerHeight * offset)) >= 0;

        return isVisible;
    },
    isElemInViewport(el) {
        let top = el.offsetTop;
        const width = el.offsetWidth;
        const height = el.offsetHeight;

        while (el.offsetParent) {
            // eslint-disable-next-line no-param-reassign
            el = el.offsetParent;
            top += el.offsetTop;
        }

        return (
            top < (window.pageYOffset + window.innerHeight) &&
            (top + height) > window.pageYOffset
        );
    },
    isDescendant(matchTags, elem) {
        let node = elem;
        while (node != null) {
            if (matchTags.includes(node.tagName)) {
                return true;
            }
            node = node.parentNode;
        }
        return false;
    },
    isDescendantClass(matchClasses, elem) {
        let node = elem;
        while (node != null) {
            for (let i = 0; i < matchClasses.length; i++) {
                const matchClass = matchClasses[i];

                if (node.classList && node.classList.contains(matchClass)) {
                    return true;
                }
            }

            node = node.parentNode;
        }
        return false;
    },
    is_touch_device() {
        const prefixes = ' -webkit- -moz- -o- -ms- '.split(' ');
        const mq = query => window.matchMedia(query).matches;

        if (('ontouchstart' in window) || (window.DocumentTouch && document instanceof DocumentTouch)) {
            document.body.classList.add('-touchable');
            return true;
        }

        // include the 'heartz' as a way to have a non matching MQ to help terminate the join
        // https://git.io/vznFH
        const query = ['(', prefixes.join('touch-enabled),('), 'heartz', ')'].join('');

        const touchable = mq(query);

        if (touchable) {
            document.body.classList.add('-touchable');
        } else {
            document.body.classList.add('-untouchable');
        }
        return touchable;
    },
    executeFn(name) {
        const namespaces = name.split('.');
        let context = pd;

        if (namespaces.length === 1) {
            return context[namespaces[0]].apply();
        }

        for (let i = 0; i < namespaces.length; i++) {
            context = context[namespaces[i]];
            // si la función no existe que no se rompa
            if (context == null) {
                context = false;
                return false;
            }
        }
        return context.apply();
    },
    setCookie(cname, cvalue, exdays) {
        const d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));

        const expires = `expires=${d.toUTCString()}`;
        document.cookie = `${cname}=${cvalue};${expires};path=/`;
    },
    deleteCookie(cname) {
        document.cookie = `${cname}=0;expires=Thu, 01 Jan 1970 00:00:00 GMT;path=/`;
    },
    getCookie(cname) {
        const name = `${cname}=`;
        const decodedCookie = decodeURIComponent(document.cookie);
        const ca = decodedCookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) === ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) === 0) {
                return c.substring(name.length, c.length);
            }
        }
        return '';
    },
    checkLastDot(string) {
        // const regexp = /[a-zA-Z ]+$/gm;

        // if (string.match(regexp)) {
        //     return true;
        // }
        // return false;

        if (!string) {
            return false;
        }

        const endCharRegexp = /[a-zA-Z0-9€$"'`ºª@#%&()=*^[\]+\-{}_<> ]+$/gm;
        const endWordRegexp = /(?:\.com|\.net|\.org|\.es)$/;

        if (!string.match(endCharRegexp) || string.match(endWordRegexp)) {
            return false;
        }

        return true;
    },
    showLogoToDownload() {
        const logoModal = document.querySelector('#logoContextMenu');


        if (!logoModal) { return; }

        document.querySelector('#header-logo').addEventListener('contextmenu', (e) => {
            if (window.innerWidth > 768) {
                e.preventDefault();
                logoModal.classList.remove('hidden');
                return false;
            }
        });

        logoModal.addEventListener('click', (e) => {
            if (logoModal === e.target) {
                e.preventDefault();
                logoModal.classList.add('hidden');
            }
        });
    },
};

utils.showLogoToDownload();
