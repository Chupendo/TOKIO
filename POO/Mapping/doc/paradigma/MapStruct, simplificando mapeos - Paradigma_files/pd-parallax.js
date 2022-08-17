/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.parallax = {
    groups: [
        {
            display: 'desktop', // solo se activa con más de 768px
            options: {
                rootMargin: '0px',
                threshold: 0,
            },
            // selector: '.parallax-wrap .parallax-item, .group--columns-rightParallax > div:last-child',
            selector: '.parallax-wrap .parallax-item, .group--columns-rightParallax > div:last-child, .group--columns-rightParallax-noMargin > div:last-child',
            callback: (elems) => {
                const transformOffset = 0.25; // el elemento al desaparecer no está en 0, está en -30 aprox (depende de la altura)
                const totalMove = 250; // 165px en la parte más baja, -62px en la más alta

                elems.forEach((elem) => {
                    const topPercentage = Math.min(pd.parallax.getElemPosition(elem) / 100, 1);
                    const top = (topPercentage - transformOffset) * totalMove;

                    pd.parallax.setTransform(elem, top, 0, 'px');
                });
            },
        },
        {
            display: 'all', // solo se activa con más de 768px
            options: {
                rootMargin: '0px',
                threshold: 0,
            },
            selector: '.parallax-title',
            callback: (elems) => {
                const transformOffset = -80; // el elemento al desaparecer no está en 0, está en -30 aprox (depende de la altura)
                const transformRatio = 0.2; // limita la cantidad a desplazar

                elems.forEach((elem) => {
                    const topPercentage = pd.parallax.getElemPosition(elem);
                    const left = (topPercentage + transformOffset) * transformRatio;
                    pd.parallax.setTransform(elem, 0, left, '%');
                });
            },
        },
        {
            display: 'desktop', // solo se activa con más de 768px
            options: {
                rootMargin: '0px',
                threshold: 0,
            },
            selector: '.block-title-cols .group-item:nth-child(2n)',
            callback: (elems) => {
                const transformOffset = 0; // el elemento al desaparecer no está en 0, está en -30 aprox (depende de la altura)
                const transformRatio = 0.25; // limita la cantidad a desplazar

                elems.forEach((elem) => {
                    const topPercentage = pd.parallax.getElemPosition(elem);
                    const top = (topPercentage + transformOffset) * transformRatio;
                    pd.parallax.setTransform(elem, top, 0, '%');
                });
            },
        },
        {
            display: 'desktop', // solo se activa con más de 768px
            options: {
                rootMargin: '200px',
                threshold: 0,
            },
            selector: '.group.group--carousel > div, .group.group--carousel-collapse > div',
            callback: (elems) => {
                const transformOffset = 0.15; // el elemento al desaparecer no está en 0, está en -30 aprox (depende de la altura)
                let totalMove;

                elems.forEach((elem, index) => {
                    switch (index) {
                    case 0:
                        totalMove = 250; break;
                    case 1:
                        totalMove = 150; break;
                    case 2:
                        totalMove = 350; break;
                    case 3:
                        totalMove = 50; break;
                    default:
                        totalMove = 250; break;
                    }
                    const topPercentage = pd.parallax.getElemPosition(elem) / 100;
                    const top = (topPercentage - transformOffset) * totalMove;
                    pd.parallax.setTransform(elem, top, 0, 'px');
                });
            },
        },
    ],
    init: (wrap) => {
        pd.parallax.groups.forEach((group) => {
            group.elems = wrap.querySelectorAll(group.selector);

            if (group.display === 'desktop' && window.outerWidth <= 768) {
                return;
            }

            if (group.elems) {
                if ('IntersectionObserver' in window) {
                    // cada vez que un elemento entre o salga del viewport llama al callback
                    group.observer = new IntersectionObserver((entries) => {
                        // se actulizará con los elementos visibles en el viewport
                        if (!group.visibleElems) {
                            group.visibleElems = [];
                        }

                        Array.prototype.slice.call(entries).forEach((entry) => {
                            if (entry.intersectionRatio > group.options.threshold) {
                                // un elemento entra en el viewport
                                group.visibleElems.push(entry.target);
                            } else {
                                // un elemento sale del viewport
                                const index = group.visibleElems.indexOf(entry.target);
                                if (index > -1) {
                                    group.visibleElems.splice(index, 1);
                                }
                            }
                        });

                        if (!group.scrollWatchStarted) {
                            group.callback(group.visibleElems);
                            window.addEventListener('wheel', () => {
                                group.callback(group.visibleElems);

                                group.visibleElems.forEach((elem) => {
                                    setTimeout(() => {
                                        elem.classList.add('parallax-started');
                                    }, 500, elem);
                                });
                            });
                            window.addEventListener('scroll', () => {
                                group.callback(group.visibleElems);

                                group.visibleElems.forEach((elem) => {
                                    setTimeout(() => {
                                        elem.classList.add('parallax-started');
                                    }, 500, elem);
                                });
                            });

                            group.scrollWatchStarted = true;
                        }
                    }, group.options);

                    group.elems.forEach((elem) => {
                        elem.classList.add('parallax-init');
                        group.observer.observe(elem);
                    });
                }
            }
        });
    },
    getElemPosition: (elem) => {
        // these are relative to the viewport
        const viewportHeight = window.outerHeight;
        const viewportOffset = elem.getBoundingClientRect();

        return parseInt((viewportOffset.top * 100) / viewportHeight, 10);
    },
    setTransform: (elem, top, left, measure) => {
        elem.setAttribute('style', `transform: translate3d(${left}${measure}, ${top}${measure}, 0); -webkit-transform: translate3d(${left}${measure}, ${top}${measure}, 0)`);
    },
};

pd.parallax.init(document);
