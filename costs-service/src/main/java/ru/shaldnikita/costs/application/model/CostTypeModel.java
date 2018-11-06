package ru.shaldnikita.costs.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@AllArgsConstructor
@Data
public class CostTypeModel {

    @NotBlank
    public String name;
}
