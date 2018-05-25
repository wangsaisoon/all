package com.ws.all.controller.student;

import com.ws.all.bean.Student;
import com.ws.all.bean.mapper.StudentMapper;
import com.ws.all.enums.ExceptionEnum;
import com.ws.all.exception.MyException;
import com.ws.all.service.StudentManage;
import com.ws.all.utils.Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
public class StudentController {

    // xml
    @Autowired
    private StudentManage studentManage;

    // 注解
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学生列表
     * @return
     */
    @GetMapping(value = "student/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Student> studentList = studentMapper.listAll();
//        List<Student> studentList = studentManage.listAll();
        mv.addObject("studentList", studentList);
        mv.setViewName("student/list");
        return mv;
    }

    /**
     * 去编辑页面
     * @return
     */
    @GetMapping(value = "student/toEdit")
    public ModelAndView toEdit(String studentNumber) {
        ModelAndView mv = new ModelAndView();
        if (!StringUtils.isEmpty(studentNumber)) {
            // 修改
            Student student = studentManage.findByStudentNumber(studentNumber);
            mv.addObject("student", student);
            mv.addObject("url", "upd");
        } else {
            mv.addObject("url", "save");
        }
        mv.setViewName("student/edit");
        return mv;
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @PostMapping("student/save")
    public ModelAndView save(Student student) {
        ModelAndView mv = new ModelAndView();
        try {
            if (!ObjectUtils.isEmpty(student)) {
                student.setStudentNumber(Tools.getUUID());
//                studentManage.save(student);
                studentMapper.insertByObject(student);
                mv.addObject("msg", "success");
            }
        } catch (Exception e) {
            log.error("【student】save={}", e);
            mv.addObject("msg", "error");
        }
        mv.setViewName("student/edit");
        return mv;
    }

    /**
     * 删除
     * @param studentNumber
     */
    @GetMapping(value = "student/del")
    public void del(String studentNumber, PrintWriter out) {
        if (StringUtils.isEmpty(studentNumber)) {
            log.error("【student】删除id不能为空");
            throw new MyException(ExceptionEnum.ID_IS_NULL);
        }
        try {
            studentManage.del(studentNumber);
            out.print("success");
        } catch (Exception e) {
            log.error("【student】del={}", e);
        }
        out.flush();
        out.close();
    }


    /**
     * 修改
     * @param student
     * @return
     */
    @PostMapping("student/upd")
    public ModelAndView upd(Student student) {
        ModelAndView mv = new ModelAndView();
        try {
            if (!ObjectUtils.isEmpty(student)) {
                studentManage.upd(student);
                mv.addObject("msg", "success");
            }
        } catch (Exception e) {
            log.error("【student】upd={}", e);
            mv.addObject("msg", "error");
        }
        mv.setViewName("student/edit");
        return mv;
    }
}
