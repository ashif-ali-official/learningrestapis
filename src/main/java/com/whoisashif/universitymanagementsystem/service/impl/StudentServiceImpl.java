package com.whoisashif.universitymanagementsystem.service.impl;

import com.whoisashif.universitymanagementsystem.dto.NewStudentDto;
import com.whoisashif.universitymanagementsystem.dto.StudentDto;
import com.whoisashif.universitymanagementsystem.entity.Student;
import com.whoisashif.universitymanagementsystem.repository.StudentRepository;
import com.whoisashif.universitymanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students.stream().map( student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Student not found with ID: " + id));
        return new StudentDto(student.getId(), student.getName(), student.getEmail());
    }

    @Override
    public StudentDto addNewStudent(NewStudentDto student) {
        Student savedStudent = studentRepository.save(new Student(student.getName(), student.getEmail()));
        return new StudentDto(savedStudent.getId(), savedStudent.getName(), savedStudent.getEmail());
    }

    @Override
    public void removeStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
        studentRepository.delete(student);
    }

    @Override
    public StudentDto updateStudent(Long id, NewStudentDto newStudent) {
        Student student = studentRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Student not found with ID: " + id));
        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student = studentRepository.save(student);

        return new StudentDto(student.getId(), student.getName(), student.getEmail());
    }

    @Override
    public StudentDto updateStudentField(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Student not found with ID: " + id));
        updates.forEach( ( field, value ) -> {
            switch (field) {
                case "name": student.setName(value.toString()); break;
                case "email": student.setEmail(value.toString()); break;
                default: throw new IllegalArgumentException("Field isn't supported");
            }
        });
        Student patchedStudent = studentRepository.save(student);
        return new StudentDto(patchedStudent.getId(), patchedStudent.getName(), patchedStudent.getEmail());
    }
}
