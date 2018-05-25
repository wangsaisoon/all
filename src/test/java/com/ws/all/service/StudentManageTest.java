package com.ws.all.service;

import com.ws.all.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentManageTest {

    @Autowired
    private StudentManage studentManage;

    @Test
    public void findByStudentNumber() {
        Student student = studentManage.findByStudentNumber("1001");
        Assert.assertNotNull(student);
    }

    @Test
    public void listAll() {
        List<Student> studentList = studentManage.listAll();
        Assert.assertNotEquals(0, studentList.size());
    }
}