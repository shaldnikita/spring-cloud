package ru.shaldnikita.eurekaclient.port.adapter.books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.shaldnikita.eurekaclient.domain.book.BookId;

import javax.annotation.Nonnull;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends IllegalArgumentException{

    public BookNotFoundException(@Nonnull BookId bookId) {
        super("Book with id "+bookId.getId()+" not found.");
    }
}

