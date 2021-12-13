import likeService from "./../likes/like-service"

const { useState, useEffect } = React;
const {Link, useHistory, useParams} = window.ReactRouterDOM;

const ArticleLikeEditor = () => {
    const {articleId} = useParams()
    const [likes, setLikes] = useState([])
    useEffect(() => {
        findAllLikesOnArticle()
    }, [])

    const findAllLikesOnArticle = () => {
        console.log(articleId);
        likeService.findLikesOnArticle(articleId)
            .then(findAllLikesOnArticle => setLikes(findAllLikesOnArticle))
    }


    // const history = useHistory()

    return(
        <div>
            <h2>Likes on Article</h2>
            <ul className="list-group">
                {
                    likes.map(like =>
                        <li key={like.id} className="list-group-item">
                            <Link to={`/likes/${like.id}`}>
                                {"User "}{like.user.firstName} {" liked Article "} {like.article.title}
                            </Link>
                        </li>)
                }
            </ul>
            <br/>
            <button onClick={() => history.back()} className="btn btn-warning">Go back</button>
        </div>
    )
}

export default ArticleLikeEditor;