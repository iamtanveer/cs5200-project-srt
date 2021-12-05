import followService from "./follow-service"
const {useParams, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const FollowFormEditor = () => {
    const {id} = useParams()
    const [follow, setFollow] = useState({})
    useEffect(() => {
        if(id !== "new"){
            findFollowsByID(id)
        }
    }, []);

    const updateFollow = (id, newFollow) => followService.updateFollow(id, newFollow)
        .then(() => history.back())

    const createFollow = (follow) => followService.createFollow(follow)
        .then(() => history.back())

    const findFollowsById = (id) => followService.findFollowsByID(id)
        .then(follow => setFollow(follow))

    const deleteFollow = (id) => followService.deleteFollow(id)
        .then(() => history.back())

    return (
        <div>
            <h2>Follow Editor</h2>
            <label>Id</label>
            <input className="form-control" value={follow.id}/><br/>

            <label>Follower</label>
            <input onChange={(e) =>
                setFollow(follow => ({
                    ...follow, from: e.target.value
                }))} className="form-control" value={follow.from}/><br/>

            <label>Following</label>
            <input onChange={(e) =>
                setFollow(follow => ({
                    ...follow, to: e.target.value
                }))} className="form-control" value={follow.to}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteFollow(follow.id)} className="btn btn-danger">Delete</button>
            {/*<button onClick={() => updateUser(user.id, user)} className="btn btn-primary">Save</button>*/}
            <button onClick={() => createFollow(follow)} className="btn btn-success">Create</button>
        </div>
    )
}

export default UserFormEditor