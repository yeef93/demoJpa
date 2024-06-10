package com.yeef93.demoJpa.wallet.repository;

import com.yeef93.demoJpa.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByName(String name);
}
