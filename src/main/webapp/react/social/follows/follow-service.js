const FOLLOWS_URL = "http://localhost:8080/api/follows"

// TODO: retrieve all follows from the server
export const findAllFollows = () => fetch(FOLLOWS_URL)
    .then(response => response.json())

// TODO: retrieve a single follow by their ID
export const findFollowsByID = (id) => fetch(`${FOLLOWS_URL}/${id}`)
    .then(response => response.json())

// TODO: delete a follow by their ID
export const deleteFollow = (id) => fetch(`${FOLLOWS_URL}/${id}`, {
    method: "DELETE"
});

// TODO: create a new follow
export const createFollow = (follow) => fetch(FOLLOWS_URL, {
    method: "POST",
    body: JSON.stringify(follow),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// TODO: update a follow by their ID
export const updateFollow = (id, follow) => fetch(`${FOLLOWS_URL}/${id}`, {
    method: "PUT",
    body: JSON.stringify(follow),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllFollows,
    findFollowsByID,
    deleteFollow,
    createFollow,
    updateFollow
}
