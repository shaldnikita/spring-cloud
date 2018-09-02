package ru.shaldnikita.eurekaclient.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author n.shaldenkov on 02.09.2018
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
