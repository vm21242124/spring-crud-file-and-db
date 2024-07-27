package com.crud.file.controller;

import com.crud.file.entity.Student;
import com.crud.file.entity.Student;
import com.crud.file.service.StudentService;
import com.crud.file.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping

    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws IOException {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) throws IOException {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() throws IOException {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student Student) throws IOException {
        return ResponseEntity.ok(studentService.updateStudent(id, Student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) throws IOException {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
