package ru.shaldnikita.eurekaclient.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shaldnikita.eurekaclient.domain.author.Author;
import ru.shaldnikita.eurekaclient.domain.author.AuthorId;
import ru.shaldnikita.eurekaclient.domain.book.Book;
import ru.shaldnikita.eurekaclient.domain.book.BookId;
import ru.shaldnikita.eurekaclient.domain.book.BookRepository;
import ru.shaldnikita.eurekaclient.port.adapter.authors.exceptions.AuthorNotFoundException;
import ru.shaldnikita.eurekaclient.port.adapter.books.exceptions.BookNotFoundException;
import ru.shaldnikita.eurekaclient.port.adapter.books.model.BookModel;
import ru.shaldnikita.eurekaclient.port.adapter.books.model.CreateBookModel;
import ru.shaldnikita.eurekaclient.port.adapter.books.model.UpdateBookModel;
import ru.shaldnikita.eurekaclient.service.author.AuthorService;

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
    public Optional<Book> findBookByBookId(BookId bookId) {
        return this.bookRepository.findByBookId(bookId);
    }

    @Transactional(readOnly = true)
    public Page<BookModel> findBooks(Pageable pageable) {
        return this.bookRepository.findAll(pageable)
                .map(book -> new BookModel(
                        book.getName(),
                        book.getPrice(),
                        book.getAuthor().getAuthorId().getId()
                ));
    }

    @Transactional
    public Book updateBook(UpdateBookModel updateBook){
        return this.bookRepository.findByBookId(new BookId(updateBook.getBookId()))
                .map(book -> updateBook(updateBook,book))
                .map(this.bookRepository::save)
                .orElseThrow(() -> new BookNotFoundException(new BookId(updateBook.getBookId())));
    }

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
