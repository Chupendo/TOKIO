/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.iframes = {
    init: () => {
        pd.iframes.autoHeight();
    },
    autoHeight: () => {
        // Setting Iframe Height: Cross-Domain Version
        // https://www.dyn-web.com/tutorials/iframes/postmessage/height/

        // Create browser compatible event handler.
        const eventMethod = window.addEventListener ? 'addEventListener' : 'attachEvent';
        const eventer = window[eventMethod];
        const messageEvent = eventMethod == 'attachEvent' ? 'onmessage' : 'message';
        // Listen for a message from the iframe.
        eventer(messageEvent, (e) => {
            // replace #sizetracker with what ever what ever iframe id you need
            const iframe = document.getElementById(e.data.id);
            if (iframe) {
                iframe.style.height = `${e.data.height}px`;
            }
        }, false);
    },
};

pd.iframes.init();
