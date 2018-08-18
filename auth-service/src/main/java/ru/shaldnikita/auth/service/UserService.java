package ru.shaldnikita.auth.service;

import ru.shaldnikita.auth.domain.entity.User;

/**
 * @author n.shaldenkov on 18.08.2018
 */
public interface UserService {
    void create(User user);
}
