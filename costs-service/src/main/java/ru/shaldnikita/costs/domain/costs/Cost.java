package ru.shaldnikita.costs.domain.costs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ru.shaldnikita.costs.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE costs SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Table(name = "costs")
public class Cost extends BaseEntity {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal value;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "cost_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cost_type_id", referencedColumnName = "id")
    )
    private List<CostType> types;
}

