/* global pd, tmpl, _env, utils */
/* eslint no-undef: "error" */
/* eslint no-unused-vars: 0 */

pd.comments = {
    init: () => {
        // check for dependencies
        if (typeof tmpl === 'undefined' || typeof pd.ago === 'undefined') {
            setTimeout(() => pd.comments.init(), 100);
            return;
        }

        pd.comments.wrap = document.getElementById('comments-wrap');
        if (!pd.comments.wrap) { return; }

        pd.comments.postId = pd.comments.wrap.dataset.postId;
        pd.comments.postSlug = pd.comments.wrap.dataset.postSlug;
        pd.comments.notify = pd.comments.wrap.dataset.notify;
        pd.comments.form = pd.comments.wrap.querySelector('.form');

        pd.comments.getComments();
    },
    getComments: () => {
        const lang = _env.siteLang;
        fetch(`${_env.commentsAPI}${_env.siteLang}/${pd.comments.postId}/`)
            .then(response => response.json())
            .then((comments) => {
                pd.comments.showAmountInHeader(comments);

                // lazy load
                if ('IntersectionObserver' in window) {
                    const commentObs = new IntersectionObserver((entries, observer) => {
                        entries.forEach((entry) => {
                            if (entry.isIntersecting) {
                                pd.comments.drawComments(comments);
                                pd.comments.waitForSubmit();
                                commentObs.unobserve(entry.target);
                            }
                        });
                    });

                    commentObs.observe(pd.comments.form);
                }
            })
            .catch((error) => {
                console.error(`Hubo un problema con la petición Fetch: ${error.message}`);
                pd.comments.showError(error.message);
            });

        pd.comments.adjustTextareaHeight();
    },
    adjustTextareaHeight: () => {
        const textarea = pd.comments.form.querySelector('textarea');
        textarea.addEventListener('keyup', () => {
            textarea.style.height = '1px';
            textarea.style.height = `${textarea.scrollHeight}px`;
        });
    },
    getCommentsAmount: (comments, parents) => {
        if (!pd.comments.totalPostComments) {
            pd.comments.totalPostComments = 0;
        }

        for (let i = 0; i < comments.length; i++) {
            pd.comments.totalPostComments += 1;

            if (comments[i].replies) {
                pd.comments.getCommentsAmount(comments[i].replies);
            }
        }
    },
    showAmountInHeader: (comments) => {
        pd.comments.getCommentsAmount(comments);

        let string;
        if (!pd.comments.totalPostComments) {
            string = ['No comments yet', 'Sin comentarios aún'];
        } else if (pd.comments.totalPostComments === 1) {
            string = ['1 comment', '1 comentario'];
        } else {
            string = [`${pd.comments.totalPostComments} comments`, `${pd.comments.totalPostComments} comentarios`];
        }
        let langIndex = 0;
        if (_env.siteLang === 'es') { langIndex = 1; }
        document.querySelector('#pd-header #commentsAmount').innerHTML = string[langIndex];
    },
    drawComments: (comments) => {
        let data = {
            html: '',
            total: 0,
        };
        let html = '';

        data = pd.comments.drawCommentsItems(data, comments);

        if (!data.total) {
            const title = pd.comments.wrap.querySelector('.comments-title');
            pd.comments.wrap.classList.add('-no-comment-yet');
            title.innerHTML = tmpl('noCommentsTmpl', {assetsPath: _env.assetsPath});
        }

        html += tmpl('commentsAmountTmpl', {total: data.total});
        html += data.html;

        pd.comments.wrap.querySelector('#comments-list').innerHTML = html;
        pd.comments.wrap.classList.add('-loaded');
        pd.ago.init(pd.comments.wrap);
        pd.comments.waitForReply();
    },
    drawCommentsItems: (data, comments) => {
        comments.forEach((comment) => {
            data.total += 1;
            data.html += tmpl('commentTmpl', {comment});

            if (comment.replies) {
                // eslint-disable-next-line no-param-reassign
                data = pd.comments.drawCommentsItems(data, comment.replies);
            }
        });

        return data;
    },
    waitForSubmit: () => {
        pd.comments.wrap.querySelector('.comment-submit').addEventListener('click', (e) => {
            e.preventDefault();

            pd.comments.postComment();
        });
    },
    waitForReply: () => {
        pd.comments.wrap.querySelectorAll('.comment-reply').forEach((link) => {
            link.addEventListener('click', (e) => {
                e.preventDefault();

                const replyToId = parseInt(link.dataset.replyToId, 10);
                const replyToName = link.dataset.replyToName;

                pd.comments.prepareReply(replyToId, replyToName);
            });
        });
    },
    prepareReply: (id, name) => {
        const form = pd.comments.form;

        // cambiar placeholder
        const textarea = form.querySelector('textarea[name="comment"]');
        const newPlaceholder = `${textarea.getAttribute('placeholder-reply')} ${name}`;
        textarea.setAttribute('placeholder', newPlaceholder);

        form.querySelector('input[name="parent"]').value = id;

        const formPos = utils.offset(pd.comments.wrap).top;
        window.scrollTo(0, formPos);
    },
    postComment: async () => {
        const form = pd.comments.form;
        if (!pd.comments.checkForm(form)) {
            return;
        }

        pd.comments.wrap.classList.add('-submiting');

        const data = {
            parent: form.querySelector('input[name="parent"]').value,
            name: form.querySelector('input[name="name"]').value,
            email: form.querySelector('input[name="email"]').value,
            comment: form.querySelector('textarea[name="comment"]').value,
            lang: _env.siteLang,
            post_id: pd.comments.postId,
            post_slug: pd.comments.postSlug,
            post_notify: encodeURIComponent(pd.comments.notify),
        };

        const postComment = await fetch(`${_env.commentsAPI}`, {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        }).catch((error) => {
            console.error(`Hubo un problema con la petición Fetch: ${error.message}`);
            pd.comments.showError(error.message);
        });
        const response = await postComment.json();

        if (response.status === 'success') {
            pd.comments.showSuccess();
        } else {
            console.warn(response);
            let message = ['Error saving comment', 'Error al salvar comentario'];
            if (response.errors && response.errors.length) {
                if (response.errors[0].msg === 'Invalid value') {
                    message = ['Invalid value', 'Comentario enviado no válido'];
                }
            }

            let langIndex = 0;
            if (_env.siteLang === 'es') { langIndex = 1; }
            pd.comments.showError(message[langIndex]);
        }
    },
    tryAgainEvent: (wrap, reset) => {
        wrap.querySelector('#send-another-comment').addEventListener('click', (e) => {
            e.preventDefault();

            pd.comments.wrap.classList.remove('-submiting');
            pd.comments.wrap.classList.remove('-status-success');
            pd.comments.wrap.classList.remove('-status-error');

            if (reset) {
                pd.comments.wrap.querySelectorAll('input, textarea').forEach((input) => {
                    input.value = '';
                });
            }
        });
    },
    showSuccess: () => {
        const formWrap = pd.comments.wrap.querySelector('#commets-status-message');
        formWrap.innerHTML = tmpl('successCommentSentTmpl', {assetsPath: _env.assetsPath});
        pd.comments.wrap.classList.add('-status-success');
        pd.anim.init(formWrap);
        pd.scroll.smoothScroll({to: formWrap.offsetTop});

        pd.comments.tryAgainEvent(formWrap, true);
    },
    showError: (message) => {
        const formWrap = pd.comments.wrap.querySelector('#commets-status-message');
        formWrap.innerHTML = tmpl('errorCommentSentTmpl', {assetsPath: _env.assetsPath, msg: message});

        pd.comments.wrap.classList.add('-status-error');
        pd.anim.init(formWrap);

        pd.comments.tryAgainEvent(formWrap, false);
    },
    checkForm: (form) => {
        let success = true;
        form.querySelectorAll('input, textarea, select').forEach((field) => {
            if (field.getAttribute('required') === 'required') {
                if (pd.comments.setFieldError(field, (field.value), 'required')) {
                    success = false;
                }
            }

            if (success && field.getAttribute('minlength')) {
                if (pd.comments.setFieldError(field, pd.comments.validateLength(field), 'minlength')) {
                    success = false;
                }
            }

            if (success && field.getAttribute('type') === 'email') {
                if (pd.comments.setFieldError(field, pd.comments.validateEmail(field.value), 'emailFormat')) {
                    success = false;
                }
            }
        });

        return success;
    },
    setFieldError: (field, status, type) => {
        const parent = field.parentNode;

        if (status) {
            parent.classList.remove('error');
            return false;
        }

        parent.classList.add('error');

        let errorMsg = '';
        switch (type) {
        case 'required':
            errorMsg = 'Por favor, completa los campos requeridos.';
            break;
        case 'emailFormat':
            errorMsg = 'Este email no tiene buena pinta.';
            break;
        case 'minlength':
            errorMsg = 'Es demasiado corto.';
            break;

        default:
            break;
        }
        parent.querySelector('.error-type').innerHTML = errorMsg;
        return true;
    },
    validateEmail: (email) => {
        const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    },
    validateLength: (field) => {
        if (field.value.length < parseInt(field.getAttribute('minlength'), 10)) {
            return false;
        }

        return true;
    },
};

pd.comments.init();
