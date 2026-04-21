package com.whoisashif.universitymanagementsystem.controller;

import com.whoisashif.universitymanagementsystem.dto.*;
import com.whoisashif.universitymanagementsystem.service.ProfessorService;
import com.whoisashif.universitymanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final StudentService studentService;
    private final ProfessorService professorService;

    @PostMapping("/addProfessor")
    public ResponseEntity<ProfessorDto> addNewProfessor(@RequestBody @Valid NewProfessorDto professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.addNewProfessor(professor));
    }

    @DeleteMapping("/removeProfessor/{id}")
    public ResponseEntity<Void> removeProfessor(@PathVariable Long id) {
        professorService.removeProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateProfessor/{id}")
    public ResponseEntity<ProfessorDto> updateProfessor(@PathVariable Long id, @RequestBody @Valid NewProfessorDto newProfessor) {
        return ResponseEntity.ok(professorService.updateProfessor(id, newProfessor));
    }

    @PatchMapping("/patchProfessor/{id}")
    public ResponseEntity<ProfessorDto> updateProfessorField(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(professorService.updateProfessorField(id, updates));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDto> addNewStudent(@RequestBody @Valid NewStudentDto student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addNewStudent(student));
    }

    @DeleteMapping("/removeStudent/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid NewStudentDto newStudent) {
        return ResponseEntity.ok(studentService.updateStudent(id, newStudent));
    }

    @PatchMapping("/patchStudent/{id}")
    public ResponseEntity<StudentDto> updateStudentField(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(studentService.updateStudentField(id, updates));
    }

    // Professor's Salary
    @GetMapping("/professor/salary/{professorId}")
    public ResponseEntity<ProfessorCompensationDto> getProfessorCompensationByProfessorId(@PathVariable Long professorId) {
        return ResponseEntity.ok(professorService.getProfessorCompensationByProfessorId(professorId));
    }

}
