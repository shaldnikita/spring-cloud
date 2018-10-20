package ru.shaldnikita.costs.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shaldnikita.costs.application.model.CostModel;
import ru.shaldnikita.costs.application.model.CostTypeModel;
import ru.shaldnikita.costs.application.model.CreateCostModel;
import ru.shaldnikita.costs.application.model.UpdateCostModel;
import ru.shaldnikita.costs.domain.costs.Cost;
import ru.shaldnikita.costs.domain.costs.CostType;
import ru.shaldnikita.costs.domain.exceptions.CostAlreadyExistsException;
import ru.shaldnikita.costs.domain.exceptions.CostNotFoundException;
import ru.shaldnikita.costs.domain.repository.CostRepository;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@RequiredArgsConstructor
@Service
public class CostsService {

    private final CostRepository costRepository;

    @Nonnull
    private static Cost mapToDomainObject(@Nonnull CreateCostModel costToBeCreated) {
        return new Cost(
                UUID.randomUUID(),
                costToBeCreated.getName(),
                costToBeCreated.getValue(),
                costToBeCreated.getTypes().stream()
                        .map(type -> new CostType(type.getName()))
                        .collect(toList())
        );
    }

    @Nonnull
    private static CostModel mapToModel(@Nonnull Cost cost) {
        return new CostModel(
                cost.costId(),
                cost.name(),
                cost.value(),
                cost.types().stream()
                        .map(type -> new CostTypeModel(type.name()))
                        .collect(toList()));

    }

    @Nonnull
    public CostModel createCost(@Nonnull CreateCostModel costToBeCreated) {
        Optional<Cost> cost = this.costRepository.findByName(costToBeCreated.getName());
        if (cost.isPresent()) {
            throw new CostAlreadyExistsException(costToBeCreated.getName());
        }
        Cost createdCost = this.costRepository.save(mapToDomainObject(costToBeCreated));
        return mapToModel(createdCost);
    }

    @Nonnull
    public CostModel updateCost(@Nonnull UpdateCostModel costToBeUpdated) {
        Cost cost = this.costRepository.findByCostIdName(costToBeUpdated.getCostId(), costToBeUpdated.getName())
                .map(foundCost -> {
                    foundCost.setName(costToBeUpdated.getName());
                    foundCost.setValue(costToBeUpdated.getValue());
                    foundCost.setTypes(costToBeUpdated.getTypes().stream()
                            .map(type -> new CostType(type.getName()))
                            .collect(toList()));
                    return this.costRepository.save(foundCost);
                })
                .orElseThrow(() -> new CostNotFoundException(costToBeUpdated.getCostId().toString()));

        return new CostModel(cost.costId(), cost.name(), cost.value(), costToBeUpdated.getTypes());
    }

    @Nonnull
    public CostModel deleteCost(@Nonnull UUID costId) {
        Optional<Cost> cost = this.costRepository.deleteByCostId(costId);
        if (!cost.isPresent())
            throw new CostNotFoundException(costId.toString());
        else
            return mapToModel(cost.get());
    }

}
