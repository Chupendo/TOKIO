/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.scroll = {
    const: {
        narrowDuration: 750,
        scrollDuration: 500,
        isNarrow: undefined,
        wheelEvent: {
            counter: 0,
            marker: true,
            interval: 50,
        },
    },
    init: (wrap) => {
        pd.scroll.initHeaderMode();
        pd.scroll.initAnchors();
        pd.scroll.setScrollToTop();
    },
    initHeaderMode: () => {
        pd.scroll.doc = document.documentElement;
        pd.scroll.setHeaderMode();
        window.addEventListener('scroll', pd.scroll.setHeaderMode, false);
    },
    getScrollPos: elem => (window.pageYOffset || elem.scrollTop) - (elem.clientTop || 0),
    smoothScroll: (data) => {
        if (!data.wrap) { data.wrap = document.documentElement; }
        if (!data.duration) { data.duration = 500; }

        // check si el navegador soporta el scroll smooth
        if (CSS.supports('scroll-behavior', 'smooth')) {
            data.wrap.scrollTo(0, data.to);

            pd.scroll.checkScrollEnd({
                to: data.to,
                wrap: data.wrap,
                maxDuration: data.duration,
                callback: data.callback,
            });
            return;
        }

        // solo se ejecuta si no soporta scroll smooth

        const interval = 10;

        // init object
        if (!data.steps) {
            data.steps = data.duration / interval;
            data.step = data.steps;
            data.from = pd.scroll.getScrollPos(data.wrap);
            data.distance = data.to - data.from;
        }

        data.step -= 1;

        const time = data.step / data.steps;
        let ease = time < 0.5 ? 2 * time * time : -1 + ((4 - (2 * time)) * time);
        ease = 1 - ease; // para que vaya de 0 a 1, y no de 1 a 0
        const newPos = data.from + (data.distance * ease);
        data.wrap.scrollTo(0, newPos);

        setTimeout(() => {
            if (data.step <= 0 || newPos === data.to || data.position === newPos) {
                data.wrap.scrollTo(0, data.to);
                if (data.callback) { data.callback(); }
                return;
            }
            data.position = newPos;
            pd.scroll.smoothScroll(data);
        }, interval);
    },
    checkWheelEnd: (e, cb) => {
        pd.scroll.const.wheelEvent.counter += 1;
        e = e||window.event;
        pd.scroll.const.wheelEvent.delta = e.deltaY || e.detail || e.wheelDelta;

        if (pd.scroll.const.wheelEvent.marker) pd.scroll.wheelStart(cb);
    },
    wheelStart: (cb) => {
        pd.scroll.const.wheelEvent.marker = false;
        pd.scroll.wheelCheck(cb);
    },
    wheelCheck: (cb) => {
        pd.scroll.const.wheelEvent.counterBis = pd.scroll.const.wheelEvent.counter;
        setTimeout(() => {
            if (pd.scroll.const.wheelEvent.counterBis === pd.scroll.const.wheelEvent.counter) {
                pd.scroll.wheelEnd(cb);
            } else {
                pd.scroll.wheelCheck(cb);
            }
        }, pd.scroll.const.wheelEvent.interval);
    },
    wheelEnd: (cb) => {
        pd.scroll.const.wheelEvent.marker = true;
        pd.scroll.const.wheelEvent.counter = 0;
        pd.scroll.const.wheelEvent.counterBis = 0;

        cb();
    },
    checkScrollEnd: (data) => {
        // !! TODO: Funciona mejor checkWheelEnd

        // volvemos a escuchar el scroll
        let tmpScroll;
        let prevScroll;
        let callbackExecuted = false;

        const checkScroll = setInterval(() => {
            tmpScroll = pd.scroll.getScrollPos(data.wrap);

            // hemos llegado al destino, o ya o hay más scroll que hacer
            if (data.to === tmpScroll || (prevScroll && prevScroll === tmpScroll)) {
                clearInterval(checkScroll);

                callbackExecuted = true;
                if (data.callback) {
                    // si no pongo el timeout me da problemas con pd-slider
                    // ya que al hacer scroll con el touchpad vuelve a ejecutar
                    // el scroll al terminar el smooth scroll
                    setTimeout(() => {
                        data.callback();
                    }, 200);
                }
            }
            prevScroll = tmpScroll;
        }, 50);

        // debido a bug con firefox al pasar a la primera slide
        setTimeout(() => {
            if (!callbackExecuted) {
                if (data.callback) { data.callback(); }
                clearInterval(checkScroll);
            }
        }, data.maxDuration);
    },
    setHeaderMode: () => {
        const scrollTop = (window.pageYOffset || pd.scroll.doc.scrollTop) - (pd.scroll.doc.clientTop || 0);

        if (scrollTop === 0 && pd.scroll.headerNarrow) {
            pd.scroll.headerNarrow = false;
            document.body.classList.remove('header-narrow');
        }

        if (scrollTop > 0 && !pd.scroll.headerNarrow) {
            pd.scroll.headerNarrow = true;
            document.body.classList.add('header-narrow');
        }

        if (scrollTop < pd.scroll.pdScroll) {
            document.body.classList.add('moving-up');
        } else {
            document.body.classList.remove('moving-up');
        }

        pd.scroll.pdScroll = scrollTop;
    },
    initAnchors: () => {
        document.querySelectorAll('a[href^="#"').forEach((link) => {
            if (link.getAttribute('href').length === 1) {
                return;
            }
            link.addEventListener('click', (e) => {
                e.preventDefault();
                pd.scroll.anchorLinkCurrentName = pd.scroll.getAnchorName(link);

                pd.scroll.goToAnchor();
            });
        });
    },
    // eslint-disable-next-line arrow-body-style
    getAnchorName: (elem) => {
        return elem.getAttribute('href').substring(1);
    },
    goToAnchor: () => {
        const offsetTop = 100;
        let selector = document.querySelector(`[name="${pd.scroll.anchorLinkCurrentName}"]`);

        if (!selector) {
            selector = document.querySelector(`#${pd.scroll.anchorLinkCurrentName}`);
        }

        if (!selector) { return; }

        const top = utils.offset(selector).top - offsetTop;
        pd.scroll.smoothScroll({to: top});

        delete pd.scroll.anchorLinkCurrentName;
    },
    scrollTo: (top, cb) => {
        pd.scroll.smoothScroll({
            to: top,
            duration: pd.scroll.const.scrollDuration,
            callback: cb,
        });
    },
    isScrollEnabled: (e, listener, cb) => {
        pd.scroll.move = pd.scroll.getMove(e);

        if (!pd.scroll.move) {
            if (listener) {
                listener();
            }
            return;
        }

        cb();
    },
    getScrollmove: (e) => {
        const st = window.pageYOffset || document.documentElement.scrollTop;
        let direction = 'up';

        if (st > pd.scroll.scrollPos) {
            direction = 'down';
        }

        pd.scroll.scrollPos = st <= 0 ? 0 : st; // For Mobile or negative scrolling
        return direction;
    },
    getMove: (e) => {
        let delta = 0;
        let move = false;

        if (e && e.deltaY) {
            delta = Math.sign(e.deltaY);

            if (delta > 0) {
                move = 'down'; // baja
            } else {
                move = 'up'; // sube
            }

            return move;
        }

        if (e && e.keyCode) {
            switch (e.keyCode) {
            case 37: // left
            case 38:
                move = 'up'; // sube
                break;
            case 39: // right
            case 40:
                move = 'down'; // baja
                break;
            default:
                break;
            }
        }

        return move;
    },
    setScrollToTop: () => {
        if (document.getElementById('scroll-top-top-trigger')) {
            return;
        }

        const link = document.createElement('BUTTON');
        link.setAttribute('id', 'scroll-top-top-trigger');
        link.setAttribute('class', 'hide');

        document.body.appendChild(link);

        link.addEventListener('click', (e) => {
            e.preventDefault();

            pd.scroll.smoothScroll({to: 0});

            link.classList.add('hide');
        });

        pd.scroll.watchToShowScrollToTop();
    },
    watchToShowScrollToTop: () => {
        pd.scroll.scrollToTopLimit = window.innerHeight * 2;

        let scrollToTopCheckInterval = 0;
        window.addEventListener('scroll', () => {
            clearTimeout(scrollToTopCheckInterval);
            scrollToTopCheckInterval = setTimeout(() => {
                const top = pd.scroll.getScrollPos(document.documentElement);

                if (top > pd.scroll.scrollToTopLimit) {
                    document.getElementById('scroll-top-top-trigger').classList.remove('hide');
                } else {
                    document.getElementById('scroll-top-top-trigger').classList.add('hide');
                }
            }, 300);
        });
    },
};

pd.scroll.init();
