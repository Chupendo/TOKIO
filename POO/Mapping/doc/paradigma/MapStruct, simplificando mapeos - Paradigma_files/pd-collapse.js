
/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */


// window.addEventListener('click', (e) => {
//     console.log('click!');
//     triggers.forEach(trigger => trigger.classList.toggle('active'));
// });

pd.collapse = {
    init: (wrap = document) => {
        pd.collapse.addActive(wrap);
        pd.collapse.collapseBehaviour(wrap);
    },
    addActive: (wrap) => {
        const firstCollapseElem = wrap.querySelector('.pd-collapse');
        if (firstCollapseElem) {
            firstCollapseElem.classList.add('active');
        }
    },
    collapseBehaviour: (wrap) => {
        const collapsePanels = wrap.querySelectorAll('.pd-collapse');
        collapsePanels.forEach((panel) => {
            const toggleCollapse = panel.querySelector('.pd-collapse-trigger');
            toggleCollapse.addEventListener('click', (e) => {
                panel.classList.toggle('active');
            });
            toggleCollapse.addEventListener('keyup', (e) => {
                if (e.keyCode === 13) {
                    e.preventDefault();
                    panel.classList.toggle('active');
                }
            });
        });
    },
};

pd.collapse.init();
