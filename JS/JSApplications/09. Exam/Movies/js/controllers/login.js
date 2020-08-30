import { login as apiLogin } from '../data.js';

export default async function login() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    this.partial('./templates/user/login.hbs', this.app.userData);
}

export async function loginPost() {
    try {

        const result = await apiLogin(this.params.email, this.params.password);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.email = result.email;
        this.app.userData.userId = result.objectId;

        this.redirect('#/home');
    } catch (err) {
       alert(err.message);
    }
}