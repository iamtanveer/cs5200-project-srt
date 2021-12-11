import commentService from "./comment-service"
const {useParams, useHistory} = window.ReactRouterDOM;
import userService from "./../users/user-service"
import {findArticleById} from "../articles/article-service";
const {useState, useEffect} = React;

const CommentFormEditor = () => {
    const {id} = useParams()
    const [comment, setComment] = useState({
        "user": {
            "id": ""
        },
        "article" : {
            "id": ""
        }
    })
    useEffect(() => {
        if (id !== "new") {
            findCommentById(id)
        }
    }, []);

    const updateComment = (id, newComment) => commentService.updateComment(id, newComment)
        .then(() => history.back())

    const createComment = (comment) => commentService.createComment(comment)
        .then(() => history.back())

    const findCommentById = (id) => commentService.findCommentById(id)
        .then(comment => setComment(comment))

    const deleteComment = (id) => commentService.deleteComment(id)
        .then(() => history.back())

    return (
        <div>
            <h2>Comment Id</h2>
            <label>Id</label>
            <input className="form-control" value={comment.id}/><br/>

            <label>Comment content</label>
            <input onChange={(e) => setComment(comment => ({
                ...comment, comment: e.target.value
            }))} className="form-control" value={comment.comment}/><br/>

            <label>Commented by User Id</label>
            <input onChange={(e) => setComment(comment => ({
                ...comment, user: e.target.value
            }))} className="form-control" value={comment.user.id}/><br/>

            <label>Commented on Article Id</label>
            <input onChange={(e) => setComment(comment => ({
                ...comment, article: e.target.value
            }))} className="form-control" value={comment.article.id}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteComment(comment.id)} className="btn btn-danger">Delete</button>
            <button onClick={() => updateComment(comment.id, comment)} className="btn btn-primary">Save</button>
            <button onClick={() => {
                const userId = userService.findUserById(comment.user)
                    .then((user) => {
                        const articleId = findArticleById(comment.article)
                            .then((article) => {
                                createComment({
                                    "article": article, "user": user, "comment": comment.comment
                                })
                            })
                    }
                    )}} className="btn btn-success">Create</button>
        </div>
    )
}
export default CommentFormEditor