import commentService from "./../comments/comment-service"

const { useState, useEffect } = React;
const {Link, useHistory, useParams} = window.ReactRouterDOM;

const ArticleCommentEditor = () => {
    const {articleId} = useParams()
    const [comments, setComments] = useState([])
    useEffect(() => {
        findAllCommentsByArticle()
    }, [])

    const findAllCommentsByArticle = () =>
        commentService.findCommentsOnArticle(articleId)
            .then(findAllCommentsByArticle => setComments(findAllCommentsByArticle))

    // const history = useHistory()

    return(
        <div>
            <h2>Comments by Article</h2>
            {/*<button onClick={() => history.push("/articles/new")}>Add Article</button>*/}
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

export default ArticleCommentEditor;