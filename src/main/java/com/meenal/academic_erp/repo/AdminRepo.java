package com.meenal.academic_erp.repo;

import com.meenal.academic_erp.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    public Admin findByEmail(String email);
}