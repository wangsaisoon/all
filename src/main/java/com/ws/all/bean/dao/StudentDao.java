package com.ws.all.bean.dao;

import com.ws.all.bean.Student;
import com.ws.all.bean.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDao {

    @Autowired
    private StudentMapper mapper;

    public int insertByObject(Student student) {
        return mapper.insertByObject(student);
    }


}
