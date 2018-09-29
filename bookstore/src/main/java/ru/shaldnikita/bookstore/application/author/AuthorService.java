package ru.shaldnikita.bookstore.application.author;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shaldnikita.bookstore.application.author.model.AuthorModel;
import ru.shaldnikita.bookstore.application.author.model.CreateAuthorModel;
import ru.shaldnikita.bookstore.application.author.model.UpdateAuthorModel;
import ru.shaldnikita.bookstore.domain.author.Author;
import ru.shaldnikita.bookstore.domain.author.AuthorId;
import ru.shaldnikita.bookstore.domain.author.AuthorRepository;
import ru.shaldnikita.bookstore.domain.author.exceptions.AuthorNotFoundException;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import java.util.Optional;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Nonnull
    @Transactional
    public AuthorModel createAuthor(CreateAuthorModel authorToBeCreated) {
        Author author = new Author(authorToBeCreated.getName(),
                authorToBeCreated.getBirthdayDate());
        Author createdAuthor = this.repository.save(author);
        return new AuthorModel(createdAuthor.getAuthorId().getId(),
                createdAuthor.getName(), createdAuthor.getBirthdayDate());
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


    @Nonnull
    @Transactional(readOnly = true)
    public Page<AuthorModel> findAuthors(Pageable pageable) {
        return this.repository.findAll(pageable)
                .map(author -> new AuthorModel(
                        author.getAuthorId().getId(),
                        author.getName(),
                        author.getBirthdayDate())
                );
    }

    @Nonnull
    @Transactional
    public AuthorModel updateAuthor(@Valid UpdateAuthorModel authorToBeUpdated) {
        AuthorId authorId = new AuthorId(authorToBeUpdated.getAuthorId());
        return this.repository.findByAuthorId(authorId)
                .map(author -> {
                    author.setBirthdayDate(authorToBeUpdated.getBirthdayDate());
                    author.setName(authorToBeUpdated.getName());
                    return this.repository.save(author);
                })
                .map(updatedAuthor -> new AuthorModel(updatedAuthor.getAuthorId().getId(),
                        updatedAuthor.getName(), updatedAuthor.getBirthdayDate()))
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
    }
}
