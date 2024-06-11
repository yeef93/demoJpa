package com.yeef93.demoJpa.pocket.service.impl;

import com.yeef93.demoJpa.pocket.entity.Pocket;
import com.yeef93.demoJpa.pocket.repository.PocketRepository;
import com.yeef93.demoJpa.pocket.service.PocketService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
