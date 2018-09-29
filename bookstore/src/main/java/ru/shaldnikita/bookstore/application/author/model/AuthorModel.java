package ru.shaldnikita.bookstore.application.author.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;
import java.time.LocalDate;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@AllArgsConstructor
@Data
public class AuthorModel {

    @Nonnull
    private String authorId;

    @Nonnull
    private String name;

    @Nonnull
    private LocalDate birthdayDate;

}
