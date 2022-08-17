/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.respMenu = {
    init: () => {
        document.querySelector('#header-toogle-menu').addEventListener('click', (e) => {
            e.preventDefault();

            if (!document.body.classList.contains('-resp-menu-on')) {
                document.body.classList.add('-resp-menu-on');
                setTimeout(() => {
                    document.body.classList.add('-resp-menu-on-anim');
                }, 100);
            } else {
                document.body.classList.remove('-resp-menu-on-anim');
                setTimeout(() => {
                    document.body.classList.remove('-resp-menu-on');
                }, 500);
            }

        });
    },
};

pd.respMenu.init();
