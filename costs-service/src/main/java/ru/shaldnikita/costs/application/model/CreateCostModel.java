package ru.shaldnikita.costs.application.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@Data
public class CreateCostModel {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal value;

    @NotNull
    private List<CostTypeModel> types;
}
