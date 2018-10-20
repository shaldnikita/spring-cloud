package ru.shaldnikita.costs.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@AllArgsConstructor
@Getter
public class CostModel {

    @Nonnull
    private UUID costId;

    @Nonnull
    private String name;

    @Nonnull
    private BigDecimal value;

    @Nonnull
    private List<CostTypeModel> types;

}
