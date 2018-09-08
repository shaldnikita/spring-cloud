package ru.shaldnikita.bookstore.presentation.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.bookstore.application.book.BookService;
import ru.shaldnikita.bookstore.application.book.model.BookModel;
import ru.shaldnikita.bookstore.application.book.model.CreateBookModel;
import ru.shaldnikita.bookstore.application.book.model.UpdateBookModel;
import ru.shaldnikita.bookstore.domain.book.Book;
import ru.shaldnikita.bookstore.domain.book.BookId;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController("/api/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public Page<BookModel> getBooks(@PageableDefault PageRequest pageable) {
        return this.bookService.findBooks(pageable);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity getBook(@PathVariable String bookId) {
        Optional<Book> book = this.bookService.findBookByBookId(new BookId(bookId));
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity deleteBook(@PathVariable String bookId) {
        boolean deleted = this.bookService.deleteBook(new BookId(bookId));
        if(deleted)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity createBook(@Valid @RequestBody CreateBookModel book) throws URISyntaxException {
        Book createdBook = this.bookService.createBook(book);
        URI createdBookUri = new URI("api/books/" + createdBook.getBookId().getId());
        return ResponseEntity.created(createdBookUri).build();
    }

    @PutMapping
    public ResponseEntity updateBook(@Valid @RequestBody UpdateBookModel book) {
        this.bookService.updateBook(book);
        return ResponseEntity.ok().build();
    }
}