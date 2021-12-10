package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Like;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.ArticleRepository;
import com.example.springtemplate.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class LikeOrmDao {
    @Autowired
    LikeRepository likeRepository;

    @PostMapping("/api/likes")
    public Like createLike(@RequestBody Like like) {
        return likeRepository.save(like);
    }

    @GetMapping("/api/likes")
    public List<Like> findAllLikes() {
        return likeRepository.findAllLikes();
    }

    @GetMapping("/api/likes/article/{articleId}")
    public List<Like> findAllLikes(@PathVariable("articleId") Integer articleId) {
        return likeRepository.findAllLikesOfArticle(articleId);
    }

    @GetMapping("/api/likes/{likeId}")
    public Like findLikeByLikeId(@PathVariable("likeId") Integer likeId) {
        return likeRepository.findLikeById(likeId);
    }

    @PutMapping("/api/likes/{likeId}")
    public Like updateLike(@PathVariable("likeId") Integer likeId, @RequestBody Like updatedLike) {
        Like original = likeRepository.findLikeById(likeId);
        original.setUser(updatedLike.getUser());
        likeRepository.save(original);
        return original;
    }

    @DeleteMapping("/api/likes/{likeId}")
    public void deleteLike(@PathVariable("likeId") Integer likeId) {
        likeRepository.deleteById(likeId);
    }
}
