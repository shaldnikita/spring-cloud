package ru.shaldnikita.eurekaclient.service.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.shaldnikita.eurekaclient.domain.book.Book;
import ru.shaldnikita.eurekaclient.domain.book.BookId;
import ru.shaldnikita.eurekaclient.port.adapter.books.BookModel;

import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
public interface BookService {

    Book createBook(BookModel book);

    boolean deleteBook(BookId bookId);

    Optional<Book> findBookByBookId(BookId bookId);

    Optional<Book> findBooksByAuthor(BookId bookId);

    Page<BookModel> findBooks(Pageable pageable);

    Book updateBook(BookModel book);
}
