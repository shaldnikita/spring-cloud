package ru.shaldnikita.costs.presentation.cost;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.costs.application.model.CostModel;
import ru.shaldnikita.costs.application.model.CreateCostModel;
import ru.shaldnikita.costs.application.model.UpdateCostModel;
import ru.shaldnikita.costs.application.service.CostsService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@RestController
@RequestMapping("/costs")
@RequiredArgsConstructor
public class CostsController {

    private final CostsService costsService;

    @PostMapping
    public ResponseEntity<CostModel> createCost(@Valid CreateCostModel cost) throws URISyntaxException {
        CostModel createdCost = this.costsService.createCost(cost);
        return ResponseEntity.created(new URI("/costs/" + createdCost.getCostId())).body(createdCost);
    }

    @PutMapping
    public ResponseEntity<CostModel> updateCost(@Valid UpdateCostModel cost) {
        CostModel updatedCost = this.costsService.updateCost(cost);
        return ResponseEntity.ok(updatedCost);
    }

    @DeleteMapping(value = "/{costId}")
    public ResponseEntity<CostModel> deleteCost(@PathVariable String costId) {
        CostModel deletedCost = this.costsService.deleteCost(UUID.fromString(costId));
        return ResponseEntity.ok(deletedCost);
    }
}
