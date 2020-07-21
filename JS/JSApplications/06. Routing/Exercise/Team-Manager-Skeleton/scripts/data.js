function host(endpoint) {
    return `https://api.backendless.com/F6298C90-AF26-CA85-FF03-7C0F06068B00/79323C49-455B-4FA6-A6F9-3C56E2178E96/${endpoint}`;
}

const endpoints = {
    REGISTER: 'users/register',
    LOGIN: 'users/login',
    TEAMS: 'data/teams',
    UPDATE_USER: 'users/',
    LOGOUT: 'users/logout',
    UPDATE_TEAM: 'data/teams/'
}

export async function register(username, password) {
    return (await fetch(host(endpoints.REGISTER), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password
        })
    })).json();
}

export async function login(username, password) {
    return (await fetch(host(endpoints.LOGIN), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            login: username,
            password
        })
    })).json();
}

export async function logout(username, password) {
    const token = localStorage.getItem('userToken');

    if (!token) {
        throw new Error('User is not logged in');
    }

    return fetch(host(endpoints.LOGOUT), {
        method: 'GET',
        headers: {
            'user-token': token
        }
    });
}

async function setUserTeamId(userId, teamId) {
    const token = localStorage.getItem('userToken');

    if (!token) {
        throw new Error('User is not logged in');
    }

    return (await fetch(host(endpoints.UPDATE_USER + userId), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify({
            teamId
        })
    })).json();
}

export async function createTeam(team) {
    const token = localStorage.getItem('userToken');

    if (!token) {
        throw new Error('User is not logged in');
    }

    const result = await (await fetch(host(endpoints.TEAMS), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify(team)
    })).json();


    if (result.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, result);
        throw error;
    }

    const userUpdatedResult = await setUserTeamId(result.ownerId, result.objectId)

    if (userUpdatedResult.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, userUpdatedResult);
        throw error;
    }

    return result;
}

export async function getTeamById(id) {
    return (await fetch(host(endpoints.TEAMS + '/' + id))).json();
}

export async function getTeams() {
    return (await fetch(host(endpoints.TEAMS))).json();
}

export async function updateTeam(team, teamId) {
    const token = localStorage.getItem('userToken');

    if (!token) {
        throw new Error('User is not logged in');
    }

    return (await fetch(host(endpoints.UPDATE_TEAM + teamId), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify({
            name:team.name,
            comment:team.comment
        })
    })).json();
}