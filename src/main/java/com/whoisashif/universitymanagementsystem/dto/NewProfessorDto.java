package com.whoisashif.universitymanagementsystem.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class NewProfessorDto {

    private String name;
    @Email
    private String email;
    private String dept;

}
