const ARTICLES_URL = "http://localhost:8080/api/articles"

// retrieve all articles from the server
export const findAllArticles = () => fetch(ARTICLES_URL)
    .then(response => response.json())

// retrieve a single article by their ID
export const findArticleById = (id) => fetch(`${ARTICLES_URL}/${id}`)
    .then(response => response.json())

// delete an article by their ID
export const deleteArticle = (id) => fetch(`${ARTICLES_URL}/${id}`, {
    method: "DELETE"
});

// create a new article
export const createArticle = (article) => fetch(ARTICLES_URL, {
    method: "POST",
    body: JSON.stringify(article),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// update an article by their ID
export const updateArticle = (id, article) => fetch(`${ARTICLES_URL}/${id}`, {
    method: "PUT",
    body: JSON.stringify(article),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

// get all articles by author
export const getArticlesByAuthor = (id) => fetch(`${ARTICLES_URL}/author/${id}`)
    .then(response => response.json())

// export all functions as the API to this service
export default {
    findAllArticles,
    findArticleById,
    updateArticle,
    createArticle,
    deleteArticle,
    getArticlesByAuthor
}
