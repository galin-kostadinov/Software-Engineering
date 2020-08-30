import { register as apiRegister, login } from '../data.js';
import { loginPost } from './login.js';

export default async function register() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    this.partial('./templates/user/register.hbs', this.app.userData);
}

export async function registerPost() {
    try {
        if (this.params.password !== this.params.repeatPassword) {
            throw new Error('Password don\'t match');
        }
        if (this.params.email === undefined || this.params.email === null || this.params.email === '') {
            throw new Error('Email is mandatory');
        }
        if (this.params.password.length < 6) {
            throw new Error('Password must be atleast 6 characters long');
        }

        const result = await apiRegister(this.params.email, this.params.password);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        loginPost.call(this);
    } catch (err) {
        alert(err.message);
    }
}