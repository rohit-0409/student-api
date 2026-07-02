package org.note.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.note.student.enums.Grade;

public class CreateStudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Grade grade;

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setGrade(Grade grade){
        this.grade = grade;
    }

    public String getName(){return this.name;}
    public String getEmail(){return this.email;}
    public Grade getGrade(){return this.grade;}
}
