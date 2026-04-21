package com.whoisashif.universitymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDto {

    private Long id;
    private String name;
    private String email;
    private String dept;

}
