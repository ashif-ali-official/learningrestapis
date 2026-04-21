package com.whoisashif.universitymanagementsystem.service;

import com.whoisashif.universitymanagementsystem.dto.NewStudentDto;
import com.whoisashif.universitymanagementsystem.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

     List<StudentDto> getAllStudents();
     StudentDto getStudentById(Long id);
     StudentDto addNewStudent(NewStudentDto student);
     void removeStudent(Long id);
     StudentDto updateStudent(Long id, NewStudentDto newStudent);
     StudentDto updateStudentField(Long id, Map<String, Object> updates);

}
