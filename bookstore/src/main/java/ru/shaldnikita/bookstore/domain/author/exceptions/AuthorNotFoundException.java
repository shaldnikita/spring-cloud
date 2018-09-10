package ru.shaldnikita.bookstore.domain.author.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.shaldnikita.bookstore.domain.author.AuthorId;

import javax.annotation.Nonnull;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends IllegalArgumentException{

    public AuthorNotFoundException(@Nonnull AuthorId authorId) {
        super("Author with id "+authorId.getId()+" not found.");
    }
}
