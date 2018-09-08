package ru.shaldnikita.readers.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.readers.application.model.ReaderModel;
import ru.shaldnikita.readers.application.service.ReaderService;
import ru.shaldnikita.readers.domain.User;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ReadersController {

    private final ReaderService readerService;

    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping("/{name}")
    public ReaderModel getAccountByName(@PathVariable String name) {
        return this.readerService.findReaderByLogin(name);
    }

    @PostMapping("/")
    public ReaderModel createNewAccount(@Valid @RequestBody User user) {
        return readerService.registerNewReader(user);
    }

    @GetMapping("/current")
    public ReaderModel getCurrentAccount(Principal principal) {
        return readerService.findReaderByLogin(principal.getName());
    }
}
