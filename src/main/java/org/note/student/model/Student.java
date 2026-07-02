package org.note.student.model;

import org.note.student.enums.Grade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private Grade grade;

    public Student(){}
    public Student(String name,String email,Grade grade){
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setGrade(Grade grade){
        this.grade = grade;
    }

    public String getName(){ return this.name; }
    public String getEmail(){ return this.email; }
    public Grade getGrade(){ return this.grade; }
    public Long getId(){return this.id;}

}
