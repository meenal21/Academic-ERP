package com.meenal.academic_erp.repo;

import com.meenal.academic_erp.entity.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialisationRepo extends JpaRepository<Specialisation, Long> {
    Optional<Specialisation> findById(Long specialisationId);
}