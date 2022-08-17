/* global _env, pd */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

// basado en:
// https://gist.github.com/nobitagit/74c507a96a73cbcace6c824bc9c2fecf

pd.ago = {
    locales: {
        en: {
            preffix: '',
            suffix: ' ago',
            periods: {
                singular: ['year', 'month', 'day', 'hour', 'minute', 'second'],
                plural: ['years', 'months', 'days', 'hours', 'minutes', 'seconds'],
            },
        },
        es: {
            preffix: 'Hace ',
            suffix: '',
            periods: {
                singular: ['año', 'mes', 'día', 'hora', 'minuto', 'segundo'],
                plural: ['años', 'meses', 'días', 'horas', 'minutos', 'segundos'],
            },
        },
    },
    epochs: [
        31536000,
        2592000,
        86400,
        3600,
        60,
        1,
    ],
    init: (wrap) => {
        wrap.querySelectorAll('.timeago[datetime]').forEach((elem) => {
            pd.ago.setTimeAgo(elem);
        });
    },
    getDuration: (timeAgoInSeconds) => {
        for (let index = 0; index < pd.ago.epochs.length; index++) {
            const seconds = pd.ago.epochs[index];
            const interval = Math.floor(timeAgoInSeconds / seconds);

            if (interval >= 1) {
                return {
                    interval,
                    epoch: index,
                };
            }
        }
        return false;
    },
    timeAgo: (date) => {
        const timeAgoInSeconds = Math.floor((new Date() - new Date(date)) / 1000);

        const {interval, epoch} = pd.ago.getDuration(timeAgoInSeconds);
        const lang = pd.ago.locales[_env.siteLang];
        const suffix = lang.suffix;
        const preffix = lang.preffix;
        const periods = interval === 1 ? lang.periods.singular : lang.periods.plural;

        // https://stackoverflow.com/questions/3468607/why-does-settimeout-break-for-large-millisecond-delay-values
        const MAX_32BITS_SAFE_NUMBER = 2147483647;
        let refreshInterval = pd.ago.epochs[epoch] * 1000;
        if (refreshInterval > MAX_32BITS_SAFE_NUMBER) {
            refreshInterval = MAX_32BITS_SAFE_NUMBER;
        }

        return {
            string: `${preffix}${interval} ${periods[epoch]}${suffix}`,
            refreshInterval,
        };
    },
    setTimeAgo: (elem) => {
        const time = elem.getAttribute('datetime');
        const timeAgo = pd.ago.timeAgo(time);
        elem.innerHTML = timeAgo.string;

        // que solo se refresque las veces necesarias
        setTimeout(() => {
            pd.ago.setTimeAgo(elem);
        }, timeAgo.refreshInterval);
    },
};

pd.ago.init(document);
