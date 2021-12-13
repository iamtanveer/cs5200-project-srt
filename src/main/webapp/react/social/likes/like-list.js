import likeService from "./like-service"
const { useState, useEffect } = React;

const {Link, useHistory} = window.ReactRouterDOM;

const LikeList = () => {
    const [likes, setLikes] = useState([])
    useEffect(() => {
        findAllLikes()
    }, [])
    const findAllLikes = () =>
        likeService.findAllLikes()
            .then(likes => setLikes(likes))
    const history = useHistory()

    return(
        <div>
            <h2>Likes</h2>
            <button onClick={() => history.push("/likes/new")}>Add Like</button>
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
        </div>
    )
}

export default LikeList;