package com.yeef93.demoJpa.wallet.dto;

import com.yeef93.demoJpa.users.entity.Users;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUpdateWalletRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Amount is required")
    private Double amount;
    @NotNull(message = "Currency is required")
    private Integer currency;
    @NotNull(message = "User ID is required")
    private  Long userId;

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
