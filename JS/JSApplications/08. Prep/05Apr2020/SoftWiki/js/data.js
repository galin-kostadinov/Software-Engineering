function host(endpoint) {
    return `https://api.backendless.com/8E03AC6F-C1B8-1C06-FF29-42D767ABCE00/1A24637D-4D73-4F24-A7EB-6BFB665DA1BE/${endpoint}`;
}

const endpoints = {
    REGISTER: 'users/register',
    LOGIN: 'users/login',
    LOGOUT: 'users/logout',
    ARTICLE: 'data/articles',
    ARTICLE_BY_ID: 'data/articles/'
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

    return login(email, password);
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

export async function getArticleByCategory(category) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.ARTICLE + `?where=${escape(`category LIKE '${category}'`)}`), {
        headers: {
            'user-token': token
        }
    })).json();

    return result;
}

export async function getArticles() {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.ARTICLE), {
        headers: {
            'user-token': token
        }
    })).json();

    return result;
}

export async function getArticleById(id) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.ARTICLE_BY_ID + id), {
        headers: {
            'user-token': token
        }
    })).json();

    return result;
}

export async function createArticle(article) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.ARTICLE), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(article)
    })).json();

    return result;
}

export async function updateArticle(id, updatedProps) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.ARTICLE_BY_ID + id), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(updatedProps)
    })).json();

    return result;
}

export async function deleteArticle(id) {
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.ARTICLE_BY_ID + id), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        }
    })).json();

    return result;
}
