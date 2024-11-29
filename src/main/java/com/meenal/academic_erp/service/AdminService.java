package com.meenal.academic_erp.service;

import com.meenal.academic_erp.dto.AdminLoginRequest;
import com.meenal.academic_erp.dto.AdminRequest;
import com.meenal.academic_erp.entity.Admin;
import com.meenal.academic_erp.helper.JWTHelper;
import com.meenal.academic_erp.mapper.AdminMapper;
import com.meenal.academic_erp.repo.AdminRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminRepo adminRepo;
    private final AdminMapper adminMapper;
    private final JWTHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;

    public Admin retrieveAdminByEmail(String email) {
        return adminRepo.findByEmail(email);
    }

    public boolean tokenValidate(String auth_token){
        String token = auth_token.substring(7);
        return jwtHelper.validateToken(token);
    }

    public String loginAdmin(@Valid AdminLoginRequest req){
        Admin admin = retrieveAdminByEmail(req.email());

        if(passwordEncoder.matches(req.password(),admin.getPassword())){
            //return "logged in!";
            return jwtHelper.generateToken(req.email());
        }
        return "Bad credentials";
    }

    public String createAdmin(AdminRequest request){
        Admin admin = adminMapper.toAdmin(request);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepo.save(admin);
        return "created";
    }
}
