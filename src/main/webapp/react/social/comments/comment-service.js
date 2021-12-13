const COMMENTS_URL = "http://localhost:8080/api/comments"

// retrieve all comments from the server
export const findAllComments = () => fetch(COMMENTS_URL)
    .then(response => response.json())

// retrieve a single comment by their ID
export const findCommentById = (id) => fetch(`${COMMENTS_URL}/${id}`)
    .then(response => response.json())

// delete a comment by their ID
export const deleteComment = (id) => fetch(`${COMMENTS_URL}/${id}`, {
    method: "DELETE"
});

// create a new comment
export const createComment = (comment) => fetch(COMMENTS_URL, {
    method: "POST",
    body: JSON.stringify(comment),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// update a comment by their ID
export const updateComment = (id, comment) => fetch(`${COMMENTS_URL}/${id}`, {
    method: "PUT",
    body: JSON.stringify(comment),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

//fetch comments by article
export const findCommentsOnArticle = (id) => fetch(`${COMMENTS_URL}/article/${id}`)
    .then(response => response.json())

//fetch comments by user
export const findCommentsByUser = (id) => fetch(`${COMMENTS_URL}/user/${id}`)
    .then(response => response.json())

// export all functions as the API to this service
export default {
    findAllComments,
    findCommentById,
    updateComment,
    deleteComment,
    createComment,
    findCommentsOnArticle,
    findCommentsByUser
}
