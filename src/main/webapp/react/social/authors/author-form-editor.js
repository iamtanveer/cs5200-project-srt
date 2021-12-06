import authorService from "./author-service"
const {useParams, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const AuthorFormEditor = () => {
    const {id} = useParams()
    const [author, setAuthor] = useState({})
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

            <label>Interest</label>
            <input onChange={(e) =>
                setAuthor(author => ({
                    ...author, interest: e.target.value
                }))} className="form-control" value={author.interest}/><br/>

            <button onClick={() => history.back()} className="btn btn-warning">Cancel</button>
            <button onClick={() => deleteAuthor(author.id)} className="btn btn-danger">Delete</button>
            <button onClick={() => updateAuthor(author.id, author)} className="btn btn-primary">Save</button>
            <button onClick={() => createAuthor(author)} className="btn btn-success">Create</button>
        </div>
    )
}

export default AuthorFormEditor