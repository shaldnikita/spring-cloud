package ru.shaldnikita.library.application.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * @author n.shaldenkov on 18.09.2018
 */
@AllArgsConstructor
@Data
@ToString(includeFieldNames = false)
public class BookModel {

    @Nonnull
    private String bookId;

    @Nonnull
    private String name;

    @Nonnull
    private BigDecimal price;

    @Nonnull
    private String authorId;

}
