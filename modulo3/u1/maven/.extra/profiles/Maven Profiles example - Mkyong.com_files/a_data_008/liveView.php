
                        try
                        {
                            var linksArray = '  https://live.primis.tech/content/ClientDetections/iab_consent_sdk.v1.0.js  https://live.primis.tech/content/ClientDetections/DetectGDPR2.v1.1.js  https://live.primis.tech/content/ClientDetections/DetectGDPR.v1.1.js  https://live.primis.tech/content/video/hls/hls.0.12.4_3.min.js  https://live.primis.tech/content/prebid/prebidVid.7.16.0_9.min.js   https://live.primis.tech/live/liveVideo.php?vpaidManager=sekindo&s=58057&ri=6C69766553746174737C736B317B54307D7B64323032332D30362D32325F32337D7B7331363336313336337D7B4336347D7B53625774356232356E4C6D4E7662513D3D7D7B6266697265666F787D7B716465736B746F707D7B6F77696E646F77737D7B583430307D7B593237327D7B66317D7B4C31303333317DFEFE&userIpAddr=90.94.176.208&userUA=Mozilla%2F5.0+%28Windows+NT+10.0%3B+Win64%3B+x64%3B+rv%3A109.0%29+Gecko%2F20100101+Firefox%2F114.0&debugInformation=&isWePassGdpr=0&schain=1.0%2C1%21freestar.com%2C813%2C1&noViewableMidrollPolicy=vary&isDoublePreroll=1&autoSkipVideoSec=30&c2pWaitTime=10&sdkv=&isSinglePageFloatSupport=0&availCampaigns=&isAmpIframe=0&tagKeywords=&cbuster=1687466046&csuuid=648f47af9e9a7&debugInfo=16361363_&debugPlayerSession=&pubUrlDEMO=&isAsyncDEMO=0&customPlaylistIdDEMO=&sta=16361363&showLogo=0&clkUrl=&plMult=-1&schedule=eyJwcmVfcm9sbCI6MSwibWlkX3JvbGwiOltdLCJnYXAiOiJhdXRvIn0%3D&content=&secondaryContent=&x=400&y=272&pubUrl=https%3A%2F%2Fmkyong.com%2Fmaven%2Fmaven-profiles-example%2F&contentNum=1&flow_closeBtn=1&flowCloseTimeout=0&flow_closeButtonPosition=right&flow_direction=br&flow_horizontalOffset=10&flow_bottomOffset=105&impGap=1&flow_width=350&flow_height=197&videoType=sticky&gdpr=1&gdprConsent=&contentFeedId=&geoLati=38.0133&geoLong=-3.3751&vpTemplate=10331&flowMode=both&isRealPreroll=0&playerApiId=freestarPrimisPlayer&isApp=0&ccpa=0&ccpaConsent=&subId=&appName=&appBundleId=https%3A%2F%2Fmkyong.com%2Fmaven%2Fmaven-profiles-example%2F&appStoreUrl=&diaid=&appPrivacyPolicy=&appIsPaid=&appDeveloper=&appId=&appVersion=&sdkv=&enableResizeObserverInapp=0&isAppJs=0'.split(' ');

                            for(var l = 0; l < linksArray.length; l++)
                            {
                                if(linksArray[l].length > 10)
                                {
                                    var sc = document.createElement('script');
                                    sc.type = 'text/javascript';
                                    sc.async = false;
                                    sc.src = linksArray[l];
                                    document.head.appendChild(sc);
                                }
                            }
                        }
                        catch(e)
                        {
                            document.write('<script type="text/javascript" src="https://live.primis.tech/content/ClientDetections/iab_consent_sdk.v1.0.js">\x3C/script><script type="text/javascript" src="https://live.primis.tech/content/ClientDetections/DetectGDPR2.v1.1.js">\x3C/script><script type="text/javascript" src="https://live.primis.tech/content/ClientDetections/DetectGDPR.v1.1.js">\x3C/script><script type="text/javascript" src="https://live.primis.tech/content/video/hls/hls.0.12.4_3.min.js">\x3C/script><script type="text/javascript" src="https://live.primis.tech/content/prebid/prebidVid.7.16.0_9.min.js">\x3C/script><script type=' + "'" + 'text/javascript' + "'" + ' language=' + "'" + 'javascript' + "'" + ' src="https://live.primis.tech/live/liveVideo.php?vpaidManager=sekindo&s=58057&ri=6C69766553746174737C736B317B54307D7B64323032332D30362D32325F32337D7B7331363336313336337D7B4336347D7B53625774356232356E4C6D4E7662513D3D7D7B6266697265666F787D7B716465736B746F707D7B6F77696E646F77737D7B583430307D7B593237327D7B66317D7B4C31303333317DFEFE&userIpAddr=90.94.176.208&userUA=Mozilla%2F5.0+%28Windows+NT+10.0%3B+Win64%3B+x64%3B+rv%3A109.0%29+Gecko%2F20100101+Firefox%2F114.0&debugInformation=&isWePassGdpr=0&schain=1.0%2C1%21freestar.com%2C813%2C1&noViewableMidrollPolicy=vary&isDoublePreroll=1&autoSkipVideoSec=30&c2pWaitTime=10&sdkv=&isSinglePageFloatSupport=0&availCampaigns=&isAmpIframe=0&tagKeywords=&cbuster=1687466046&csuuid=648f47af9e9a7&debugInfo=16361363_&debugPlayerSession=&pubUrlDEMO=&isAsyncDEMO=0&customPlaylistIdDEMO=&sta=16361363&showLogo=0&clkUrl=&plMult=-1&schedule=eyJwcmVfcm9sbCI6MSwibWlkX3JvbGwiOltdLCJnYXAiOiJhdXRvIn0%3D&content=&secondaryContent=&x=400&y=272&pubUrl=https%3A%2F%2Fmkyong.com%2Fmaven%2Fmaven-profiles-example%2F&contentNum=1&flow_closeBtn=1&flowCloseTimeout=0&flow_closeButtonPosition=right&flow_direction=br&flow_horizontalOffset=10&flow_bottomOffset=105&impGap=1&flow_width=350&flow_height=197&videoType=sticky&gdpr=1&gdprConsent=&contentFeedId=&geoLati=38.0133&geoLong=-3.3751&vpTemplate=10331&flowMode=both&isRealPreroll=0&playerApiId=freestarPrimisPlayer&isApp=0&ccpa=0&ccpaConsent=&subId=&appName=&appBundleId=https%3A%2F%2Fmkyong.com%2Fmaven%2Fmaven-profiles-example%2F&appStoreUrl=&diaid=&appPrivacyPolicy=&appIsPaid=&appDeveloper=&appId=&appVersion=&sdkv=&enableResizeObserverInapp=0&isAppJs=0">\x3C/script>');
                        }
                        