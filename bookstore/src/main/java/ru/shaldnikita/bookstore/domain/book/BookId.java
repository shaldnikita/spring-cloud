package ru.shaldnikita.bookstore.domain.book;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@Getter
@ToString(includeFieldNames = false)
public class BookId {

    private String id;

    public BookId(String id) {
        this.id = id;
    }

    BookId() {
        this.id = UUID.randomUUID().toString();
    }

}
