package ru.shaldnikita.eurekaclient.domain.author;

import lombok.Getter;

import java.util.UUID;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@Getter
public class AuthorId {

    private String id;

    public AuthorId(String id) {
        this.id = id;
    }

    AuthorId() {
        this.id = UUID.randomUUID().toString();
    }
}
