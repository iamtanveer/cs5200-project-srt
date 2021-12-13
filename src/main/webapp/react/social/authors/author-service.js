const AUTHORS_URL = "http://localhost:8080/api/authors"

// retrieve all authors from the server
export const findAllAuthors = () => fetch(AUTHORS_URL)
    .then(response => response.json())

// retrieve a single author by their ID
export const findAuthorById = (id) => fetch(`${AUTHORS_URL}/${id}`)
    .then(response => response.json())

// delete an author by their ID
export const deleteAuthor = (id) => fetch(`${AUTHORS_URL}/${id}`, {
    method: "DELETE"
});

// create a new author
export const createAuthor = (author) => fetch(AUTHORS_URL, {
    method: "POST",
    body: JSON.stringify(author),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// update an author by their ID
export const updateAuthor = (id, author) => fetch(`${AUTHORS_URL}/${id}`, {
    method: "PUT",
    body: JSON.stringify(author),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// export all functions as the API to this service
export default {
    findAllAuthors,
    findAuthorById,
    deleteAuthor,
    createAuthor,
    updateAuthor
}
