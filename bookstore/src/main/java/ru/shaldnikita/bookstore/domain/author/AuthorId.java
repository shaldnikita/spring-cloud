package ru.shaldnikita.bookstore.domain.author;

import lombok.Getter;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@Getter
public class AuthorId {

    @Nonnull
    private final String id;

    public AuthorId(String id) {
        this.id = id;
    }

    AuthorId() {
        this.id = UUID.randomUUID().toString();
    }
}
