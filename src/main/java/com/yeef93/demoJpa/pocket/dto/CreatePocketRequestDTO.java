package com.yeef93.demoJpa.pocket.dto;

import com.yeef93.demoJpa.pocket.entity.Pocket;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePocketRequestDTO {
    @NotNull(message = "name is required" )
    @NotBlank(message = "name cant be blank")
    private String name;

    private String descr;

    @NotNull(message = "currency is required" )
    private Integer currency;

    @NotNull(message = "amount is required")
    @Min(value = 0, message = "amount must be non-negative")
    private Double amount;
    private long walletId;
    private String emoji;

    public Pocket toEntity(){
        Pocket pocket = new Pocket();

        pocket.setName(this.name);
        pocket.setDescr(this.descr);
        pocket.setCurrency(this.currency);
        pocket.setAmount(this.amount);
        pocket.setEmoji(this.emoji);

        Wallet wallet = new Wallet();
        wallet.setId(this.walletId);
        pocket.setWallet(wallet);

        return pocket;
    }
}
