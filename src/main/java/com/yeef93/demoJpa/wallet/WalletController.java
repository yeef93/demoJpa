package com.yeef93.demoJpa.wallet;

import com.yeef93.demoJpa.responses.Response;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import com.yeef93.demoJpa.wallet.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Wallet>>> getWallet(){
        return Response.successfulResponse("All wallet fetched", walletService.getWallet());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Wallet>>> getWallet(@PathVariable Long id){
        return Response.successfulResponse("Wallet detail found", walletService.getWallet(id));
    }
    @PostMapping
    public ResponseEntity<Response<Wallet>> createWallet(@Validated @RequestBody Wallet wallet) {
        var createdWallet = walletService.createWallet(wallet);
        return Response.successfulResponse(HttpStatus.CREATED.value(), "New Wallet created", walletService.updateWallet(createdWallet));
    }
}
