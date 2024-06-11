package com.yeef93.demoJpa.wallet.repository;

import com.yeef93.demoJpa.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByName(String name);

    @Modifying
    @Transactional
    @Query("update Wallet a set a.deleteAt = CURRENT_TIMESTAMP where a.id = :id")
    void softDeleteById(Long id);
}
