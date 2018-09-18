package ru.shaldnikita.auth.service.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.shaldnikita.auth.domain.repository.UserRepository;

/**
 * @author n.shaldenkov on 18.08.2018
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
