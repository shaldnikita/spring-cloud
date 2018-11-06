package ru.shaldnikita.costs.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@AllArgsConstructor
@Getter
public class UpdateCostModel {

    @NotNull
    private String costId;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal value;

    @NotNull
    private List<CostTypeModel> types;
}
