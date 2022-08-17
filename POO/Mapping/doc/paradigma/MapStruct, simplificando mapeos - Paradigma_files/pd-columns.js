/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */


// window.addEventListener('click', (e) => {
//     console.log('click!');
//     triggers.forEach(trigger => trigger.classList.toggle('active'));
// });

pd.columns = {
    init: () => {
        pd.columns.fixMoreThan2Cols();
    },
    fixMoreThan2Cols: () => {
        // ver si hay bloques con más de 2 columnas
        const extraCols = document.querySelectorAll('.group--columns .group-item:nth-child(3)');

        extraCols.forEach((col) => {
            const block = col.parentElement;

            block.classList.add('more-than-2-cols');
        });
    },
};

pd.columns.init();
