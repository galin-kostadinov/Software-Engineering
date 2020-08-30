import { getAllPostByUser } from '../data.js';

export default async function home() {
    if (this.app.userData.email != undefined) {
        this.partials = {
            header: await this.load('./templates/common/header.hbs'),
            post: await this.load('./templates/post/post.hbs')
        };

        const posts = await getAllPostByUser(this.app.userData.userId);
        const context = Object.assign({ posts }, this.app.userData);

        this.partial('./templates/home.hbs', context);
    } else {
        this.partials = {
            header: await this.load('./templates/common/header.hbs'),
        };

        this.partial('./templates/home.hbs', this.app.userData);
    }
}