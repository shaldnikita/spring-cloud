package ru.shaldnikita.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.shaldnikita.auth.domain.entity.User;
import ru.shaldnikita.auth.service.UserService;

import javax.validation.Valid;

/**
 * @author n.shaldenkov on 18.08.2018
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }
}