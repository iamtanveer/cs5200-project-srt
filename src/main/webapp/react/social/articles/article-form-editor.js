import articleService from "./article-service"
import {findAuthorById} from "../authors/author-service";
import {createUser, findUserById} from "../users/user-service";
const {useParams, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const ArticleFormEditor = () => {
    const {id} = useParams()
    const [article, setArticle] = useState({
        "createdUser": {
            "id" : ""
        },
        "category": {
            "category": ""
        }
    })
    useEffect(() => {
        if (id !== "new") {
            findArticleById(id)
        }
    }, []);

    const updateArticle = (id, newArticle) => articleService.updateArticle(id, newArticle)
        .then(() => history.back())

    const createArticle = (article) => articleService.createArticle(article)
        .then(() => history.back())

    const findArticleById = (id) => articleService.findArticleById(id)
        .then(article => setArticle(article))

    const deleteArticle = (id) => articleService.deleteArticle(id)
        .then(() => history.back())

    return (
        <div>
            <h2>Article Editor</h2>
            <label>Id</label>
            <input className="form-control" value={article.id}/><br/>

            <label>Title</label>
            <input onChange={(e) => setArticle(article => ({
                ...article, title: e.target.value
            }))} className="form-control" value={article.title}/><br/>

            <label>Content</label>
            <input onChange={(e) => setArticle(article => ({
                ...article, content: e.target.value
            }))} className="form-control" value={article.content}/><br/>

            <label>Author Id</label>
            <input onChange={(e) => setArticle(article => ({
                ...article, createdUser: e.target.value
            }))} className="form-control" value={article.createdUser.id}/><br/>

            <label>Category</label>
            <input onChange={(e) => setArticle(article => ({
                ...article, category: e.target.value
            }))} className="form-control" value={article.category.category}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteArticle(article.id)} className="btn btn-danger">Delete</button>
            <button onClick={() => updateArticle(article.id, article)} className="btn btn-primary">Save</button>
            <button onClick={() => {const authorId = findAuthorById(article.createdUser).then((res) => {
                    createArticle({
                        "title": article.title,
                        "content": article.content,
                        "category": article.category,
                        "createdUser": res
                    })
                }
            )}} className="btn btn-success">Create</button>
        </div>
    )
}
export default ArticleFormEditor