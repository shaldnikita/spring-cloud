package ru.shaldnikita.costs.domain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Nonnull;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@ResponseStatus(code = NOT_FOUND)
public class CostNotFoundException extends RuntimeException {
    public CostNotFoundException(@Nonnull String id) {
        super("Cost with id " + id + " not found.");
    }
}
