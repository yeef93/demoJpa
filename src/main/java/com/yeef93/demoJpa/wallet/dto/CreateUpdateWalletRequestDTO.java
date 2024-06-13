package com.yeef93.demoJpa.wallet.dto;

import com.yeef93.demoJpa.users.entity.Users;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import lombok.Data;

@Data
public class CreateUpdateWalletRequestDTO {
    private String name;
    private Double amount;
    private Integer currency;
    private  long userId;

    public Wallet toEntity(){
        Wallet wallet = new Wallet();
        wallet.setName(this.name);
        wallet.setAmount(this.amount);
        wallet.setCurrency(this.currency);
        Users user = new Users();
        user.setId(this.userId);
        wallet.setUser(user);

        return wallet;
    }
}
