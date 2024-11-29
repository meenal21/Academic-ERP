package com.meenal.academic_erp.controller;

import com.meenal.academic_erp.entity.Specialisation;
import com.meenal.academic_erp.repo.SpecialisationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/specialisations")
public class SpecialisationController {

    @Autowired
    private SpecialisationRepo specialisationRepo;

    @GetMapping
    public List<Specialisation> getAll() {
        return specialisationRepo.findAll();
    }
}
