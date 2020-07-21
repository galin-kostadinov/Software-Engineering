import { createTeam, setUserTeamId } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        createForm: await this.load('./templates/create/createForm.hbs')
    };
    this.partial('./templates/create/createPage.hbs');
}

export async function createPost() {
    const newTeam = {
        name: this.params.name,
        comment: this.params.comment
    }

    if (Object.values(newTeam).some(v => v.length == 0)) {
        alert('All fields are mandatory.')
        return;
    }

    try {
        const result = await createTeam(newTeam);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.hasTeam = true;
        this.app.userData.teamId = result.objectId;

        await setUserTeamId(this.app.userData.userId, result.objectId);

        this.redirect(`#/catalog/${result.objectId}`);
    } catch (err) {
        alert(err.message);
    }
}

export async function leaveTeam() {
    try {
        const result = await setUserTeamId(this.app.userData.userId, '');
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.hasTeam = false;
        this.app.userData.teamId = undefined;

        this.redirect(`#/catalog`);
    } catch (err) {
        alert(err.message);
    }
}

joinTeam
export async function joinTeam() {
    if (this.app.userData.teamId !== undefined) {
        alert("User is already joined to a team.");
    }
    
    try {
        const result = await setUserTeamId(this.app.userData.userId, this.params.teamId);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.hasTeam = true;
        this.app.userData.teamId = result.teamId;

        this.redirect(`#/catalog/${result.teamId}`);
    } catch (err) {
        alert(err.message);
    }
}