package ru.shaldnikita.eurekaclient.port.adapter.authors;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@AllArgsConstructor
@Data
public class AuthorModel {

    @Nullable
    private String id;

    @Nonnull
    private String name;

    @Nonnull
    private LocalDate birthdayDate;

}
