package com.meenal.academic_erp.repo;

import com.meenal.academic_erp.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Students, Long> {
    public Students findStudentsByRollNumber(String rollNumber);
}
