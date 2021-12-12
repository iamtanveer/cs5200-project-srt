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
                                {like.id} {": "} {like.user.id}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default UserLikeEditor;