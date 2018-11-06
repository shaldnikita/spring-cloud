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

    @NotNull
    @Column(unique = true, updatable = false, nullable = false)
    private String costId;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    private BigDecimal value;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "cost_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cost_type_id", referencedColumnName = "id")
    )
    private List<CostType> types;

    public String costId() {
        return costId;
    }

    public String name() {
        return name;
    }

    public BigDecimal value() {
        return value;
    }

    public List<CostType> types() {
        return types;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setTypes(List<CostType> types) {
        this.types = types;
    }
}

