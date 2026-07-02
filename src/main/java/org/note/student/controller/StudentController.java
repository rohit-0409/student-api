package org.note.student.controller;

import jakarta.validation.Valid;
import org.note.student.dto.CreateStudentRequest;
import org.note.student.dto.StudentResponse;
import org.note.student.model.Student;
import org.note.student.repository.StudentRepository;
import org.note.student.response.ApiResponse;
import org.note.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ApiResponse<StudentResponse> getStudentById(@PathVariable long id){
        StudentResponse response = studentService.getStudentById(id);
        return new ApiResponse<>(
                true,
                "Student created successfully",
                response
        );
    }

    @PostMapping
    public ApiResponse<StudentResponse> postStudent(@Valid @RequestBody CreateStudentRequest request){
        StudentResponse response = studentService.postStudent(request);

        return new ApiResponse<>(
                true,
                "Student created successfully",
                response
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentResponse> putStudent(@PathVariable long id,@Valid @RequestBody CreateStudentRequest request){
        StudentResponse response = studentService.putStudent(id,request);
        return new ApiResponse<>(
                true,
                "Student updated",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteStudentById(@PathVariable long id){
        String response = studentService.deleteStudentById(id);
        return new ApiResponse<>(
                true,
                "Student Removed",
                response
        );
    }
}
