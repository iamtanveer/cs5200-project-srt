package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Like;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.ArticleRepository;
import com.example.springtemplate.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/likes/{articleId}")
    public List<Like> findAllLikes(@PathVariable("articleId") Integer articleId) {
        return likeRepository.findAllLikesOfArticle(articleId);
    }

    @DeleteMapping("/api/likes/{likeId}")
    public void deleteLike(@PathVariable("likeId") Integer likeId) {
        likeRepository.deleteById(likeId);
    }
}
