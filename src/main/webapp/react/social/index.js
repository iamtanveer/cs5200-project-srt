import UserList from "./users/user-list";
import UserFormEditor from "./users/user-form-editor";
import FollowFormEditor from "./follows/follow-form-editor";
import FollowList from "./follows/follow-list";
import AuthorList from "./authors/author-list";
import AuthorFormEditor from "./authors/author-form-editor";
import ArticleList from "./articles/article-list";
import ArticleFormEditor from "./articles/article-form-editor";
import CommentList from "./comments/comment-list";
import CommentFormEditor from "./comments/comment-form-editor";
import LikeList from "./likes/like-list";
import LikeFormEditor from "./likes/like-form-editor";
import ArticleCommentEditor from "./articles/article-comment-editor";


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
                <Route path={["/articles", "/"]} exact={true}>
                    <ArticleList/>
                </Route>
                <Route path="/articles/:id" exact={true}>
                    <ArticleFormEditor/>
                </Route>
                <Route path={["/comments", "/"]} exact={true}>
                    <CommentList/>
                </Route>
                <Route path="/comments/:id" exact={true}>
                    <CommentFormEditor/>
                </Route>
                <Route path={["/likes", "/"]} exact={true}>
                    <LikeList/>
                </Route>
                <Route path="/likes/:id" exact={true}>
                    <LikeFormEditor/>
                </Route>
                <Route path="/comments/article/:articleId" exact={true}>
                    <ArticleCommentEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
