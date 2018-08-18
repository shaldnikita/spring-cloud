package ru.shaldnikita.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.shaldnikita.auth.domain.entity.User;
import ru.shaldnikita.auth.domain.repository.UserRepository;

import java.util.Optional;

/**
 * @author n.shaldenkov on 18.08.2018
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder encoder;

    private final UserRepository repository;

    @Override
    public void create(User user) {

        Optional<User> existing = repository.findById(user.getUsername());
        existing.ifPresent(it -> {
            throw new IllegalArgumentException("User "+ it.getUsername() + " already exists: ");
        });

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        repository.save(user);

        log.info("new user has been created: {}", user.getUsername());
    }
}