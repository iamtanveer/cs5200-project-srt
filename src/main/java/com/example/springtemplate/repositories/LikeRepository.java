package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    @Query(value = "SELECT * FROM likes",
            nativeQuery = true)
    public List<Like> findAllLikes();

    @Query(value = "SELECT * FROM likes where likes.article_id=:articleId",
            nativeQuery = true)
    public List<Like> findAllLikesOfArticle(@Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM likes where likes.id=:likeId", nativeQuery = true)
    public Like findLikeById(@Param("likeId") Integer likeId);

    @Query(value = "SELECT * FROM likes where likes.user_id=:userId", nativeQuery = true)
    public List<Like> findLikesByUser(@Param("userId") Integer userId);
}
