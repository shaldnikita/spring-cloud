package ru.shaldnikita.library.application.book;

import lombok.Data;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * @author n.shaldenkov on 18.09.2018
 */
@Data
public class BookModel {
    @Nonnull
    private String bookId;

    @Nonnull
    private String name;

    @Nonnull
    private BigDecimal price;
}
