package com.whoisashif.learningrestapis.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class NewStudentDto {

    private String name;

    @Email
    private String email;

}
