package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
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

    @PutMapping("/api/articles/{articleId}")
    public Article updateArticle(@PathVariable("articleId") Integer id, @RequestBody Article articleUpdates) {
        Article article = articleRepository.findArticleById(id);
        article.setAuthor(articleUpdates.getAuthor());
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
//
//    @GetMapping("/api/follows/following/{userId}")
//    public List<Follow> findAllFollowsUser(
//            @PathVariable("userId") Integer userId
//    ) {
//        return followRepository.findAllRelationsByFollowsId(userId);
//    }
//
//    @GetMapping("/api/follows/followers/{userId}")
//    public List<Follow> findAllFollowersUser(
//            @PathVariable("userId") Integer userId
//    ) {
//        return followRepository.findAllRelationsByFollowersId(userId);
//    }
//
//    @DeleteMapping("/api/follows/{userId1}/{userId2}")
//    public void deleteUser(
//            @PathVariable("userId") Integer userId1, @PathVariable("userId") Integer userId2) {
//        followRepository.deleteRelation(userId1, userId2);
//    }
