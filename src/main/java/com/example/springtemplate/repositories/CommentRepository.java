package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
