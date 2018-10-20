package ru.shaldnikita.costs.domain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Nonnull;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@ResponseStatus(code = BAD_REQUEST)
public class CostAlreadyExistsException extends RuntimeException {

    public CostAlreadyExistsException(@Nonnull String name) {
        super("Cost with name " + name + " already exists.");
    }
}
