package ru.shaldnikita.eurekaclient.service.author;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shaldnikita.eurekaclient.domain.author.Author;
import ru.shaldnikita.eurekaclient.domain.author.AuthorId;
import ru.shaldnikita.eurekaclient.domain.author.AuthorRepository;
import ru.shaldnikita.eurekaclient.port.adapter.authors.AuthorModel;
import ru.shaldnikita.eurekaclient.port.adapter.authors.exceptions.AuthorNotFoundException;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Nonnull
    public Author createAuthor(AuthorModel authorToBeCreated) {
        Author author = new Author(authorToBeCreated.getName(),
                authorToBeCreated.getBirthdayDate());
        return this.repository.save(author);
    }

    @Transactional
    public boolean deleteAuthor(@Nonnull AuthorId authorId) {
        return this.repository.deleteByAuthorId(authorId);
    }

    @Nonnull
    @Transactional(readOnly = true)
    public Optional<Author> findAuthorByAuthorId(@Nonnull AuthorId authorId) {
        return this.repository.findByAuthorId(authorId);
    }


    @Transactional(readOnly = true)
    public Page<AuthorModel> findAuthor(Pageable pageable) {
        return this.repository.findAll(pageable)
                .map(author -> new AuthorModel(
                        author.getAuthorId().getId(),
                        author.getName(),
                        author.getBirthdayDate())
                );
    }

    @Transactional
    public Author updateAuthor(AuthorModel authorToBeUpdated) {
        AuthorId authorId = new AuthorId(authorToBeUpdated.getId());
        return this.repository.findByAuthorId(authorId)
                .map(author -> {
                    author.setBirthdayDate(authorToBeUpdated.getBirthdayDate());
                    author.setName(authorToBeUpdated.getName());
                    return this.repository.save(author);
                })
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
    }
}
