const LIKES_URL = "http://localhost:8080/api/likes"

// retrieve all likes from the server
export const findAllLikes = () => fetch(LIKES_URL)
    .then(response => response.json())

// retrieve a like comment by their ID
export const findLikeById = (id) => fetch(`${LIKES_URL}/${id}`)
    .then(response => response.json())

// delete a like by their ID
export const deleteLike = (id) => fetch(`${LIKES_URL}/${id}`, {
    method: "DELETE"
});

// create a new like record
export const createLike = (like) => fetch(LIKES_URL, {
    method: "POST",
    body: JSON.stringify(like),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// update a like by their ID
export const updateLike = (id, like) => fetch(`${LIKES_URL}/${id}`, {
    method: "PUT",
    body: JSON.stringify(like),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

//fetch likes by user
export const findLikesByUser = (id) => fetch(`${LIKES_URL}/user/${id}`)
    .then(response => response.json())

//fetch likes on article
export const findLikesOnArticle = (id) => fetch(`${LIKES_URL}/article/${id}`)
    .then(response => response.json())

// export all functions as the API to this service
export default {
    findAllLikes,
    findLikeById,
    updateLike,
    deleteLike,
    createLike,
    findLikesByUser,
    findLikesOnArticle
}
