import { createPost, getPostById, updatePost, deletePost as apiDelete, getAllPostByUser } from '../data.js';

export async function create() {
    try {
        if (this.params.title.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.content.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.category.length === 0) {
            throw new Error('Title is required');
        }

        const post = {
            title: this.params.title,
            content: this.params.content,
            category: this.params.category,
        };

        const result = await createPost(post);

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
    };

    const postId = this.params.id;
    let post = await getPostById(postId);

    const context = Object.assign({ post }, this.app.userData);

    this.partial('./templates/post/details.hbs', context);
}

export async function edit() {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        post: await this.load('./templates/post/post.hbs')
    };

    const posts = await getAllPostByUser(this.app.userData.userId);
  
    console.log(posts);

    const postId = this.params.id;
    let post = await getPostById(postId);

    const context = Object.assign({ post , posts}, this.app.userData);

    this.partial('./templates/post/edit.hbs', context);
}

export async function editPost() {
    const postId = this.params.id;

    try {
        if (this.params.title.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.content.length === 0) {
            throw new Error('Title is required');
        }

        if (this.params.category.length === 0) {
            throw new Error('Title is required');
        }

        const post = {
            title: this.params.title,
            content: this.params.content,
            category: this.params.category,
        };

        const result = await updatePost(postId, post);

        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/home');
    } catch (err) {
        console.error(err);
        showError(err.message);
    }
}

export async function deletePost() {
    if (confirm('Are you sure you want to delete this post?') == false) {
        return;
    }

    const postId = this.params.id;

    try {
        const result = await apiDelete(postId);

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