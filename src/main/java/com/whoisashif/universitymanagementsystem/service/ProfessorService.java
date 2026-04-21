package com.whoisashif.universitymanagementsystem.service;

import com.whoisashif.universitymanagementsystem.dto.NewProfessorDto;
import com.whoisashif.universitymanagementsystem.dto.ProfessorDto;

import java.util.List;
import java.util.Map;

public interface ProfessorService {

     List<ProfessorDto> getAllProfessors();
     ProfessorDto getProfessorById(Long id);
     ProfessorDto addNewProfessor(NewProfessorDto student);
     void removeProfessor(Long id);
     ProfessorDto updateProfessor(Long id, NewProfessorDto newStudent);
     ProfessorDto updateProfessorField(Long id, Map<String, Object> updates);

}
