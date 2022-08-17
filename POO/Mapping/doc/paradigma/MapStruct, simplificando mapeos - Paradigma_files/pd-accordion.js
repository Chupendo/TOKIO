/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.accordion = {
    const: {slideElemSelector: '.pd-accordion-slide-on-active'},
    init: (wrap = document) => {
        // check for dependencies
        if (typeof utils === 'undefined' || typeof pd.swipe === 'undefined') {
            setTimeout(() => pd.accordion.init(wrap), 300);
            return;
        }

        pd.accordion.is_touch_device = utils.is_touch_device();

        pd.accordion.prepareAccordionBlocks(wrap);

        if (pd.accordion.is_touch_device) {
            pd.accordion.initTouchableAccordion(wrap);
        } else {
            pd.accordion.initDesktopAccordion(wrap);
        }
    },
    initTouchableAccordion: (wrap) => {
        const accordions = wrap.querySelectorAll('.pd-accordion');

        accordions.forEach((accordion) => {
            const items = accordion.querySelectorAll('.pd-accordion-item');

            if (!items.length) { return; }

            const itemsWrap = document.createElement('div');
            itemsWrap.classList.add('itemsWrap');
            items[0].parentNode.insertBefore(itemsWrap, items[0]);

            const pagination = document.createElement('div');
            pagination.classList.add('pagination');
            items[0].parentNode.insertBefore(pagination, items[0]);


            items.forEach((item, index) => {
                item.dataset.itemIndex = index + 1;
                itemsWrap.appendChild(item);
                pagination.innerHTML += `<a data-page="${index + 1}"></a>`;
            });

            // Set first item as selected
            if (accordion.getAttribute('accordion-init-active')) {
                const initActive = items[accordion.getAttribute('accordion-init-active')];
                initActive.classList.remove('active-anim');
                pd.accordion.setActiveItem(accordion, initActive);
            }

            pd.swipe.set(itemsWrap, pd.accordion.swipeItem, accordion);
            pd.accordion.setPagination(accordion, itemsWrap, pagination);
        });
    },
    setPagination: (accordion, itemsWrap, pagination) => {
        pagination.querySelectorAll('a').forEach((pag) => {
            pag.addEventListener('click', (e) => {
                e.preventDefault();
                const goTo = parseInt(pag.dataset.page, 10);
                const current = parseInt(accordion.dataset.currentItem, 10);

                console.log('current', current, goTo);
                if (current === goTo) {
                    return;
                }

                const activeItem = itemsWrap.querySelector('.item.active');

                pd.accordion.swipeTo(accordion, itemsWrap, goTo - 1, activeItem);
            });
        });
    },
    swipeItem: (move, itemsWrap, accordion) => {
        if (move === 'up' || move === 'down') {
            return;
        }

        let activeItem = itemsWrap.querySelector('.item.active');

        if (!activeItem) {
            activeItem = itemsWrap.querySelector('.item');
        }
        const activeIndex = parseInt(activeItem.dataset.itemIndex, 10);
        let newIndex;
        const totalItems = itemsWrap.childNodes.length;

        if (activeIndex === totalItems && move === 'left') {
            return;
        }

        if (activeIndex === 1 && move === 'right') {
            return;
        }

        if (move === 'left') {
            newIndex = activeIndex + 1;
        } else if (move === 'right') {
            newIndex = activeIndex - 1;
        }

        pd.accordion.swipeTo(accordion, itemsWrap, newIndex - 1, activeItem);
    },
    swipeTo: (accordion, itemsWrap, goto, activeItem) => {
        itemsWrap.setAttribute('style', `transform: translate3d(-${((goto) * 100) - 10}%, 0, 0)`);
        if (activeItem) {
            activeItem.classList.remove('active', 'active-anim');
        }

        const newItem = itemsWrap.childNodes[goto];
        newItem.classList.add('active');
        newItem.classList.add('active-anim');
        pd.accordion.setCurrentPage(accordion, goto + 1);
        pd.accordion.changeBackground(accordion, newItem);
    },
    initDesktopAccordion: (wrap) => {
        pd.accordion.setElementsHeight(wrap);
        //This timeout is to fix bug in Firefox
        setTimeout(() => {
            pd.accordion.setElementsHeight(wrap);
        }, 0);

        const accordions = wrap.querySelectorAll('.pd-accordion');

        accordions.forEach((accordion) => {
            const items = accordion.querySelectorAll('.pd-accordion-item');

            items.forEach((item) => {
                item.addEventListener('mouseover', () => {
                    pd.accordion.setActiveItem(accordion, item);
                }, false);
            });

            // Set first item as selected
            if (accordion.getAttribute('accordion-init-active')) {
                const initActive = items[accordion.getAttribute('accordion-init-active')];
                if (initActive) {
                    initActive.classList.remove('active-anim');
                    pd.accordion.setActiveItem(accordion, initActive);
                }
            }

            // Set first item as selected
            if (!accordion.getAttribute('accordion-keep-active') || accordion.getAttribute('accordion-keep-active') === 'false') {
                accordion.addEventListener('mouseleave', () => {
                    pd.accordion.resetActiveItem(accordion);
                }, false);
            }
        });
    },
    prepareAccordionBlocks: (wrap) => {
        // convertir los bloques de acordeon que vienen del CMS
        wrap.querySelectorAll('.group--accordion').forEach((accordion) => {
            accordion.classList.add('block', 'block-accordion', 'pd-accordion', '-full-width');
            accordion.setAttribute('accordion-init-active', '0');
            accordion.setAttribute('accordion-keep-active', 'true');

            let addBackgroundsInResp = false;

            accordion.querySelectorAll('.block-accordion-item:not([data-index]').forEach((item, index) => {
                item.dataset.index = index + 1;
                if (pd.accordion.is_touch_device && item.querySelector('img')) {
                    addBackgroundsInResp = true;
                }
            });

            // en escritorio hay items con dos fotos dentro. En móvil mostramos solo 1 foto a tamaño completo
            if (addBackgroundsInResp) {
                accordion.querySelectorAll('.block-accordion-item').forEach((item, index) => {
                    const originImg = item.querySelector('img');
                    if (!originImg) {
                        return;
                    }

                    const bgNode = document.createElement('DIV');
                    bgNode.classList.add('bg', 'pd-accordion-bg');
                    bgNode.dataset.index = index + 1;

                    bgNode.appendChild(originImg);
                    accordion.appendChild(bgNode);
                });
                pd.lazy.init(accordion);
            }
        });
    },
    resetActiveItem: (accordion) => {
        const prevActives = accordion.querySelectorAll('.active-anim');

        prevActives.forEach((prevActive) => {
            pd.accordion.slideUpItem(prevActive);
        });
    },
    setActiveItem: (accordion, item) => {
        if (item.classList.contains('active-anim')) { return; }

        pd.accordion.resetActiveItem(accordion);
        const itemContent = item.querySelector(pd.accordion.const.slideElemSelector);

        pd.accordion.setCurrentPage(accordion, item.dataset.index);
        pd.accordion.slideDownItem(item, itemContent);
        pd.accordion.changeBackground(accordion, item);
    },
    setCurrentPage: (accordion, index) => {
        accordion.dataset.currentItem = index;

        const pagination = accordion.querySelector('.pagination');

        if (pagination) {
            const prev = pagination.querySelector('a.active');
            if (prev) { prev.classList.remove('active'); }
            pagination.querySelectorAll('a')[index - 1].classList.add('active');
        }
    },
    slideDownItem: (item, itemContent) => {
        item.classList.add('active');
        item.classList.add('active-anim');

        setTimeout(() => {
            itemContent.style.height = `${itemContent.dataset.height}px`;
        }, 100);
    },
    slideUpItem: (item) => {
        item.classList.remove('active');

        const itemContent = item.querySelector(pd.accordion.const.slideElemSelector);

        itemContent.style.height = '0px';
        setTimeout(() => {
            item.classList.remove('active-anim');
            item.classList.remove('active');
            itemContent.removeAttribute('style');
        }, 500);
    },
    changeBackground: (accordion, item) => {
        const index = item.dataset.index;

        const bgPanel = accordion.querySelector(`.pd-accordion-bg[data-index="${index}"]`);

        if (!bgPanel) { return; }

        const prevBgPanel = accordion.querySelector('.pd-accordion-bg.visible');

        if (prevBgPanel) {
            prevBgPanel.classList.remove('visible');
        }

        setTimeout(() => {
            bgPanel.classList.add('visible');
        }, 500);
    },
    getElementHeight: (elem) => {
        elem.classList.add('check-elem-height');
        // elem.removeAttribute('style');
        const itemHeight = elem.offsetHeight;
        elem.classList.remove('check-elem-height');
        return itemHeight;
    },
    setElementsHeight: (wrap) => {
        const elems = wrap.querySelectorAll(pd.accordion.const.slideElemSelector);

        elems.forEach((elem) => {
            const height = pd.accordion.getElementHeight(elem);
            elem.dataset.height = height;
        });

        let checkHeightResize = 0;
        window.addEventListener('resize', () => {
            clearTimeout(checkHeightResize);
            checkHeightResize = setTimeout(() => {
                pd.accordion.setElementsHeight(wrap);
            }, 300);
        });
    },
};

pd.accordion.init();

