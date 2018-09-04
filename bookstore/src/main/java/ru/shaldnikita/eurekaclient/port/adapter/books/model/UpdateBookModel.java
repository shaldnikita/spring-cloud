package ru.shaldnikita.eurekaclient.port.adapter.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author n.shaldenkov on 04.09.2018
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateBookModel {

    @NotNull
    private String bookId;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String authorId;
}
