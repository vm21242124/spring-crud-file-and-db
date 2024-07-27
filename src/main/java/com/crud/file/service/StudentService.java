package com.crud.file.service;

import com.crud.file.entity.Student;
import com.crud.file.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student)  throws IOException;

    Student getStudent(int id)  throws IOException;

    List<Student> getAllStudents() throws IOException;

    Student updateStudent(int id, Student student)  throws IOException;

    void deleteStudent(int id)  throws IOException;
}
