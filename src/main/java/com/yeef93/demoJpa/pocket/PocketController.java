package com.yeef93.demoJpa.pocket;

import com.yeef93.demoJpa.pocket.entity.Pocket;
import com.yeef93.demoJpa.pocket.service.PocketService;
import com.yeef93.demoJpa.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Pocket>>> getPocket(@PathVariable Long id){
        return Response.successfulResponse("Pocket detail found", pocketService.getPocket(id));
    }
}
