package ru.shaldnikita.costs.application.model;

import lombok.*;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class CostModel {

    @Nonnull
    private String costId;

    @Nonnull
    private String name;

    @Nonnull
    private BigDecimal value;

    @Nonnull
    private List<CostTypeModel> types;

}
