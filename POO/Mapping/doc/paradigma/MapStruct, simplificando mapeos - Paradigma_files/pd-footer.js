/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.footer = {
    init: () => {
        pd.footer.setAddressTabs();
        pd.footer.preventTargetBlank();
    },
    setAddressTabs: () => {
        const triggers = document.querySelectorAll('.js__change-address-place');
        const addressContents = document.querySelectorAll('.js__address-place');

        triggers.forEach((trigger) => {
            const place = trigger.dataset.place;

            const content = document.querySelector(`#address-place__${place}`);

            trigger.addEventListener('click', (e) => {
                e.preventDefault();

                const activeAddressTab = document.querySelector('.js__change-address-place.active')
                const activeAddressContents = document.querySelector('.js__address-place.active');
                activeAddressContents.classList.remove('active');
                activeAddressTab.classList.remove('active');
                trigger.classList.add('active');
                content.classList.add('active');
            });
        });
    },
    preventTargetBlank: () => {
        // por defecto se pone un target blank a todos los links que pasan por el parseMD
        // a veces necesitamos quitarlo.
        const links = document.querySelectorAll('.js__prevent-target_blank');

        links.forEach((link) => {
            if (link.getAttribute('target') === '_blank') {
                link.removeAttribute('target');
            }
        });
    },
};

pd.footer.init();
