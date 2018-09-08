package ru.shaldnikita.bookstore.domain.book;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.shaldnikita.bookstore.domain.BaseEntity;
import ru.shaldnikita.bookstore.domain.author.Author;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {

    @AttributeOverride(name = "id",
            column = @Column(name = "book_id", unique = true, nullable = false))
    @Embedded
    @Nonnull
    private BookId bookId;

    @Nonnull
    private String name;

    @Nonnull
    private BigDecimal price;

    @ManyToOne
    @Nonnull
    private Author author;

    public Book(@Nonnull String name, @Nonnull BigDecimal price, @Nonnull Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.bookId = new BookId();
    }
}
