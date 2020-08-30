function host(endpoint) {
    return `https://api.backendless.com/BB200BE6-7A50-6F89-FF4C-C22F8F715D00/CF6293AE-60FE-4CF8-A4EE-579422507534/${endpoint}`;
}

const endpoints = {
    REGISTER: 'users/register',
    LOGIN: 'users/login',
    LOGOUT: 'users/logout',
    POSTS: 'data/posts',
    POSTS_BY_ID: 'data/posts/'
};

export async function register(email, password) {

    const result = (await fetch(host(endpoints.REGISTER), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email,
            password
        })
    })).json();

    return result;
}

export async function login(email, password) {
    const result = await (await fetch(host(endpoints.LOGIN), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            login: email,
            password
        })
    })).json();

    localStorage.setItem('userToken', result['user-token']);
    localStorage.setItem('email', result.email);
    localStorage.setItem('userId', result.objectId);

    return result;
}

export async function logout() {
    const token = localStorage.getItem('userToken');

    localStorage.removeItem('userToken');

    const result = fetch(host(endpoints.LOGOUT), {
        headers: {
            'user-token': token
        }
    });

    return result;
}

export async function getAllPostByUser(userId) {
    const token = localStorage.getItem('userToken');

    let result = (await fetch(host(endpoints.POSTS + `?where=${escape(`ownerId LIKE '${userId}'`)}`), {
        headers: {
            'user-token': token
        }
    })).json();
   
    return result;
}

export async function getPostById(id) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.POSTS_BY_ID + id), {
        headers: {
            'user-token': token
        }
    })).json();

    return result;
}

export async function createPost(post) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.POSTS), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(post)
    })).json();


    return result;
}

export async function updatePost(id, updatedProps) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.POSTS_BY_ID + id), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(updatedProps)
    })).json();

    return result;
}

export async function deletePost(id) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.POSTS_BY_ID + id), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        }
    })).json();

    return result;
}
