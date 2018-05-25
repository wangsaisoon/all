package com.ws.all.service;

import com.ws.all.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * MyBatis xml 方式使用
 */
@CacheConfig(cacheNames = "student")
public interface StudentManage {

    /**
     * 通过编码查询
     * @param studentNumber
     * @return
     */
//    @Cacheable(key = "321")// 添加缓存，key=student::321
    Student findByStudentNumber(String studentNumber);

    /**
     * 查询学生列表
     * @return
     */
    List<Student> listAll();

    /**
     * 新增
     * @param student
     */
    void save(Student student) throws Exception;

    /**
     * 修改
     * @param student
     */
//    @CachePut(key = "321")// 给缓存重新赋值，必须和添加缓存的那个方法的返回值类型相同
    void upd(Student student) throws Exception;

    /**
     * 删除
     * @param studentNumber
     */
//    @CacheEvict(key = "321")// 删除缓存
    void del(String studentNumber) throws Exception;
}
