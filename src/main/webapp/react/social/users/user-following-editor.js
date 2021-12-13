import followService from "./../follows/follow-service"

const { useState, useEffect } = React;
const {Link, useParams} = window.ReactRouterDOM;

const UserFollowingEditor = () => {
    const {userId} = useParams()
    const [followings, setFollowings] = useState([])
    useEffect(() => {
        findAllUserFollowing()
    }, [])

    const findAllUserFollowing = () =>
        followService.findAllUserFollowing(userId)
            .then(allUserFollowing => setFollowings(allUserFollowing))

    // const history = useHistory()

    return(
        <div>
            <h2>Followed by User</h2>
            <ul className="list-group">
                {
                    followings.map(following =>
                        <li key={following.id} className="list-group-item">
                            <Link to={`/follows/${following.id}`}>
                                {following.from.firstName} {" follows "}
                                {following.to.firstName}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default UserFollowingEditor;