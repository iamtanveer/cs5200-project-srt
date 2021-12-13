import followService from "./../follows/follow-service"

const { useState, useEffect } = React;
const {Link, useParams} = window.ReactRouterDOM;

const UserFollowersEditor = () => {
    const {userId} = useParams()
    const [followers, setFollowers] = useState([])
    useEffect(() => {
        findAllUserFollowers()
    }, [])

    const findAllUserFollowers = () =>
        followService.findAllUserFollowers(userId)
            .then(allUserFollowers => setFollowers(allUserFollowers))

    return(
        <div>
            <h2>Followers of the User</h2>
            <ul className="list-group">
                {
                    followers.map(follower =>
                        <li key={follower.id} className="list-group-item">
                            <Link to={`/follows/${follower.id}`}>
                                {follower.from.firstName} {" follows "}
                                {follower.to.firstName}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default UserFollowersEditor;