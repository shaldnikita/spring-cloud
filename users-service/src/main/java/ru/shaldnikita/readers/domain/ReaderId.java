package ru.shaldnikita.readers.domain;

import lombok.Getter;

import java.util.UUID;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@Getter
public class ReaderId {

    private String readerId;

    public ReaderId(String readerId) {
        this.readerId = readerId;
    }

    public ReaderId() {
        this.readerId = UUID.randomUUID().toString();
    }
}
