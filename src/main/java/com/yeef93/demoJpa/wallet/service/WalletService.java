package com.yeef93.demoJpa.wallet.service;

import com.yeef93.demoJpa.wallet.dto.CreateWalletRequestDTO;
import com.yeef93.demoJpa.wallet.entity.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletService {
    public List<Wallet> getWallet();
    public Optional<Wallet> getWallet(Long id);
    public Wallet createWallet(CreateWalletRequestDTO wallet);
    public Wallet updateWallet(Wallet wallet);
    public  void deleteWallet(Long id);
}
