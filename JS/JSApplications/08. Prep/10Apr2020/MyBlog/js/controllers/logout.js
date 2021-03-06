import { logout as apiLogout } from '../data.js';

export default async function logout() {
    try {
        const result = await apiLogout();
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.email = '';
        this.app.userData.userId = '';

        this.redirect('#/home');
    } catch (err) {
        alert(err.message);
    }
}