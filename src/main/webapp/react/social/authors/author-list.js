import authorService from "./author-service"
const { useState, useEffect } = React;

const {Link, useHistory} = window.ReactRouterDOM;

const AuthorList = () => {
    const [authors, setAuthors] = useState([])
    useEffect(() => {
        findAllAuthors()
    }, [])
    const findAllAuthors = () =>
        authorService.findAllAuthors()
            .then(authors => setAuthors(authors))
    const history = useHistory()

    return(
        <div>
            <h2>Authors</h2>
            <button onClick={() => history.push("/authors/new")}>Add Author</button>
            <ul className="list-group">
                {
                    authors.map(author =>
                        <li key={author.id} className="list-group-item">
                            <Link to={`/authors/${author.id}`}>
                                {author.firstName},
                                {author.lastName},
                                {author.username}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default AuthorList;