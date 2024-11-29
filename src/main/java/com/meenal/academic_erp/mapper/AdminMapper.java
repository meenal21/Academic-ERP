package com.meenal.academic_erp.mapper;

import com.meenal.academic_erp.dto.AdminRequest;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.entity.Admin;
import com.meenal.academic_erp.entity.Students;
import org.springframework.stereotype.Service;

@Service
public class AdminMapper {

    public Admin toAdmin(AdminRequest req) {
        return Admin.builder()
                .email(req.email())
                .userName(req.userName())
                .password(req.password())
                .build();
    }

}
