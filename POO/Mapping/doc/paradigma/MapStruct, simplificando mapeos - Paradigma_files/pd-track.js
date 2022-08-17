/* global pd, ga, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.track = {
    init: (wrap) => {
        // check for dependencies
        if (typeof pd.scroll === 'undefined') {
            setTimeout(() => pd.track.init(wrap), 100);
            return;
        }

        pd.track.wrap = wrap;
        pd.track.events.init();
    },
    events: {
        init: () => {
            pd.track.events.sendFooterNewsletter();
            pd.track.events.sendBlogNewsletter();
            pd.track.events.sendContactForm();
            pd.track.events.sendComment();
            pd.track.events.submitOpeningApplication();
            pd.track.events.eventApplication();
            pd.track.events.checkScroll();
            pd.track.events.submitSearch();
            pd.track.events.cmsContentButtonClick();
        },
        set: (data) => {
            if (!data.event) { data.event = 'click'; }
            if (!data.action) { data.action = 'Click'; }

            pd.track.wrap.querySelectorAll(data.selector).forEach((elem) => {
                if (!elem.dataset.tracking) {
                    elem.addEventListener(data.event, () => {
                        if (data.label === 'getSearchValue') {
                            data.label = document.querySelector('#blog-filter-search').value;
                        }
                        ga('send', 'event', data.category, data.action, data.label);
                        console.log('llamada a Google Analytics', data);
                    });
                }

                elem.dataset.tracking = true;
            });
        },
        sendFooterNewsletter: () => {
            // footer newsletter
            pd.track.events.set({
                selector: '#newsletter-footer-wrap .hs-submit input',
                category: 'NewsletterButton',
                label: 'Footer',
            });
        },
        sendBlogNewsletter: () => {
            // blog list newsletter
            pd.track.events.set({
                selector: '#newsletter-form .hs-submit input',
                category: 'NewsletterButton',
                label: 'Blog',
            });
        },
        sendContactForm: () => {
            // blog list newsletter
            pd.track.events.set({
                selector: '#contact-form-wrap .hs-submit input',
                category: 'ContactButton',
                label: false,
            });
        },
        submitSearch: () => {
            // someone send a comment forms
            pd.track.events.set({
                selector: '.submit-search-on-click',
                category: 'Search',
                label: 'getSearchValue',
            });
        },
        cmsContentButtonClick: () => {
            const cmsButtonsSelector = '.cms-content .block-button .bt';
            const cmsButtons = document.querySelectorAll(cmsButtonsSelector);

            cmsButtons.forEach(btn => {
              const filename = btn.getAttribute('href').split('/').pop();

              if (filename) {
                  const ext = filename.split('.').pop();

                  if (ext) {
                      const action = ext.toUpperCase();

                      if (['PDF', 'JPG', 'PNG'].includes(action)) {
                          // someone click on a button created in the CMS
                          pd.track.events.set({
                              selector: cmsButtonsSelector,
                              category: 'Downloads',
                              action,
                              label: filename,
                          });
                      }
                  }
              }
            });
        },
        eventPersonalization: (eventLabel, personalized) => {
            const eventAction = (personalized) ? 'Personalized' : 'No Personalized';
            const eventValue = (personalized) ? 1 : 0;
            ga('send', 'event', 'Page', eventAction, eventLabel, eventValue);
        },
        sendComment: () => {
            // someone send a comment forms
            pd.track.events.set({
                selector: '#commets-form-wrap .comment-submit',
                category: 'CommentButton',
                label: 'Post',
            });
        },
        submitOpeningApplication: () => {
            // someone send a comment forms
            pd.track.events.set({
                selector: '#spontaneousCvForm .hs-submit input',
                category: 'EmpleoButton',
                label: 'Other',
            });

            pd.track.events.set({
                selector: '#offerCvForm .hs-submit input',
                category: 'EmpleoButton',
                label: 'Other',
            });
        },
        eventApplication: () => {
            // Alguien se inscribe en un evento
            pd.track.events.set({
                selector: '#submitEventApplication',
                category: 'EventRegistrationButton',
                label: 'Blog',
            });
        },
        checkScroll: () => {
            pd.track.const = {
                trackScrollPanel: document.querySelector('#blog-detail-content .cms-content'),
                readerLocation: 150, // # px before tracking a reader
                // Set some flags for tracking & execution
                contentLength: 0, // Content Length -> Length of content area
                timer: 0,
                scroller: false,
                endContent: false,
                didComplete: false,
                // Set some time variables to calculate reading time etc.
                pageTimeLoad: 0,
                scrollTimeStart: 0,
                timeToScroll: 0,
                contentTime: 0,
                endTime: 0,
                readerTime: 30, // Seconds after scroll to bottom of content before visitor is classified as "Reader"
                maxReadingTime: 3600, // Sólo se cuenta como máximo 1 hora de lectura (3600 segundo)
            };

            if (!pd.track.const.trackScrollPanel) {
                pd.track.const.trackScrollPanel = document.querySelector('body');
            }

            // This script was originally written by Justin Cutroni, see http://cutroni.com/blog/2012/02/21/advanced-content-tracking-with-google-analytics-part-1/
            const callBackTime = 500; // Default time delay before checking location

            // Check if content has to be scrolled
            pd.track.const.contentLength = pd.track.const.trackScrollPanel.clientHeight;
            if (window.innerHeight < pd.track.const.contentLength) { // Replace contentArea with the name (class or ID) of your content wrappers name
                pd.track.const.pageTimeLoad = new Date().getTime();
                ga('set', 'nonInteraction', true);
                ga('send', 'event', {
                    eventCategory: 'Page Scroll',
                    eventAction: 'Page Scroll: Allowed',
                    eventLabel: window.location.pathname,
                    eventValue: pd.track.const.contentLength,
                });
            }

            // Track the scrolling and track location
            window.addEventListener('scroll', () => {
                if (pd.track.const.timer) {
                    clearTimeout(pd.track.const.timer);
                }
                // Use a buffer so we don't call trackLocation too often.
                pd.track.const.timer = setTimeout(pd.track.trackLocation, callBackTime);
            }, false);
        },
    },
    trackLocation: () => {
        const c = pd.track.const;
        // Check the location and track user
        const bottom = window.innerHeight + pd.scroll.getScrollPos(window);
        const height = document.querySelector('body').clientHeight;

        // If user has scrolled beyond threshold send an event
        if (bottom > c.readerLocation && !c.scroller) {
            c.scroller = true;
            c.scrollTimeStart = new Date().getTime();

            if (c.pageTimeLoad > 0) {
                c.timeToScroll = Math.round((c.scrollTimeStart - c.pageTimeLoad) / 1000);
            } else {
                c.timeToScroll = '';
            }
            // Article scroll started
            ga('set', 'nonInteraction', true);
            ga('send', 'event', {
                eventCategory: 'Page Scroll',
                eventAction: 'Page Scroll: Started',
                eventLabel: window.location.pathname,
                eventValue: c.timeToScroll,
            });
        }

        // If user has hit the bottom of the content send an event
        if (bottom >= utils.offset(c.trackScrollPanel).top + c.trackScrollPanel.clientHeight && !c.endContent) {
            c.timeToScroll = new Date().getTime();
            c.contentTime = Math.round((c.timeToScroll - c.scrollTimeStart) / 1000);

            const data = {
                eventCategory: 'Page Scroll',
                eventLabel: window.location.pathname,
                eventValue: c.contentTime,
            };

            if (c.contentTime < c.readerTime) {
                data.eventAction = 'Page Scroll: Content Scanner';
            } else {
                data.eventAction = 'Page Scroll: Content Reader';
                if (c.contentTime > c.maxReadingTime) {
                    c.contentTime = c.maxReadingTime;
                }
                data.eventValue = c.contentTime;
            }
            ga('set', 'nonInteraction', true);
            ga('send', 'event', data);
            console.log('llamada a Google Analytics', data);

            c.endContent = true;
        }
        // If user has hit the bottom send an event
        if (bottom === height && !c.didComplete) {
            c.endTime = new Date().getTime();
            c.totalTime = Math.round((c.endTime - c.scrollTimeStart) / 1000);
            ga('set', 'nonInteraction', true);
            ga('send', 'event', {
                eventCategory: 'Page Scroll',
                eventAction: 'Page Scroll: Page Bottom',
                eventLabel: window.location.pathname,
                eventValue: c.totalTime,
            });

            c.didComplete = true;
        }
    },
};

pd.track.init(document);
