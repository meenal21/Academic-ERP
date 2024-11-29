package com.meenal.academic_erp.repo;

import com.meenal.academic_erp.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepo extends JpaRepository<Students, Long> {
    public Students findStudentsByEmail(String email);

    @Query("select sa from Students sa")
    List<Students> findAll();
}
