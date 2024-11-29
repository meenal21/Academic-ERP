package com.meenal.academic_erp.controller;

import com.meenal.academic_erp.entity.Domain;
import com.meenal.academic_erp.repo.DomainRepo;
import com.meenal.academic_erp.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/domains")
public class DomainController {
    @Autowired
    private DomainRepo domainRepo;

    @GetMapping
    public List<Domain> getDomains() {
        return domainRepo.findAll();
    }
}
