package com.example.springtemplate.daos;

import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AuthorOrmDao {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/api/authors")
    public List<Author> findAllAuthors() {
        return authorRepository.findAllAuthors();
    }

    @GetMapping("/api/authors/{authorId}")
    public User findAuthorById(
            @PathVariable("authorId") Integer id) {
        return authorRepository.findAuthorById(id);
    }

    @PostMapping("/api/authors")
    public Author createAuthor(@RequestBody Author user) {
        System.out.println(user.getFirstName() + "  " + user.getLastName());
        return authorRepository.save(user);
    }

    @PutMapping("/api/authors/{authorId}")
    public User updateAuthor(
            @PathVariable("authorId") Integer id,
            @RequestBody Author authorUpdates) {
        Author author = authorRepository.findAuthorById(id);
        author.setInterest(authorUpdates.getInterest());
        return authorRepository.save(author);
    }

    @DeleteMapping("/api/authors/{authorId}")
    public void deleteUser(
            @PathVariable("authorId") Integer id) {
        authorRepository.deleteById(id);
    }
}