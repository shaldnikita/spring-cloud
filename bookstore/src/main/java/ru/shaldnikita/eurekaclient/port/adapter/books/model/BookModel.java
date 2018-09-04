package ru.shaldnikita.eurekaclient.port.adapter.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * @author n.shaldenkov on 04.09.2018
 */
@AllArgsConstructor
@Data
public class BookModel {

    @Nonnull
    private String name;

    @Nonnull
    private BigDecimal price;

    @Nonnull
    private String authorId;

}
