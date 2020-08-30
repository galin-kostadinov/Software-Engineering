import { register as apiRegister } from '../data.js';

export default async function register() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
    };

    this.partial('./templates/user/register.hbs', this.app.userData);
}

export async function registerPost() {
    try {
        if (this.params.password !== this.params.repeatPassword) {
            throw new Error('Password don\'t match');
        }
    
        const result = await apiRegister(this.params.email, this.params.password);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/login');
    } catch (err) {
        alert(err.message);
    }
}