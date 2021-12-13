package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query(value = "select * from comments", nativeQuery = true)
    public List<Comment> findAllComments();
    @Query(value = "select * from comments where comments.id=:commentId", nativeQuery = true)
    public Comment findCommentById(@Param("commentId") Integer commentId);
    @Query(value = "select * from comments where comments.user_id=:userId", nativeQuery = true)
    public List<Comment> findCommentsByUser(@Param("userId") Integer userId);
    @Query(value = "select * from comments where comments.article_id=:articleId", nativeQuery = true)
    public List<Comment> findCommentsOfArticle(@Param("articleId") Integer articleId);
}
