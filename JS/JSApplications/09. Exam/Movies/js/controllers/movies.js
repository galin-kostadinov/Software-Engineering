import { showInfo, showError } from '../notification.js';
import { createMovie, getMovieById, updateMovie, deleteMovie as apiDelete, likeMovie as apiLike } from '../data.js';

export async function create() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    this.partial('./templates/movie/create.hbs', this.app.userData);
}

export async function createPost() {
    try {
        if (this.params.title.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.imageUrl.length === 0) {
            throw new Error('Image Url is required');
        }

        if (this.params.description.length === 0) {
            throw new Error('Description is required');
        }

        const movie = {
            title: this.params.title,
            imageUrl: this.params.imageUrl,
            description: this.params.description,
            likes: 0
        };

        const result = await createMovie(movie);

        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/home');
    } catch (err) {
        alert(err.message);
    }
}

export async function details() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    const movieId = this.params.id;

    let movie = await getMovieById(movieId);

    let isCreator = undefined;
    let isAlreadyLiked = undefined;

    if (movie.ownerId === this.app.userData.userId) {
        isCreator = true;
    } else if (movie.emails !== undefined && movie.emails !== null && movie.emails.includes(this.app.userData.email)) {
        isAlreadyLiked = true;
    }

    const context = Object.assign({ movie, isCreator, isAlreadyLiked }, this.app.userData);

    this.partial('./templates/movie/details.hbs', context);
}

export async function edit() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    const movieId = this.params.id;

    let movie = await getMovieById(movieId);

    const context = Object.assign({ movie }, this.app.userData);

    this.partial('./templates/movie/edit.hbs', context);
}

export async function editPost() {
    const movieId = this.params.id;

    try {
        if (this.params.title.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.imageUrl.length === 0) {
            throw new Error('Image Url is required');
        }

        if (this.params.description.length === 0) {
            throw new Error('Description is required');
        }

        const movie = {
            title: this.params.title,
            imageUrl: this.params.imageUrl,
            description: this.params.description
        };

        const result = await updateMovie(movieId, movie);

        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/details/' + result.objectId);
    } catch (err) {
        alert(err.message);
    }
}

export async function likeUp() {
    const movieId = this.params.id;

    let movie = await getMovieById(movieId);
   
    let likes = Number(movie.likes) + 1;

    let emails = '';

    if (movie.emails !== undefined && movie.emails !== null) {
        emails = `${movie.emails}, ${this.app.userData.email}`;
    } else {
        emails = `${this.app.userData.email}`;
    }

    console.log(emails);
    try {
        const movie = {
            likes: likes,
            emails: emails
        };

        const result = await apiLike(movieId, movie);
        console.log(result);

        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/details/' + result.objectId);
    } catch (err) {
        alert(err.message);
    }
}

export async function deleteMovie() {
    const movieId = this.params.id;
    if (confirm('Are you sure you want to delete this movie?') == false) {
        this.redirect('#/details/' + movieId)
        return;
    }

    try {
        const result = await apiDelete(movieId);

        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/home');
    } catch (err) {
        alert(err.message);
    
    }
}