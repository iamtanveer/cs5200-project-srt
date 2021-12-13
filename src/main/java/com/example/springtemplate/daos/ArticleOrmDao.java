package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArticleOrmDao {
    @Autowired
    ArticleRepository articleRepository;

    @PostMapping("/api/articles")
    public Article createArticle(@RequestBody Article article) {
        System.out.println(article);
        return articleRepository.save(article);
    }

    @GetMapping("/api/articles")
    public List<Article> findAllArticles() {
        return articleRepository.findAllArticles();
    }

    @GetMapping("/api/articles/{articleId}")
    public Article findArticleById(@PathVariable("articleId") Integer articleId) {
        return articleRepository.findArticleById(articleId);
    }

    @GetMapping("/api/articles/author/{authorId}")
    public List<Article> getArticlesByAuthor(@PathVariable("authorId") Integer authorId) {
        return articleRepository.getArticlesByAuthor(authorId);
    }

    @PutMapping("/api/articles/{articleId}")
    public Article updateArticle(@PathVariable("articleId") Integer id, @RequestBody Article articleUpdates) {
        Article article = articleRepository.findArticleById(id);
        article.setCreatedUser(articleUpdates.getCreatedUser());
        article.setCategory(articleUpdates.getCategory());
        article.setContent(articleUpdates.getContent());
        article.setTitle(articleUpdates.getTitle());
        return articleRepository.save(article);
    }

    @DeleteMapping("/api/articles/{articleId}")
    public void deleteArticle(@PathVariable("articleId") Integer id) {
        articleRepository.deleteById(id);
    }
}
