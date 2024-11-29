package com.meenal.academic_erp.repo;


import com.meenal.academic_erp.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomainRepo extends JpaRepository<Domain, Long> {
     Optional<Domain> findById(Long domain_id);
}