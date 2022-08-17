/* global utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

const headerSectionsWrap = document.querySelector('#header-sections');
const headerSections = headerSectionsWrap.querySelectorAll('#header-sections a');
const headerSectionFlag = document.querySelector('#header-active-section-flag');
let headerSectionActive;

function setHeaderActiveSection(elem) {
    // check for dependencies
    if (typeof utils === 'undefined') {
        setTimeout(() => setHeaderActiveSection(elem), 100);
        return;
    }

    const off = utils.offset(elem);
    const pos = off.left + (elem.offsetWidth / 2);

    headerSectionFlag.setAttribute('style', `left: ${pos}px`);
}

headerSections.forEach((section) => {
    section.addEventListener('mouseover', () => {
        setHeaderActiveSection(section);
    });

    if (section.classList.contains('active')) {
        headerSectionActive = section;
    }
});

if (headerSectionActive) {
    setHeaderActiveSection(headerSectionActive);

    headerSectionsWrap.addEventListener('mouseout', () => {
        setHeaderActiveSection(headerSectionActive);
    });
}
