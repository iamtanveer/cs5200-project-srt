import articleService from "./article-service"
const { useState, useEffect } = React;

const {Link, useHistory} = window.ReactRouterDOM;

const ArticleList = () => {
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findAllArticles()
    }, [])
    const findAllArticles = () =>
        articleService.findAllArticles()
            .then(findAllArticles => setArticles(findAllArticles))
    const history = useHistory()

    return(
        <div>
            <h2>Articles</h2>
            <button onClick={() => history.push("/articles/new")}>Add Article</button>
            <ul className="list-group">
                {
                    articles.map(article =>
                        <li key={article.id} className="list-group-item">
                            <Link to={`/articles/${article.id}`}>
                                {article.title}{" : "}
                                { article.content}
                                {/*{article.createdUser.firstName}*/}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticleList;