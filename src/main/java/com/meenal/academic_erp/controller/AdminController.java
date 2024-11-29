package com.meenal.academic_erp.controller;

import com.meenal.academic_erp.dto.AdminLoginRequest;
import com.meenal.academic_erp.dto.AdminRequest;
import com.meenal.academic_erp.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ap1/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody @Valid AdminLoginRequest request, @RequestHeader("Authorization") String token){
        if(adminService.tokenValidate(token)){
            return ResponseEntity.ok(adminService.loginAdmin(request));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/createuser")
    public ResponseEntity<String> createAdmin(@RequestBody @Valid AdminRequest request){
        return ResponseEntity.ok(adminService.createAdmin(request));
    }
}

