import followService from "./follow-service"
const { useState, useEffect } = React;

const {Link, useHistory} = window.ReactRouterDOM;

const FollowList = () => {
    const [follows, setFollows] = useState([])
    useEffect(() => {
        findAllFollows()
    }, [])
    const findAllFollows = () =>
        followService.findAllFollows()
            .then(follows => setFollows(follows))
    const history = useHistory()

    return(
        <div>
            <h2>Follows</h2>
            <button onClick={() => history.push("/follows/new")}>Add Follow</button>
            <ul className="list-group">
                {
                    // follows.map(follow =>
                    //     <li key={follow.id} className="list-group-item">
                    //         {/*<Link to={`/follows/${follow.id}`}>*/}
                    //         {/*    {follow.id},*/}
                    //         {/*    {follow.from},*/}
                    //         {/*    {follow.to}*/}
                    //         {/*</Link>*/}
                    //         <h1>{follow.id}</h1>
                    //     </li>)
                }
            </ul>
        </div>
    )
}

export default FollowList;