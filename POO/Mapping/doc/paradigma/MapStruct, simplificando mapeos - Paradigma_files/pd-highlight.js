/* global pd */

pd.highlight = {
    init: () => {
        const wrap = document.querySelector('#blog-detail .cms-content');

        if (!wrap) {
            return;
        }

        // cargar librería solo si hay código que resaltar
        if (wrap.innerHTML.match(/<code class="language-/)) {
            const script = document.createElement('script');
            script.src = '/assets/js/libs/prism.js';

            document.head.append(script);
        }
    },
};

pd.highlight.init();
