package ru.shaldnikita.bookstore.presentation.authors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.bookstore.application.author.AuthorModel;
import ru.shaldnikita.bookstore.application.author.AuthorService;
import ru.shaldnikita.bookstore.domain.author.Author;
import ru.shaldnikita.bookstore.domain.author.AuthorId;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorsController {

    private final AuthorService authorService;

    @GetMapping
    public Page<AuthorModel> getAuthors(@PageableDefault PageRequest pageable){
        return  this.authorService.findAuthors(pageable);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity getAuthor(@PathVariable String authorId){
        Optional<Author> author = this.authorService.findAuthorByAuthorId(new AuthorId(authorId));
        return author.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createAuthor(@Valid @RequestBody AuthorModel author) throws URISyntaxException {
        Author createdAuthor = this.authorService.createAuthor(author);
        URI createdAuthorUri = new URI("/api/authors/" + createdAuthor.getAuthorId().getId());
        return ResponseEntity.created(createdAuthorUri).build();
    }

    @PutMapping
    public ResponseEntity updateAuthor( @Valid @RequestBody AuthorModel author){
        this.authorService.updateAuthor(author);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity deleteAuthor(@PathVariable String authorId){
        boolean deleted = this.authorService.deleteAuthor(new AuthorId(authorId));
        if(deleted)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

}
