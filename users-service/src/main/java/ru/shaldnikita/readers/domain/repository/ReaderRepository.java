package ru.shaldnikita.readers.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.shaldnikita.readers.application.model.ReaderModel;
import ru.shaldnikita.readers.domain.Reader;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@Repository
public interface ReaderRepository extends MongoRepository<Reader,String> {

    @Nonnull
    Optional<ReaderModel> findByLogin(@Nonnull String login);
}
