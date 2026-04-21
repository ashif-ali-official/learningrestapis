package com.whoisashif.universitymanagementsystem.dto;

import com.whoisashif.universitymanagementsystem.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorCompensationDto {

    private Long id;
    private Professor professor;
    private String salary;

}
