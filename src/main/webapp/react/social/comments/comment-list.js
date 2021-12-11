import commentService from "./comment-service"
const { useState, useEffect } = React;

const {Link, useHistory} = window.ReactRouterDOM;

const CommentList = () => {
    const [comments, setComments] = useState([])
    useEffect(() => {
        findAllComments()
    }, [])
    const findAllComments = () =>
        commentService.findAllComments()
            .then(comments => setComments(comments))
    const history = useHistory()

    return(
        <div>
            <h2>Comments</h2>
            <button onClick={() => history.push("/comments/new")}>Add Comment</button>
            <ul className="list-group">
                {
                    comments.map(comment =>
                        <li key={comment.id} className="list-group-item">
                            <Link to={`/comments/${comment.id}`}>
                                {comment.id} {": "} {comment.comment}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default CommentList;