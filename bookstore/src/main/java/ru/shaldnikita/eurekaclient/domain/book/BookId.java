package ru.shaldnikita.eurekaclient.domain.book;

import lombok.Getter;

import java.util.UUID;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@Getter
public class BookId {

    private String id;

    BookId() {
        this.id = UUID.randomUUID().toString();
    }

}
