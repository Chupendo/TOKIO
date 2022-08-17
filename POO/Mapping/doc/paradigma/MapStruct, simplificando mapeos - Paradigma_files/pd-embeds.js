/* global pd, twttr */

pd.embeds = {
    types: [
        {
            // convertir una URL de un tweet en un tweet con el estilo de Twitter
            regexp: /https:\/\/twitter.com\/.*?\/status\/.*?$/,
            callback: 'parseEmbedTweet',
        },
    ],
    flags: {},
    init: (wrap) => {
        wrap.querySelectorAll('p').forEach((p) => {
            const embedHTML = pd.embeds.parseEmbeds(p, wrap);

            if (embedHTML) {
                p.innerHTML = embedHTML;
            }
        });
    },
    parseEmbeds: (elem, wrap) => {
        let embedHTML = false;
        // solo parsear los que tengan como contenido del párrafo UNICAMENTE un link.
        if (elem.childNodes && elem.childNodes.length === 1 && elem.childNodes[0].tagName === 'A') {
            pd.embeds.types.forEach(async (type) => {
                const url = pd.embeds.removeHtmlTagsFromString(elem.innerHTML);

                if (url.match(type.regexp)) {
                    // el contenido tiene un enlace de Twitter que debe de ser parseado
                    // cargamos las dependencias.
                    if (!pd.embeds.flags.loadingTwitter) {
                        pd.embeds.loadDependencies();
                    }

                    // check for dependencies
                    if (typeof twttr === 'undefined' || typeof twttr.widgets === 'undefined') {
                        setTimeout(() => pd.embeds.init(wrap), 100);
                        return;
                    }

                    embedHTML = await pd.embeds[type.callback](elem, url);

                    if (embedHTML) {
                        return embedHTML;
                    }
                }
            });
        }

        return embedHTML;
    },
    parseEmbedTweet: async (elem, url) => {
        const urlSplit = url.split('/');
        const tweetId = urlSplit[urlSplit.length - 1];
        elem.innerHTML = '';

        twttr.widgets.createTweet(tweetId, elem);
    },
    removeHtmlTagsFromString: (string) => {
        let str = string.replace(/<.*?>/gm, '');
        str = str.replace(/\n/gm, '');
        str = str.trim();
        return str;
    },
    loadDependencies: () => {
        pd.embeds.flags.loadingTwitter = true;

        window.twttr = (function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0],
              t = window.twttr || {};
            if (d.getElementById(id)) return t;
            js = d.createElement(s);
            js.id = id;
            js.src = "https://platform.twitter.com/widgets.js";
            fjs.parentNode.insertBefore(js, fjs);

            t._e = [];
            t.ready = function(f) {
              t._e.push(f);
            };

            return t;
          }(document, "script", "twitter-wjs"));
    },
};

pd.embeds.init(document.querySelector('#blog-detail .cms-content'));
