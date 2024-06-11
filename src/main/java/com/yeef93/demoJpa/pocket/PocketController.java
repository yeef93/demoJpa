package com.yeef93.demoJpa.pocket;

import com.yeef93.demoJpa.pocket.dto.CreatePocketRequestDTO;
import com.yeef93.demoJpa.pocket.entity.Pocket;
import com.yeef93.demoJpa.pocket.service.PocketService;
import com.yeef93.demoJpa.responses.Response;
import com.yeef93.demoJpa.wallet.dto.CreateUpdateWalletRequestDTO;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pocket")
@Validated
public class PocketController {
    private final PocketService pocketService;

    public PocketController(PocketService pocketService){
        this.pocketService = pocketService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Pocket>>> getPocket(){
        return Response.successfulResponse("All pocket fetched", pocketService.getPocket());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Pocket>>> getPocket(@PathVariable Long id){
        return Response.successfulResponse("Pocket detail found", pocketService.getPocket(id));
    }

    @PostMapping
    public ResponseEntity<Response<Pocket>> createPocket(@Valid @RequestBody CreatePocketRequestDTO pocket) {
        var createdPocket = pocketService.createPocket(pocket);
        return Response.successfulResponse(HttpStatus.CREATED.value(), "New Pocket created", pocketService.updatePocket(createdPocket));
    }

}
