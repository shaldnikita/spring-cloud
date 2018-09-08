package ru.shaldnikita.bookstore.domain.author;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
public interface AuthorRepository extends JpaRepository<Author,Long> {

    boolean deleteByAuthorId(@Nonnull AuthorId authorId);

    Optional<Author> findByAuthorId(@Nonnull AuthorId authorId);
}
