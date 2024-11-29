package com.meenal.academic_erp.mapper;

import com.meenal.academic_erp.dto.EducationDTO;
import com.meenal.academic_erp.entity.Education;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EducationMapper {
    public Education toEducation(EducationDTO educationDTO) {
        return Education.builder()
                .educationType(educationDTO.educationType())
                .year(educationDTO.year())
                .schoolName(educationDTO.schoolName())
                .percentage(educationDTO.percentage())
                .build();
    }

    public List<Education> toEducationList(List<EducationDTO> educationDTOList) {
        List<Education> educationList = new ArrayList<>();
        for(EducationDTO educationDTO : educationDTOList) {
            educationList.add(toEducation(educationDTO));
        }

        return educationList;
    }

    public EducationDTO toEducationDTO(Education education) {
        return new EducationDTO(
                education.getEducationType(),
                education.getPercentage(),
                education.getYear(),
                education.getSchoolName());
    }

    public List<EducationDTO> toEducationDTOList(List<Education> educationList) {
        List<EducationDTO> educationDTOList = new ArrayList<>();
        for(Education education : educationList) {
            educationDTOList.add(toEducationDTO(education));
        }
        return educationDTOList;
    }

}
