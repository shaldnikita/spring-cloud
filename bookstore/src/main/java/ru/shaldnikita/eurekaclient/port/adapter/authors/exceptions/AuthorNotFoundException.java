package ru.shaldnikita.eurekaclient.port.adapter.authors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.shaldnikita.eurekaclient.domain.author.AuthorId;

import javax.annotation.Nonnull;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthorNotFoundException extends IllegalArgumentException{

    public AuthorNotFoundException(@Nonnull AuthorId authorId) {
        super("Author with id "+authorId.getId()+" not found.");
    }
}

