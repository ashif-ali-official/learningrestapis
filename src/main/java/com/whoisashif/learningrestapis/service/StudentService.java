package com.whoisashif.learningrestapis.service;

import com.whoisashif.learningrestapis.dto.NewStudentDto;
import com.whoisashif.learningrestapis.dto.StudentDto;

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
