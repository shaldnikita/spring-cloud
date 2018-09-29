package ru.shaldnikita.bookstore.application.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author n.shaldenkov on 04.09.2018
 */
@AllArgsConstructor
@Data
public class UpdateBookModel {

    @NotBlank
    private String bookId;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String authorId;
}
