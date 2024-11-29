package com.meenal.academic_erp.repo;

import com.meenal.academic_erp.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlacementRepo extends JpaRepository<Placement, Long> {
    Optional<Placement> findById(Integer id);
}