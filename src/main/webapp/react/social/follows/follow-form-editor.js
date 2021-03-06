import followService from "./follow-service"
import {findUserById} from "../users/user-service";
const {Link, useParams, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const FollowFormEditor = () => {
    const {id} = useParams()
    const [follow, setFollow] = useState({
        "from": {
            "id": ""
        },
        "to": {
            "id": ""
        }
    })
    useEffect(() => {
        if(id !== "new"){
            findFollowsById(id)
        }
    }, []);

    // const updateFollow = (id, ) => followService.updateFollow(id, newFollow)
    //     .then(() => history.back())

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
                }))} className="form-control" value={follow.from.id}/><br/>

            <label>Followee</label>
            <input onChange={(e) =>
                setFollow(follow => ({
                    ...follow, to: e.target.value
                }))} className="form-control" value={follow.to.id}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteFollow(follow.id)} className="btn btn-danger">Delete</button>
            {/*<button onClick={() => updateUser(user.id, user)} className="btn btn-primary">Save</button>*/}
            <button onClick={() => {const from = findUserById(follow.from).then((res) => {
                const to = findUserById(follow.to).then((r2) => {
                    createFollow({"from": res, "to": r2})
                })
                }
            )}} className="btn btn-success">Create</button>
            <br/>
            <Link to={`/users/${follow.from.id}`}>Get Follower</Link>
            <br/>
            <Link to={`/users/${follow.to.id}`}>Get Followee</Link>
        </div>
    )
}

export default FollowFormEditor