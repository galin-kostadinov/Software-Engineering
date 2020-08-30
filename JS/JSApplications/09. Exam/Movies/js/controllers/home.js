import { getMovies } from '../data.js';


export default async function home() {
    if (this.app.userData.email != undefined) {
        this.partials = {
            header: await this.load('./templates/common/header.hbs'),
            footer: await this.load('./templates/common/footer.hbs'),
            movie: await this.load('./templates/movie/movie.hbs')
        };

        const movies = await getMovies();
        console.log(movies);
        const context = Object.assign({ movies }, this.app.userData);

        this.partial('./templates/home.hbs', context);
    } else {
        this.partials = {
            header: await this.load('./templates/common/header.hbs'),
            footer: await this.load('./templates/common/footer.hbs')
        };

        this.partial('./templates/home.hbs', this.app.userData);
    } 
}