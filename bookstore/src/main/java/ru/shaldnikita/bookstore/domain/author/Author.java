package ru.shaldnikita.bookstore.domain.author;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.shaldnikita.bookstore.domain.BaseEntity;

import javax.annotation.Nonnull;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity {

    @AttributeOverride(name = "id",
            column = @Column(name = "author_id", unique = true, nullable = false))
    @Embedded
    @Nonnull
    private AuthorId authorId;

    @Nonnull
    private String name;

    @Nonnull
    private LocalDate birthdayDate;

    public Author(@Nonnull String name, @Nonnull LocalDate birthdayDate) {
        this.authorId = new AuthorId();
        this.name = name;
        this.birthdayDate = birthdayDate;
    }
}