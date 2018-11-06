package ru.shaldnikita.costs.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaldnikita.costs.domain.costs.Cost;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
public interface CostRepository extends JpaRepository<Cost, Long> {

    @Nonnull
    Optional<Cost> findByName(@Nonnull String name);

    @Nonnull
    Optional<Cost> findByCostIdName(@Nonnull UUID costId, @Nonnull String name);

    @Nonnull
    Optional<Cost> findByCostId(@Nonnull UUID costId);

    @Nonnull
    Optional<Cost> deleteByCostId(@Nonnull UUID costId);

}
