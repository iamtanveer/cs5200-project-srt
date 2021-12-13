import articleService from "./../articles/article-service"

const { useState, useEffect } = React;
const {Link, useParams} = window.ReactRouterDOM;

const AuthorArticleEditor = () => {
    const {authorId} = useParams()
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findArticlesByAuthor()
    }, [])

    const findArticlesByAuthor = () =>
        articleService.getArticlesByAuthor(authorId)
            .then(articlesByAuthor => setArticles(articlesByAuthor))

    return(
        <div>
            <h2>Articles By Author</h2>
            <ul className="list-group">
                {
                    articles.map(article =>
                        <li key={article.id} className="list-group-item">
                            <Link to={`/articles/${article.id}`}>
                                {article.title}{" : "}
                                { article.content}
                            </Link>
                        </li>)
                }
            </ul>
            <br/>
            <button onClick={() => history.back()} className="btn btn-warning">Go back</button>
        </div>
    )
}

export default AuthorArticleEditor;