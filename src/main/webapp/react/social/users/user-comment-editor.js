import commentService from "./../comments/comment-service"

const { useState, useEffect } = React;
const {Link, useHistory, useParams} = window.ReactRouterDOM;

const UserCommentEditor = () => {
    const {userId} = useParams()
    const [comments, setComments] = useState([])
    useEffect(() => {
        findAllCommentsByUser()
    }, [])

    const findAllCommentsByUser = () =>
        commentService.findCommentsByUser(userId)
            .then(findAllCommentsByUser => setComments(findAllCommentsByUser))

    // const history = useHistory()

    return(
        <div>
            <h2>Comments by User</h2>
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
            <br/>
            <button onClick={() => history.back()} className="btn btn-warning">Go back</button>
        </div>
    )
}

export default UserCommentEditor;