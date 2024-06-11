package com.yeef93.demoJpa.wallet.service.impl;


import com.yeef93.demoJpa.exceptions.DataNotFoundException;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import com.yeef93.demoJpa.wallet.repository.WalletRepository;
import com.yeef93.demoJpa.wallet.service.WalletService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> getWallet() {
        return  walletRepository.findAll();
    }

    @Override
    public Optional<Wallet> getWallet(Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (wallet.isEmpty()) {
            throw new DataNotFoundException("Wallet with ID " + id + " not found.");
        }
        return wallet;
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        if (walletRepository.existsById(wallet.getId())) {
            throw new DataNotFoundException("Wallet with ID " + wallet.getId() + " already exists.");
        }
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(Wallet wallet) {
        if (!walletRepository.existsById(wallet.getId())) {
            throw new DataNotFoundException("Wallet with ID " + wallet.getId() + " does not exist.");
        }
        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public void deleteWallet(Long id){
        if(!walletRepository.existsById(id)){
            throw new DataNotFoundException("Wallet with ID " +id+" does not exist.");
        }
        walletRepository.softDeleteById(id);
    }

}
