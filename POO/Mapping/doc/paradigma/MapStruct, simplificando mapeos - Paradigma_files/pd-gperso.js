/* global _env, utils, pd, ga */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

function createEditorsPickItem(item, sitePath) {
    const {category, slug, title} = item;
    const editorPicksElement = `
        <li class="editors-picks__card-item">
            <a href="${sitePath}/${category}/${slug}/?prs=1" class="editors-picks__card-item-link">
                <div class="editors-picks__card-item-category">${category}</div>
                <h4 class="editors-picks__card-item-title">${title}</h4>
            </a>
        </li>
    `;
    return editorPicksElement;
}

function getEditorPicksToShow(data, max, sitePath) {
    const results = [];
    for (let i = 0; i < data.length && results.length < max; i++) {
        if (data[i]) results.push(createEditorsPickItem(data[i], sitePath));
    }
    return results.join('');
}

pd.gperso = {
    selectors: {
        gPersoWrap: document.querySelector('.gPerso'),
        editorsPicks: document.querySelector('.js__editors-picks'),
        postList: document.querySelector('.js__personalisation-posts'),
    },
    drawEditorPicksTimeout: false,
    drawEditorPicksRetry: 0,
    drawPostResultsTimeout: false,
    drawPostResultsRetry: 0,
    init: () => {
        const gPersoWrap = pd.gperso.selectors.gPersoWrap;

        // que solo actue si tenemos la clase gPerso en el body
        if (!gPersoWrap) {
            return;
        }

        const postList = pd.gperso.selectors.postList;
        // postList && pd.gperso.loadPostList(postList);

        const edPicks = pd.gperso.selectors.editorsPicks;
        edPicks && pd.gperso.showEditorPicks(gPersoWrap, edPicks);
    },
    loadPostList: (postList) => {
        if (!utils.getCookie('pd-cookies-analytics')) {
            return false;
        }

        const clientId = pd.gperso.getGaClientId(); // '1332398944.1576593734';

        if (!clientId) {
            if (typeof pd.track !== 'undefined') {
                pd.track.events.eventPersonalization('Page', false);
            }
            return false;
        }

        const endPoint = `${postList.dataset.gpersoFetch}${clientId}`;
        const itemsPerPage = 10;

        fetch(endPoint)
            .then(response => response.json())
            .then((json) => {
                const items = json.filter(el => el != null);

                if (items.length < itemsPerPage) {
                    if (typeof pd.track !== 'undefined') {
                        pd.track.events.eventPersonalization('Page', false);
                    }
                    return;
                }

                items.forEach((item) => {
                    // eslint-disable-next-line no-param-reassign
                    item.image = pd.gperso.setPostImage(item);
                });

                pd.gperso.drawFilteredResults(items, itemsPerPage);
            })
            .catch((error) => {
                if (typeof pd.track !== 'undefined') {
                    pd.track.events.eventPersonalization('Page', false);
                }

                console.error(`Hubo un problema con la petición Fetch: ${error.message}`);
            });

        return true;
    },
    postHasColumns: (wrap) => {
        const postColumns = wrap.querySelector('#blog-detail-content .group--columns');

        if (postColumns) {
            return true;
        }

        return false;
    },
    showEditorPicks: (wrap, edPicks) => {
        const contentElem = wrap.querySelector('#blog-detail-content');
        if (!contentElem) { return; }

        const postID = contentElem.dataset.postId;
        const endPoint = contentElem.dataset.gpersoFetch;

        if (pd.gperso.postHasColumns(wrap)) {
            return;
        }

        if (!postID || !endPoint) {
            if (typeof pd.track !== 'undefined') {
                pd.track.events.eventPersonalization('Widget', false);
            }
            return;
        }

        fetch(`${endPoint}${postID}`)
            .then(response => response.json())
            .then((json) => {
                //console.log('RESULTADO DE RECOMENDACIÓN DE GOODLY', json);
                const maxEditorPicks = 2;
                const {sitePath} = _env;
                const picks = getEditorPicksToShow(json, maxEditorPicks, sitePath);

                if (picks) {
                    pd.gperso.drawEditorPicks(wrap, edPicks, picks);
                } else {
                    pd.track.events.eventPersonalization('Widget', false);
                }
            })
            .catch((error) => {
                pd.track.events.eventPersonalization('Widget', false);
                console.error(`Hubo un problema con la petición Fetch: ${error.message}`);
            });
    },
    drawEditorPicks: (wrap, edPicks, picks) => {
        pd.gperso.drawEditorPicksRetry += 1;

        if (typeof pd.track === 'undefined') {
            if (pd.gperso.drawEditorPicksRetry > 10) {
                pd.track.events.eventPersonalization('Widget', false);
            } else {
                pd.gperso.drawEditorPicksTimeout = setTimeout(() => {
                    pd.gperso.drawEditorPicks(wrap, edPicks, picks);
                }, 200);
            }
        } else {
            clearTimeout(pd.gperso.drawEditorPicksTimeout);
            edPicks.querySelector('.js__editors-picks-list').innerHTML = picks;
            edPicks.classList.add('editors-picks--active');
            wrap.querySelector('.cms-content').classList.add('cms-content--editors-picks');

            pd.track.events.eventPersonalization('Widget', true);
        }
    },
    getCookie: (name) => {
        const value = `; ${document.cookie}`;
        const parts = value.split(`; ${name}=`);
        if (parts.length === 2) {
            return parts.pop().split(';').shift();
        }
        return false;
    },
    getGaClientId: () => {
        // la nuevo forma de gestionar Google Analytics sin cookies
        const localStorageCliendId = window.localStorage.getItem('googleAnalyticsClientId');
        // https://jnjsite.com/como-hacer-que-google-analytics-no-use-cookies-y-otras-configuraciones/

        if (localStorageCliendId && localStorageCliendId !== 'undefined') {
            return localStorageCliendId;
        }

        if (!ga || !ga.getAll()[0]) {
            // Puede llegar aquí cuando tienes un bloqueador de anuncios.

            // intentamos obtener la cookie de Analytics
            try {
                const cookie = pd.gperso.getCookie('_ga');
                if (!cookie) { return false; }
                const cookieValue = cookie.split('.');
                if (cookieValue[2] && cookieValue[2] === 'undefined') {
                    return false;
                }

                return `${cookieValue[2]}.${cookieValue[3]}`;
            } catch (e) {
                console.warn('No Universal Analytics cookie found');
                return false;
            }
        }

        if (localStorageCliendId === 'undefined') {
            return false;
        }

        return ga.getAll()[0].get('clientId');
    },
    setPostImage: (item) => {
        if (!item.image) {
            // eslint-disable-next-line no-param-reassign
            item.image = `${_env.assetsPath}${_env.defaultPostImg}`;

            return `<img src="${_env.assetsPath}img/defaults/lazy-load.svg"
              data-src="${item.image}"
              class="lazy-img"
              data-srcset="${item.image} 1920w,${item.image} 1280w,${item.image} 910w,${item.image} 455w"
              sizes="(min-width: 768px) 40vw, 100vw"
              alt="${item.title}" />`;
        }

        const paths = {
            huge: `${_env.assetsPath}img/resize/huge/${item.image}`,
            big: `${_env.assetsPath}img/resize/big/${item.image}`,
            medium: `${_env.assetsPath}img/resize/medium/${item.image}`,
            small: `${_env.assetsPath}img/resize/small/${item.image}`,
            mediumCropped: `${_env.assetsPath}img/resize/cropped-medium/${item.image}`,
            smallCropped: `${_env.assetsPath}img/resize/cropped-small/${item.image}`,
        };

        return `<img src="${_env.assetsPath}img/defaults/lazy-load.svg"
          data-src="${paths.small}"
          class="lazy-img"
          data-srcset="${paths.huge} 1920w,${paths.big} 1280w,${paths.medium} 910w,${paths.small} 455w"
          sizes="(min-width: 768px) 40vw, 100vw"
          alt="${item.title}" />`;
    },
    drawFilteredResults: (items, itemsPerPage) => {
        pd.gperso.drawPostResultsRetry += 1;

        if (typeof pd.blogFilters === 'undefined' || typeof pd.track === 'undefined') {
            if (pd.gperso.drawPostResultsRetry > 10) {
                pd.track.events.eventPersonalization('Page', false);
            } else {
                pd.gperso.drawPostResultsTimeout = setTimeout(() => {
                    pd.gperso.drawFilteredResults(items);
                }, 200);
            }
        } else {
            clearTimeout(pd.gperso.drawPostResultsTimeout);
            pd.blogFilters.drawFilteredResults(items.slice(0, itemsPerPage), 0, false);
            // pd.blogFilters.setSeeMoreLink(response);
            pd.gperso.addPersoParamToPostLinks();
            pd.track.events.eventPersonalization('Page', true);
        }
    },
    addPersoParamToPostLinks: () => {
        const blogItems = document.querySelectorAll('#blogList .blog-item');

        blogItems.forEach((item) => {
            const link = item.querySelector('a');
            link.setAttribute('href', `${link.getAttribute('href')}?prs=1`);
        });
    },
};

pd.gperso.init();
