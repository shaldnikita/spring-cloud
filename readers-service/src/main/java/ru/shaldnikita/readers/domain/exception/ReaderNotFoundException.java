package ru.shaldnikita.readers.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReaderNotFoundException extends IllegalStateException {
    public ReaderNotFoundException(String login) {
        super("Reader with login " + login + " not found.");
    }
}
