package ru.shaldnikita.eurekaclient.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
public interface BookRepository extends JpaRepository<Book,Long> {

    boolean deleteByBookId(@Nonnull BookId bookId);

    Optional<Book> findByBookId(BookId bookId);
}
