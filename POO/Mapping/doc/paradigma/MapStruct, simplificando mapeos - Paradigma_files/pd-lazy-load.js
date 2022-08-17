/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.lazy = {
    elems: '.lazy-img',
    init: (wrap = document) => {
        const lazyImages = [].slice.call(document.querySelectorAll(pd.lazy.elems));

        if (pd.lazy.checkInitLoad(lazyImages)) {
            return;
        }

        if ('IntersectionObserver' in window) {
            const lazyImageObserver = new IntersectionObserver((entries, observer) => {
                entries.forEach((entry) => {
                    if (entry.isIntersecting) {
                        pd.lazy.lazyLoad(entry.target);
                        lazyImageObserver.unobserve(entry.target);
                    }
                });
            });

            lazyImages.forEach((lazyImage) => {
                lazyImageObserver.observe(lazyImage);
            });
        } else {
            pd.lazy.loadImages(lazyImages);
        }
    },
    checkInitLoad: (images) => {
        // si se pone el parámetro ?nolazy=1 a la URL carga las imágenes desde el principo
        // lo usamos para la importación de Medium.
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        const nolazy = urlParams.get('nolazy');

        if (nolazy && nolazy === '1') {
            pd.lazy.loadImages(images);
            return true;
        }

        return false;
    },
    lazyLoad: (elem) => {
        elem.src = elem.dataset.src;
        if (elem.dataset.srcset) {
            elem.srcset = elem.dataset.srcset;
        }

        elem.classList.add('init');
    },
    loadImages: (images) => {
        images.forEach((image) => {
            const newSrc = image.getAttribute('data-src');
            image.setAttribute('src', newSrc);
            image.classList.add('lazy-transparent');
            image.classList.add('init');
        });
    },
};

pd.lazy.init();
