package ru.shaldnikita.costs.domain.costs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ru.shaldnikita.costs.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@Entity
@Table(name = "cost_types")
@SQLDelete(sql = "UPDATE cost_type SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CostType extends BaseEntity {

    @NotBlank
    private String name;
}
