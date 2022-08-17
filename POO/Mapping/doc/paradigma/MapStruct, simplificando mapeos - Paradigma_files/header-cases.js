/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.headerCases = {
    data: {
        wrap: document.getElementById('header-top'),
        panel: document.getElementById('header-cases-detail'),
        listItems: document.querySelectorAll('#header-cases-detail #casesList a, #viewAllProjects'),
        listItemsToShow: [
            ['.name', 'slideDownLetters'],
            ['.tag', 'lineThrough'],
            ['a', 'slideUp'],
        ],
    },
    toggle: () => pd.anim.panelRelease.toggle(pd.headerCases.data),
    hide: () => pd.anim.panelRelease.hide(pd.headerCases.data),
};

document.querySelector('#header-cases a').addEventListener('click', (e) => {
    e.preventDefault();
    pd.headerCases.toggle();
});
