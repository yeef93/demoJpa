package com.yeef93.demoJpa.pocket.service.impl;

import com.yeef93.demoJpa.exceptions.DataNotFoundException;
import com.yeef93.demoJpa.pocket.dto.CreatePocketRequestDTO;
import com.yeef93.demoJpa.pocket.entity.Pocket;
import com.yeef93.demoJpa.pocket.repository.PocketRepository;
import com.yeef93.demoJpa.pocket.service.PocketService;
import com.yeef93.demoJpa.wallet.dto.CreateUpdateWalletRequestDTO;
import com.yeef93.demoJpa.wallet.entity.Wallet;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class PocketServiceImpl implements PocketService {
    private final PocketRepository pocketRepository;

    public PocketServiceImpl(PocketRepository pocketRepository){
        this.pocketRepository = pocketRepository;
    }

    @Override
    public List<Pocket> getPocket() {
        return  pocketRepository.findAll();
    }

    @Override
    public Optional<Pocket> getPocket(Long id) {
        Optional<Pocket> pocket = pocketRepository.findById(id);
        if (pocket.isEmpty()) {
            throw new DataNotFoundException("Pocket with ID " + id + " not found.");
        }
        return pocket;
    }

    @Override
    public Pocket createPocket(CreatePocketRequestDTO pocket) {
        return pocketRepository.save(pocket.toEntity());
    }

    @Override
    public Pocket updatePocket(Pocket pocket) {
        if (!pocketRepository.existsById(pocket.getId())) {
            throw new DataNotFoundException("Pocket with ID " + pocket.getId() + " does not exist.");
        }
        return pocketRepository.save(pocket);
    }
}
