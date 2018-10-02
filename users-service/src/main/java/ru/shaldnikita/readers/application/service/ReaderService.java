package ru.shaldnikita.readers.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shaldnikita.readers.application.client.AuthServiceFeignClient;
import ru.shaldnikita.readers.application.model.ReaderModel;
import ru.shaldnikita.readers.domain.Reader;
import ru.shaldnikita.readers.domain.User;
import ru.shaldnikita.readers.domain.exception.ReaderNotFoundException;
import ru.shaldnikita.readers.domain.repository.ReaderRepository;

import javax.annotation.Nonnull;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@Service
@RequiredArgsConstructor
public class ReaderService {

    private final BCryptPasswordEncoder passwordEncoder;

    private final ReaderRepository readerRepository;

    private final AuthServiceFeignClient authServiceFeignClient;

    @Transactional
    public ReaderModel registerNewReader(@Nonnull User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Reader reader = new Reader(user.getUsername(), user.getPassword());

        this.authServiceFeignClient.createUser(user);
        this.readerRepository.save(reader);

        return new ReaderModel(reader.getLogin(), reader.getReaderId().getReaderId(), reader.getRegistrationDate());
    }

    @Transactional(readOnly = true)
    public ReaderModel findReaderByLogin(String login) {
        return this.readerRepository.findByLogin(login)
                .orElseThrow(() -> new ReaderNotFoundException(login));
    }
}
