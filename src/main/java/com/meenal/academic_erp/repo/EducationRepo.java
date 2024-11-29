package com.meenal.academic_erp.repo;

import com.meenal.academic_erp.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education, Integer> {
}
