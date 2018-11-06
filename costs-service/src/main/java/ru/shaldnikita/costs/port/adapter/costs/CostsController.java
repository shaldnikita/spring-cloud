package ru.shaldnikita.costs.port.adapter.costs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.shaldnikita.costs.application.model.CostModel;
import ru.shaldnikita.costs.application.model.CreateCostModel;
import ru.shaldnikita.costs.application.model.UpdateCostModel;
import ru.shaldnikita.costs.application.service.CostsService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@RestController
@RequestMapping("/costs")
@RequiredArgsConstructor
public class CostsController {

    private final CostsService costsService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<CostModel> getCosts() {
        return this.costsService.getCosts();
    }

    @GetMapping("/{costId}")
    public CostModel findById(@PathVariable String costId) {
        return this.costsService.findById(costId);
    }

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
        CostModel deletedCost = this.costsService.deleteCost(costId);
        return ResponseEntity.ok(deletedCost);
    }
}
