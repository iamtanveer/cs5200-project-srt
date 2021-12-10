import commentService from "./comment-service"
const {useParams, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const CommentFormEditor = () => {
    const {id} = useParams()
    const [comment, setComment] = useState({})
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
            <h2>Comment Editor</h2>
            {/*<label>Id</label>*/}
            {/*<input className="form-control" value={comment.id}/><br/>*/}

            <label>Comment content</label>
            <input onChange={(e) => setComment(comment => ({
                ...comment, content: e.target.value
            }))} className="form-control" value={comment.content}/><br/>

            {/*<label>Category</label>*/}
            {/*<input onChange={(e) => setArticle(article => ({*/}
            {/*    ...article, category: e.target.value*/}
            {/*}))} className="form-control" value={article.category.category}/><br/>*/}

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteComment(comment.id)} className="btn btn-danger">Delete</button>
            <button onClick={() => updateComment(comment.id, comment)} className="btn btn-primary">Save</button>
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
export default CommentFormEditor