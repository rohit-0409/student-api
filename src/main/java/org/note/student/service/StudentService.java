package org.note.student.service;

import org.note.student.dto.CreateStudentRequest;
import org.note.student.dto.StudentResponse;
import org.note.student.exception.StudentNotFoundException;
import org.note.student.model.Student;
import org.note.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public StudentResponse postStudent(CreateStudentRequest studentRequest){

        Student student = getStudent(studentRequest);
        Student savedStudent = studentRepository.save(student);
        return getStudentResponse(savedStudent);
    }

    public StudentResponse putStudent(long id,CreateStudentRequest studentRequest){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        student.setName(studentRequest.getName());
        student.setEmail(student.getEmail());
        student.setGrade(studentRequest.getGrade());

        Student savedStudent = studentRepository.save(student);
        return getStudentResponse(savedStudent);
    }

    public StudentResponse getStudentById(long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        return getStudentResponse(student);
    }

    public String deleteStudentById(long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        studentRepository.delete(student);
        return "Student Removed ID: "+id;
    }

    private static Student getStudent(CreateStudentRequest studentRequest){
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setGrade(studentRequest.getGrade());
        return student;
    }

    private static StudentResponse getStudentResponse(Student savedStudent){
        StudentResponse response = new StudentResponse();
        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());
        response.setGrade(savedStudent.getGrade());
        return response;
    }
}
