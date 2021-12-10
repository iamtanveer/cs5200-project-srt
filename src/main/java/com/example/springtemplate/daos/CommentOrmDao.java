package com.example.springtemplate.daos;

import com.example.springtemplate.models.Comment;
import com.example.springtemplate.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentOrmDao {
    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody Comment comment ) {
        return commentRepository.save(comment);
    }

    @GetMapping("/api/comments")
    public List<Comment> findAllComments() {
        List<Comment> l = commentRepository.findAllComments();
        for (Comment c : l) {
            System.out.println(c.getComment() + "  " + c.getUser());
        }
        return commentRepository.findAllComments();
    }

    @GetMapping("/api/comments/{commentId}")
    public Comment findCommentById(@PathVariable("commentId") Integer commentId) {
        return commentRepository.findCommentById(commentId);
    }

    @PutMapping("/api/comments/{commentId}")
    public Comment updateCommentById(@PathVariable("commentId") Integer commentId, @RequestBody Comment updatedComment) {
        Comment comment = commentRepository.findCommentById(commentId);
        comment.setComment(updatedComment.getComment());
        comment.setCommentDate(updatedComment.getCommentDate());
        comment.setUser(updatedComment.getUser());
        comment.setArticle(updatedComment.getArticle());
        commentRepository.save(comment);

        return comment;
    }

    @DeleteMapping("/api/comments/{commentId}")
    public void deleteCommentById(@PathVariable("commentId") Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
