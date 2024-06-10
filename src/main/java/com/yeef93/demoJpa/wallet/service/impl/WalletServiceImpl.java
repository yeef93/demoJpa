package com.yeef93.demoJpa.wallet.service.impl;

import com.yeef93.demoJpa.wallet.entity.Wallet;
import com.yeef93.demoJpa.wallet.service.WalletService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WalletServiceImpl implements WalletService {
    List<Wallet> wallet = new ArrayList<>();

    @Override
    public List<Wallet> getWallet(){
        return wallet;
    }

    @Override
    public Optional<Wallet> getWallet(Long id){
        return wallet.stream().filter(wallet -> wallet.getId() == id).findFirst();
    }

    @Override
    public Wallet addWallet(Wallet wallet){
        wallet.setId();
    }
}
