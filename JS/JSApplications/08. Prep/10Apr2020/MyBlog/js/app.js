/* globals Sammy */
import home from './controllers/home.js';
import register, { registerPost } from './controllers/register.js';
import login, { loginPost } from './controllers/login.js';
import logout from './controllers/logout.js';
import { create, details, edit, editPost, deletePost } from './controllers/post.js';

window.addEventListener('load', () => {
    const app = Sammy('#root', function () {
        this.use('Handlebars', 'hbs');

        this.userData = {
            email: localStorage.getItem('email') || '',
            userId: localStorage.getItem('userId') || ''
        };

        this.get('/', home);
        this.get('index.html', home);
        this.get('#/home', home);

        this.get('#/register', register);

        this.get('#/login', login);

        this.get('#/logout', logout);

        this.get('#/details/:id', details);

        this.get('#/edit/:id', edit);

        this.post('#/register', ctx => { registerPost.call(ctx); });

        this.post('#/login', ctx => { loginPost.call(ctx); });

        this.post('#/create-post', ctx => { create.call(ctx); });

        this.post('#/edit/:id', ctx => { editPost.call(ctx); });

        this.get('#/delete/:id', deletePost);

    });

    app.run();
});