import likeService from "./../likes/like-service"

const { useState, useEffect } = React;
const {Link, useHistory, useParams} = window.ReactRouterDOM;

const UserLikeEditor = () => {
    const {userId} = useParams()
    const [likes, setLikes] = useState([])
    useEffect(() => {
        findAllLikesByUser()
    }, [])

    const findAllLikesByUser = () =>
        likeService.findLikesByUser(userId)
            .then(findAllLikesByUser => setLikes(findAllLikesByUser))

    // const history = useHistory()

    return(
        <div>
            <h2>Likes by User</h2>
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

export default UserLikeEditor;