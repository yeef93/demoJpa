package com.yeef93.demoJpa.pocket.service;

import com.yeef93.demoJpa.pocket.dto.CreatePocketRequestDTO;
import com.yeef93.demoJpa.pocket.entity.Pocket;

import java.util.List;
import java.util.Optional;

public interface PocketService {
    public List<Pocket> getPocket();
    public Optional<Pocket> getPocket(Long id);
    public Pocket createPocket(CreatePocketRequestDTO pocket);
    public Pocket updatePocket(Pocket pocket);
}


