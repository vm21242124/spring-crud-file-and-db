package com.crud.file.service.Impl;

import com.crud.file.entity.Student;
import com.crud.file.repository.StudentRepository;
import com.crud.file.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) throws IOException {
        try {
            // Validate student object
            if (student.getName() == null || student.getName().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be null or empty");
            }
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new IOException("Error creating student due to data integrity violation", e);
        } catch (Exception e) {
            throw new IOException("Unexpected error occurred while creating student", e);
        }
    }

    @Override
    public Student getStudent(int id) throws IOException {
        try {
            return studentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
        } catch (EntityNotFoundException e) {
            throw new IOException(e.getMessage(), e);
        } catch (Exception e) {
            throw new IOException("Unexpected error occurred while retrieving student", e);
        }
    }

    @Override
    public List<Student> getAllStudents() throws IOException {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new IOException("Unexpected error occurred while retrieving students", e);
        }
    }

    @Override
    public Student updateStudent(int id, Student student) throws IOException {
        try {
            Student existingStudent = studentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            return studentRepository.save(existingStudent);
        } catch (EntityNotFoundException e) {
            throw new IOException(e.getMessage(), e);
        } catch (DataIntegrityViolationException e) {
            throw new IOException("Error updating student due to data integrity violation", e);
        } catch (Exception e) {
            throw new IOException("Unexpected error occurred while updating student", e);
        }
    }

    @Override
    public void deleteStudent(int id) throws IOException {
        try {
            if (!studentRepository.existsById(id)) {
                throw new EntityNotFoundException("Student not found with ID: " + id);
            }
            studentRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new IOException(e.getMessage(), e);
        } catch (Exception e) {
            throw new IOException("Unexpected error occurred while deleting student", e);
        }
    }
}
