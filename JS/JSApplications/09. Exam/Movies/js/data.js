
function host(endpoint) {
    return `https://api.backendless.com/EC9D41E4-7B14-948B-FFB4-18E9AFF27200/F92E866A-AECB-46E5-9EE4-4E18335C70C7/${endpoint}`;
}

const endpoints = {
    REGISTER: 'users/register',
    LOGIN: 'users/login',
    LOGOUT: 'users/logout',
    MOVIES: 'data/movies',
    MOVIE_BY_ID: 'data/movies/'
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

// get all movies
export async function getMovies(search) {
    
    const token = localStorage.getItem('userToken');

    let result;

    if (!search) {
        result = (await fetch(host(endpoints.MOVIES), {
            headers: {
                'user-token': token
            }
        })).json();
    } else {
        result = (await fetch(host(endpoints.MOVIES + `?where=${escape(`genres LIKE '%${search}%'`)}`), {
            headers: {
                'user-token': token
            }
        })).json();
    }

   

    return result;
}

// get movie by ID
export async function getMovieById(id) {
    
    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.MOVIE_BY_ID + id), {
        headers: {
            'user-token': token
        }
    })).json();

   

    return result;
}

// create movie
export async function createMovie(movie) {
   

    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.MOVIES), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(movie)
    })).json();

   

    return result;
}

// edit movie
export async function updateMovie(id, updatedProps) {
   

    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.MOVIE_BY_ID + id), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(updatedProps)
    })).json();



    return result;
}

// like movie
export async function likeMovie(id, updatedProps) {
    const token = localStorage.getItem('userToken');
    console.log(`updatedProps`);
    console.log(updatedProps);

    const result = (await fetch(host(endpoints.MOVIE_BY_ID + id), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(updatedProps)
    })).json();

    return result;
}

// delete movie
export async function deleteMovie(id) {

    const token = localStorage.getItem('userToken');

    const result = (await fetch(host(endpoints.MOVIE_BY_ID + id), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        }
    })).json();

    return result;
}
