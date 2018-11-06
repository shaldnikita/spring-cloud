package ru.shaldnikita.costs.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaldnikita.costs.domain.costs.Cost;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
public interface CostRepository extends JpaRepository<Cost, Long> {

    @Nonnull
    Optional<Cost> findByName(@Nonnull String name);

    @Nonnull
    Optional<Cost> findByCostIdAndName(@Nonnull String costId, @Nonnull String name);

    @Nonnull
    Optional<Cost> findByCostId(@Nonnull String costId);

    @Nonnull
    Optional<Cost> deleteByCostId(@Nonnull String costId);

}
