import { getArticleByCategory, createArticle, getArticleById, updateArticle, deleteArticle as apiDelete} from '../data.js';

export default async function home() {
    this.partials = {
        header: await this.load('../templates/common/header.hbs'),
        footer: await this.load('../templates/common/footer.hbs'),
        article: await this.load('./templates/article/article.hbs')
    };

    if (this.app.userData.email) {
        const jsArticles = await getArticleByCategory('JavaScript');
        const csArticles = await getArticleByCategory('C#');
        const javaArticles = await getArticleByCategory('Java');
        const pytonArticles = await getArticleByCategory('Pyton');

        const context = Object.assign({ jsArticles, csArticles, javaArticles, pytonArticles }, this.app.userData);

        this.partial('./templates/home.hbs', context);
    } else {
        this.partial('./templates/user/login.hbs');
    }
}

export async function create() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    this.partial('./templates/article/create.hbs', this.app.userData);
}

export async function createPost() {
    try {
        if (this.params.title.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.category.length === 0) {
            throw new Error('Category is required');
        }

        if (this.params.content.length === 0) {
            throw new Error('Content is required');
        }

        const article = {
            title: this.params.title,
            category: this.params.category,
            content: this.params.content,
            creator: this.app.userData.email
        };

        const result = await createArticle(article);

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

    const articleId = this.params.id;
    const article = await getArticleById(articleId);

    const isCreator = article.creator == this.app.userData.email;

    console.log(article);
    const context = Object.assign({ article, isCreator }, this.app.userData);

    this.partial('./templates/article/details.hbs', context);
}

export async function edit() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    const articleId = this.params.id;

    const article = await getArticleById(articleId);

    const context = Object.assign({ article }, this.app.userData)

    this.partial('./templates/article/edit.hbs', context);
}

export async function editPost() {
    const articleId = this.params.id;

    try {
        if (this.params.title.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.category.length === 0) {
            throw new Error('Category is required');
        }

        if (this.params.content.length === 0) {
            throw new Error('Content is required');
        }

        const article = {
            title: this.params.title,
            category: this.params.category,
            content: this.params.content,
        };

        const result = await updateArticle(articleId, article);

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

export async function deleteArticle() {
    if (confirm('Are you sure you want to delete this article?') == false) {
        return;
    }

    const articleId = this.params.id;

    try {
        const result = await apiDelete(articleId);

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