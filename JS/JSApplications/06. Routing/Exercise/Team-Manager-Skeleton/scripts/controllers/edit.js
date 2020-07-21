import { updateTeam } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        editForm: await this.load('./templates/edit/editForm.hbs')
    };
    this.partial('./templates/edit/editPage.hbs', this.app.userData);
}

export async function editPut() {
    const teamToUpdate = {
        name: this.params.name,
        comment: this.params.comment
    }

    if (Object.values(teamToUpdate).some(v => v.length == 0)) {
        alert('All fields are mandatory.')
        return;
    }

    try {
        const result = await updateTeam(teamToUpdate, this.params.teamId);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect(`#/catalog/${result.objectId}`);
    } catch (err) {
        alert(err.message);
    }
}