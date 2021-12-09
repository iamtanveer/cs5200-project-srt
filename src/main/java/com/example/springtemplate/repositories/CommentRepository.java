package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query(value = "select * from comments, users, articles where comments.user_id = users.id and " +
            "users.id = articles.created_user", nativeQuery = true)
    public List<Comment> findAllComments();
    @Query(value = "select * from comments, users, articles where comments.user_id = users.id and " +
            "users.id = articles.created_user and comments.id=:commentId", nativeQuery = true)
    public Comment findCommentById(@Param("commentId") Integer commentId);
}
