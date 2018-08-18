package ru.shaldnikita.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaldnikita.auth.domain.entity.User;

/**
 * @author n.shaldenkov on 18.08.2018
 */
public interface UserRepository extends JpaRepository<User, String> {
}
