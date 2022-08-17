/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.overlay = {
    elem: document.getElementById('overlay'),
    hiddenClass: 'invisible',
    classesToRemoveOnHide: [],
    functionsToCallOnHide: [
        'headerCases.hide',
        'blogFilters.hide',
    ],
    showOverlay: () => {
        pd.overlay.elem.classList.remove(pd.overlay.hiddenClass);
        document.body.classList.add('block-scroll');
    },
    hideOverlay: (stopFnPropagation = false) => {
        pd.overlay.elem.classList.add(pd.overlay.hiddenClass);
        document.body.classList.remove('block-scroll');

        pd.overlay.removeClassesFromElems();

        if (!stopFnPropagation) {
            pd.overlay.executeCloseFunctions();
        }
    },
    removeClassesFromElems: () => {
        pd.overlay.classesToRemoveOnHide.forEach((theClass) => {
            document.querySelectorAll(`.${theClass}`).forEach((elem) => {
                elem.classList.remove(theClass);
            });
        });
    },
    executeCloseFunctions: () => {
        pd.overlay.functionsToCallOnHide.forEach((name) => {
            utils.executeFn(name);
        });
    },
};

pd.overlay.elem.addEventListener('click', (e) => {
    pd.overlay.hideOverlay();
});
