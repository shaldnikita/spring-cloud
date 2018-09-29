package ru.shaldnikita.bookstore.application.author.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@AllArgsConstructor
@Data
public class UpdateAuthorModel {

    @NotNull
    private String authorId;

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthdayDate;
}
