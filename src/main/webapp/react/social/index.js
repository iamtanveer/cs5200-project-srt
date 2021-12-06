import UserList from "./users/user-list";
import UserFormEditor from "./users/user-form-editor";
import FollowFormEditor from "./follows/follow-form-editor";
import FollowList from "./follows/follow-list";
import AuthorList from "./authors/author-list";
import AuthorFormEditor from "./authors/author-form-editor";

const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/users", "/"]} exact={true}>
                    <UserList/>
                </Route>
                <Route path="/users/:id" exact={true}>
                    <UserFormEditor/>
                </Route>
                <Route path={["/follows", "/"]} exact={true}>
                    <FollowList/>
                </Route>
                <Route path="/follows/:id" exact={true}>
                    <FollowFormEditor/>
                </Route>
                <Route path={["/authors", "/"]} exact={true}>
                    <AuthorList/>
                </Route>
                <Route path="/authors/:id" exact={true}>
                    <AuthorFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
