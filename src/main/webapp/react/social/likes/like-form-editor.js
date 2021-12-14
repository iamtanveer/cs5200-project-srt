import likeService from "./like-service"
const {Link, useParams, useHistory} = window.ReactRouterDOM;
import userService from "./../users/user-service"
import {findArticleById} from "../articles/article-service";
const {useState, useEffect} = React;

const LikeFormEditor = () => {
    const {id} = useParams()
    const [like, setLike] = useState({
        "user": {
            "id": ""
        },
        "article" : {
            "id": ""
        }
    })
    useEffect(() => {
        if (id !== "new") {
            findLikeById(id)
        }
    }, []);

    const updateLike = (id, newLike) => likeService.updateLike(id, newLike)
        .then(() => history.back())

    const createLike = (like) => likeService.createLike(like)
        .then(() => history.back())

    const findLikeById = (id) => likeService.findLikeById(id)
        .then(like => setLike(like))

    const deleteLike = (id) => likeService.deleteLike(id)
        .then(() => history.back())

    return (
        <div>
            <h2>Like Id</h2>
            <label>Id</label>
            <input className="form-control" value={like.id}/><br/>

            <label>Like by User Id</label>
            <input onChange={(e) => setLike(like => ({
                ...like, user: e.target.value
            }))} className="form-control" value={like.user.id}/><br/>

            <label>Article liked</label>
            <input onChange={(e) => setLike(like => ({
                ...like, article: e.target.value
            }))} className="form-control" value={like.article.id}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteLike(like.id)} className="btn btn-danger">Delete</button>
            <button onClick={() => {
                const userId = userService.findUserById(like.user)
                    .then((user) => {
                            const articleId = findArticleById(like.article.id)
                                .then((article) => {
                                    updateLike(like.id,
                                        {"article": article, "user": user})
                                })
                        }
                    )
            }} className="btn btn-primary">Save</button>

            <button onClick={() => {
                const userId = userService.findUserById(like.user)
                    .then((user) => {
                        const articleId = findArticleById(like.article)
                            .then((article) => {
                                createLike({
                                    "article": article, "user": user
                                })
                            })
                    }
                    )}} className="btn btn-success">Create</button>
            <br/>
            <Link to={`/articles/${like.article.id}`}>Get Article</Link>
            <br/>
            <Link to={`/users/${like.user.id}`}>Get User</Link>
        </div>
    )
}
export default LikeFormEditor;
