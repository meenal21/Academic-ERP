package com.meenal.academic_erp.controller;

import com.meenal.academic_erp.entity.Placement;
import com.meenal.academic_erp.repo.PlacementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/placements")
public class PlacementController {
    @Autowired
    private PlacementRepo placementRepo;

    @GetMapping
    public List<Placement> getAll() {
        return placementRepo.findAll();
    }
}
