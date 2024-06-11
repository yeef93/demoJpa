package com.yeef93.demoJpa.pocket;

import com.yeef93.demoJpa.pocket.entity.Pocket;
import com.yeef93.demoJpa.pocket.service.PocketService;
import com.yeef93.demoJpa.responses.Response;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pocket")
public class PocketController {
    private final PocketService pocketService;

    public PocketController(PocketService pocketService){
        this.pocketService = pocketService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Pocket>>> getPocket(){
        return Response.successfulResponse("All pocket fetched", pocketService.getPocket());
    }
}
