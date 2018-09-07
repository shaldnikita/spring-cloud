package ru.shaldnikita.readers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @NotNull
    @Length(min = 6, max = 15)
    private String username;

    @NotNull
    @Length(min = 6, max = 15)
    private String password;

}
