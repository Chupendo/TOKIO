/* global pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.video = {
    init: () => {
        const videos = document.querySelectorAll('.block-video');

        videos.forEach((video) => {
            video.querySelector('a').addEventListener('click', (e) => {
                e.preventDefault();

                pd.video.loadVideo(video);
            }, false);
        });
    },
    loadVideo: (video) => {
        const wrap = video.querySelector('a');
        let videoUrl = wrap.getAttribute('href');
        let localFile = true;
        let videoElem;

        let style = '';

        if (wrap.dataset.bgcolor) {
            style = `style="background-color: ${wrap.dataset.bgcolor}"`;
        }

        if (videoUrl.includes('youtu')) { // ver si es un video de Youtube
            const videoID = pd.video.getYoutubeId(videoUrl);
            localFile = false;
            videoUrl = `https://www.youtube.com/embed/${videoID}?autoplay=1&html5=1&hd=1&showinfo=0&showsearch=0&iv_load_policy=3`;
        } else if (videoUrl.includes('vimeo')) {
            const videoID = pd.video.getVimeoId(videoUrl);
            localFile = false;
            videoUrl = `//player.vimeo.com/video/${videoID}?title=0&amp;byline=0&amp;portrait=0&amp;badge=0&amp;color=ffffff&amp;autoplay=1`;
        }

        if (localFile) {
            videoElem = `<video controls autoplay ${style}>
                            <source src="${videoUrl}" type="video/mp4">
                        </video>`;
        } else {
            videoElem = `<iframe src="${videoUrl}" frameborder="0" allow="autoplay; fullscreen" allowautoplay allowfullscreen ${style}></iframe>`;
        }

        video.insertAdjacentHTML('beforeend', videoElem);
    },
    closeVideo: (video) => {

    },
    getYoutubeId: (url) => {
        const regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
        const match = url.match(regExp);
        return (match && match[7].length === 11) ? match[7] : false;
    },
    getVimeoId: (url) => {
        const regExp = /[http|https]:\/\/(www\.)?vimeo.com\/(\d+)($|\/)/;
        const match = url.match(regExp);

        if (match) { return match[2]; }
        return false;
    },
};

pd.video.init();

