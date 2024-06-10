package com.yeef93.demoJpa.wallet;

import com.yeef93.demoJpa.responses.Response;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import com.yeef93.demoJpa.wallet.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}
