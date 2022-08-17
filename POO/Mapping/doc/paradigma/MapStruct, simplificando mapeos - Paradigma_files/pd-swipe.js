/* global pd, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.swipe = {
    set: (wrap, callback, param) => {
        wrap.addEventListener('touchstart', (e) => {
            pd.swipe.handleTouchStart(e);
        }, {passive: true});
        wrap.addEventListener('touchmove', (e) => {
            pd.swipe.handleTouchMove(e, param, wrap, callback);
        }, {passive: true});

        pd.swipe.xDown = null;
        pd.swipe.yDown = null;
    },
    defaultCallback: (move, wrap, data) => {
        if (move === 'up' || move === 'down') {
            return;
        }

        if (!data.currentIndex) {
            data.currentIndex = 1;
        }

        const totalItems = wrap.childNodes.length;

        if (data.currentIndex === totalItems && move === 'left') {
            return;
        }

        if (data.currentIndex === 1 && move === 'right') {
            return;
        }

        if (move === 'left') {
            data.currentIndex += 1;
        } else if (move === 'right') {
            data.currentIndex -= 1;
        }

        let position = ((data.currentIndex - 1) * data.distance) - data.offset;

        if (position < 0) {
            position = 0;
        }

        wrap.setAttribute('style', `transform: translate3d(-${position}%, 0, 0)`);
    },
    getTouches: (evt) => {
        return evt.touches || // browser API
            evt.originalEvent.touches; // jQuery
    },
    handleTouchStart: (evt) => {
        console.log('handleTouchStart');

        const firstTouch = pd.swipe.getTouches(evt)[0];
        pd.swipe.xDown = firstTouch.clientX;
        pd.swipe.yDown = firstTouch.clientY;
    },
    handleTouchMove: (evt, param, wrap, callback) => {
        console.log('move');

        if (!pd.swipe.xDown || !pd.swipe.yDown) {
            return;
        }

        const xUp = evt.touches[0].clientX;
        const yUp = evt.touches[0].clientY;

        const xDiff = pd.swipe.xDown - xUp;
        const yDiff = pd.swipe.yDown - yUp;

        if (Math.abs(xDiff) > Math.abs(yDiff)) {
            if (xDiff > 0) {
                /* left swipe */
                callback('left', wrap, param);
            } else {
                /* right swipe */
                callback('right', wrap, param);
            }
        // } else {
        //     if (yDiff > 0) {
        //         /* up swipe */
        //     } else {
        //         /* down swipe */
        //     }
        }
        /* reset values */
        pd.swipe.xDown = null;
        pd.swipe.yDown = null;
    },
};

pd.swipe.elems = [
    {
        selector: '.group.group--carousel-collapse',
        distance: 90,
        offset: 5,
        callback: pd.swipe.defaultCallback,
    },
];

pd.swipe.init = (wrap = document) => {
    pd.swipe.elems.forEach((type) => {
        type.elems = wrap.querySelectorAll(type.selector);

        type.elems.forEach((elem) => {
            pd.swipe.set(elem, type.callback, type);
        });
    });
};

pd.swipe.init();
