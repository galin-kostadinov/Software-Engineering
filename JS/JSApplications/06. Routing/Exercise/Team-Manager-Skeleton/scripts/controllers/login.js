import { login, logout as logoutGet } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        loginForm: await this.load('./templates/login/loginForm.hbs')
    };
    this.partial('./templates/login/loginPage.hbs');
}

export async function loginPost() {
    try {
        const result = await login(this.params.username, this.params.password);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.loggedIn = true;
        this.app.userData.username = result.username;
        this.app.userData.userId = result.objectId;
        this.app.userData.teamId = result.teamId;

        if(result.teamId){
            this.app.userData.hasTeam = true;
        }else{
            this.app.userData.hasTeam = false;
        }
        
        localStorage.setItem('userToken', result['user-token']);
        localStorage.setItem('username', result.username);
        localStorage.setItem('userId', result.objectId);
        localStorage.setItem('teamId', result.teamId);
        this.redirect('#/home');
    } catch (err) {
        alert(err.message);
    }
}

export async function logout() {
    await logoutGet();
    this.app.userData.loggedIn = false;
    this.app.userData.hasTeam = false;
    this.app.userData.teamId = undefined;
    this.app.userData.username =undefined;
    this.app.userData.userId = undefined
    localStorage.removeItem('userToken');
    localStorage.removeItem('username');
    localStorage.removeItem('userId');

    this.redirect('#/home');
}