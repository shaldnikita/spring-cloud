package ru.shaldnikita.eurekaclient.port.adapter.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.eurekaclient.domain.book.Book;
import ru.shaldnikita.eurekaclient.port.adapter.books.BookModel;
import ru.shaldnikita.eurekaclient.service.book.BookService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController("/api/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public Page<BookModel> getBooks(@PageableDefault PageRequest pageable) {
        return this.bookService.findBooks(pageable);
    }

    @PostMapping
    public ResponseEntity createBook(@Valid @RequestBody BookModel book) throws URISyntaxException {
        Book createdBook = this.bookService.createBook(book);
        URI createdBookUri = new URI("api/books/" + createdBook.getBookId().getId());
        return ResponseEntity.created(createdBookUri).build();
    }

    @PutMapping
    public ResponseEntity updateBook(@Valid @RequestBody BookModel book) {
        this.bookService.updateBook(book);
        return ResponseEntity.ok().build();
    }
}