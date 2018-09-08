package ru.shaldnikita.bookstore.application.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shaldnikita.bookstore.application.author.AuthorService;
import ru.shaldnikita.bookstore.application.book.model.BookModel;
import ru.shaldnikita.bookstore.application.book.model.CreateBookModel;
import ru.shaldnikita.bookstore.application.book.model.UpdateBookModel;
import ru.shaldnikita.bookstore.domain.author.Author;
import ru.shaldnikita.bookstore.domain.author.AuthorId;
import ru.shaldnikita.bookstore.domain.author.exceptions.AuthorNotFoundException;
import ru.shaldnikita.bookstore.domain.book.Book;
import ru.shaldnikita.bookstore.domain.book.BookId;
import ru.shaldnikita.bookstore.domain.book.BookRepository;
import ru.shaldnikita.bookstore.domain.book.exceptions.BookNotFoundException;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    @Transactional
    @Nonnull
    public Book createBook(CreateBookModel book) {
        return this.authorService.findAuthorByAuthorId(new AuthorId(book.getAuthorId()))
                .map(author -> new Book(book.getName(), book.getPrice(), author))
                .map(this.bookRepository::save)
                .orElseThrow(() -> new AuthorNotFoundException(new AuthorId(book.getAuthorId())));
    }

    @Transactional
    public boolean deleteBook(BookId bookId) {
        return this.bookRepository.deleteByBookId(bookId);
    }

    @Transactional(readOnly = true)
    @Nonnull
    public Optional<Book> findBookByBookId(BookId bookId) {
        return this.bookRepository.findByBookId(bookId);
    }

    @Transactional(readOnly = true)
    @Nonnull
    public Page<BookModel> findBooks(Pageable pageable) {
        return this.bookRepository.findAll(pageable)
                .map(book -> new BookModel(
                        book.getName(),
                        book.getPrice(),
                        book.getAuthor().getAuthorId().getId()
                ));
    }

    @Transactional
    @Nonnull
    public Book updateBook(UpdateBookModel updateBook){
        return this.bookRepository.findByBookId(new BookId(updateBook.getBookId()))
                .map(book -> updateBook(updateBook,book))
                .map(this.bookRepository::save)
                .orElseThrow(() -> new BookNotFoundException(new BookId(updateBook.getBookId())));
    }

    @Nonnull
    private Book updateBook(UpdateBookModel updateBook, Book book){
        AuthorId authorId = new AuthorId(updateBook.getAuthorId());
        Optional<Author> author = this.authorService.findAuthorByAuthorId(authorId);
        if (!author.isPresent())
            throw new AuthorNotFoundException(authorId);

        book.setAuthor(author.get());
        book.setName(updateBook.getName());
        book.setPrice(updateBook.getPrice());
        return book;
    }
}
