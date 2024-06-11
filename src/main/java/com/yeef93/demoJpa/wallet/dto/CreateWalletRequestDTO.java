package com.yeef93.demoJpa.wallet.dto;

import com.yeef93.demoJpa.user.entity.User;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class CreateWalletRequestDTO {
    private String name;
    private Double amount;
    private String currency;
    private  long userId;

    public Wallet toEntity(){
        Wallet wallet = new Wallet();
        wallet.setName(this.name);
        wallet.setAmount(this.amount);
        wallet.setCurrency(this.currency);
        User user = new User();
        user.setId(this.userId);
        wallet.setUser(user);

        return wallet;
    }
}
