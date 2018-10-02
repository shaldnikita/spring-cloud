package ru.shaldnikita.readers.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@AllArgsConstructor
@Getter
public class ReaderModel {

    @Nonnull
    private String login;

    @Nonnull
    private String readerId;

    @Nonnull
    private LocalDateTime registrationDate;
}
