import authorService from "./author-service"
const {Link, useParams, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const AuthorFormEditor = () => {
    const {id} = useParams()
    const [author, setAuthor] = useState({
        interest: {
            category: ""
        }
    })

    useEffect(() => {
        if(id !== "new"){
            findAuthorById(id)
        }
    }, []);

    const updateAuthor = (id, newAuthor) => authorService.updateAuthor(id, newAuthor)
        .then(() => history.back())

    const createAuthor = (author) => authorService.createAuthor(author)
        .then(() => history.back())

    const findAuthorById = (id) => authorService.findAuthorById(id)
        .then(author => setAuthor(author))

    const deleteAuthor = (id) => authorService.deleteAuthor(id)
        .then(() => history.back())

    return (
        <div>
            <h2>Author Editor</h2>
            <label>Id</label>
            <input className="form-control" value={author.id}/><br/>

            <label>First Name</label>
            <input onChange={(e) => setAuthor(author => ({
                ...author, firstName: e.target.value
            }))} className="form-control" value={author.firstName}/><br/>

            <label>Last Name</label>
            <input onChange={(e) => setAuthor(author => ({
                ...author, lastName: e.target.value
            }))} className="form-control" value={author.lastName}/><br/>

            <label>Username</label>
            <input onChange={(e) => setAuthor(author => ({
                ...author, username: e.target.value
            }))} className="form-control" value={author.username}/><br/>

            <label>Password</label>
            <input onChange={(e) =>
                setAuthor(author => ({
                    ...author, password: e.target.value
                }))} className="form-control" value={author.password}/><br/>

            <label>Date Of Birth</label>
            <input onChange={(e) =>
                setAuthor(author => ({
                    ...author, dateOfBirth: e.target.value
                }))} className="form-control" value={author.dateOfBirth}/><br/>

            <label>Interest</label>
            <input onChange={(e) =>
                setAuthor(author => ({
                    ...author, interest: e.target.value
                }))} className="form-control" value={author.interest.category}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteAuthor(author.id)} className="btn btn-danger">Delete</button>
            <button onClick={() => updateAuthor(author.id, author)} className="btn btn-primary">Save</button>
            <button onClick={() => {
                createAuthor({"firstName": author.firstName, "lastName": author.lastName,
                "username": author.username, "password": author.password, "dateOfBirth": author.dateOfBirth,
                "interest": {"category": author.interest}})
            }} className="btn btn-success">Create</button>
            <br/>
            <Link to={`/articles/author/${author.id}`}>Get Articles by this Author</Link>
        </div>
    )
}

export default AuthorFormEditor