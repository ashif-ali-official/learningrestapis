package com.whoisashif.learningrestapis.controller;

import com.whoisashif.learningrestapis.dto.NewStudentDto;
import com.whoisashif.learningrestapis.dto.StudentDto;
import com.whoisashif.learningrestapis.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
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

    @PatchMapping("/patch/{id}")
    public ResponseEntity<StudentDto> updateStudentField(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(studentService.updateStudentField(id, updates));
    }

}
