package com.ws.all.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student  implements Serializable {

    private static final long serialVersionUID = -2250364392181032103L;

    private String studentNumber;
    private String studentName;
    private Integer age;

    public Student() {
    }

    public Student(String studentNumber, String studentName, Integer age) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.age = age;
    }
}
