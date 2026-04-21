package com.whoisashif.universitymanagementsystem.service.impl;

import com.whoisashif.universitymanagementsystem.dto.NewProfessorDto;
import com.whoisashif.universitymanagementsystem.dto.ProfessorDto;
import com.whoisashif.universitymanagementsystem.entity.Professor;
import com.whoisashif.universitymanagementsystem.repository.ProfessorRepository;
import com.whoisashif.universitymanagementsystem.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public List<ProfessorDto> getAllProfessors() {
        List<Professor> professors = professorRepository.findAll();
        List<ProfessorDto> studentDtoList = professors.stream().map( professor -> new ProfessorDto(professor.getId(), professor.getName(), professor.getEmail(), professor.getDept())).toList();
        return studentDtoList;
    }

    @Override
    public ProfessorDto getProfessorById(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Professor not found with ID: " + id));
        return new ProfessorDto(professor.getId(), professor.getName(), professor.getEmail(), professor.getDept());
    }

    @Override
    public ProfessorDto addNewProfessor(NewProfessorDto professor) {
        Professor savedProfessor = professorRepository.save(new Professor(professor.getName(), professor.getEmail(), professor.getDept()));
        return new ProfessorDto(savedProfessor.getId(), savedProfessor.getName(), savedProfessor.getEmail(), savedProfessor.getDept());
    }

    @Override
    public void removeProfessor(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Professor not found with ID: " + id));
        professorRepository.delete(professor);
    }

    @Override
    public ProfessorDto updateProfessor(Long id, NewProfessorDto newProfessor) {
        Professor professor = professorRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Professor not found with ID: " + id));
        professor.setName(newProfessor.getName());
        professor.setEmail(newProfessor.getEmail());
        professor.setDept(newProfessor.getDept());
        professor = professorRepository.save(professor);

        return new ProfessorDto(professor.getId(), professor.getName(), professor.getEmail(), professor.getDept());
    }

    @Override
    public ProfessorDto updateProfessorField(Long id, Map<String, Object> updates) {
        Professor professor = professorRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Professor not found with ID: " + id));
        updates.forEach( ( field, value ) -> {
            switch (field) {
                case "name": professor.setName(value.toString()); break;
                case "email": professor.setEmail(value.toString()); break;
                case "dept": professor.setDept(value.toString()); break;
                default: throw new IllegalArgumentException("Field isn't supported");
            }
        });
        Professor patchedProfessor = professorRepository.save(professor);
        return new ProfessorDto(patchedProfessor.getId(), patchedProfessor.getName(), patchedProfessor.getEmail(), patchedProfessor.getDept());
    }
}
