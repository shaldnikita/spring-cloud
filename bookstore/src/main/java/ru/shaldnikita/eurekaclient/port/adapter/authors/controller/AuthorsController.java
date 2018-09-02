package ru.shaldnikita.eurekaclient.port.adapter.authors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shaldnikita.eurekaclient.domain.author.Author;
import ru.shaldnikita.eurekaclient.port.adapter.authors.AuthorModel;
import ru.shaldnikita.eurekaclient.service.author.AuthorService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@RestController("/api/authors")
@RequiredArgsConstructor
public class AuthorsController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity createAuthor(@Valid @RequestBody AuthorModel author) throws URISyntaxException {
        Author createdAuthor = this.authorService.createAuthor(author);
        URI createdAuthorUri = new URI("/api/authors/" + createdAuthor.getAuthorId().getId());
        return ResponseEntity.created(createdAuthorUri).build();
    }

}
