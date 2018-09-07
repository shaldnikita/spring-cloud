package ru.shaldnikita.readers.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@NoArgsConstructor
@Getter
public class Reader {

    @Id
    private Long id;

    private ReaderId readerId;

    private String login;

    private String password;

    private LocalDateTime registrationDate;

    public Reader(String login, String password) {
        this.login = login;
        this.password = password;
        this.readerId = new ReaderId();
        this.registrationDate = LocalDateTime.now();
    }
}
