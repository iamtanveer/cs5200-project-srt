package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    @Query(value = "SELECT * FROM likes, articles, users where likes.user_id = users.id and likes.article_id = articles.id",
            nativeQuery = true)
    public List<Like> findAllLikes();

    @Query(value = "SELECT * FROM likes, articles, users where likes.user_id=users.id and likes.article_id=articles.id and likes.article_id=:articleId",
            nativeQuery = true)
    public List<Like> findAllLikesOfArticle(@Param("articleId") Integer articleId);
}
