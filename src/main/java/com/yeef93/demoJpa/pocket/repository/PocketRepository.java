package com.yeef93.demoJpa.pocket.repository;

import com.yeef93.demoJpa.pocket.entity.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, Long> {
    Pocket findByName(String name);
}
