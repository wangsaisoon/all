package com.ws.all.bean.mapper;

import com.ws.all.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * MyBatis注解方式使用
 */
//@CacheConfig(cacheNames = "student")
public interface StudentMapper {

    /**
     * 查询所有
     * @return
     */
//    @Cacheable(key = "123")
    @Select("select * from student")
    @Results({
            @Result(column = "student_number", property = "studentNumber"),
            @Result(column = "student_name", property = "studentName"),
            @Result(column = "age", property = "age")
    })
    List<Student> listAll();

    /**
     * 通过对象新增
     * @param student
     * @return
     */
//    @CachePut(key = "123")
    @Insert("insert into student(student_number, student_name, age) values (#{studentNumber, jdbcType=VARCHAR}, #{studentName, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByObject(Student student);

    /**
     * 通过map新增
     * @param map
     * @return
     */
    @Insert("insert into student(student_number, student_name, age) values (#{studentNumber, jdbcType=VARCHAR}, #{studentName, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 通过编号查询
     * @param studentNumber
     * @return
     */
    @Select("select * from student where student_number = #{studentNumber}")
    @Results({
            @Result(column = "student_number", property = "studentNumber"),
            @Result(column = "student_name", property = "studentName"),
            @Result(column = "age", property = "age")
    })
    Student findByStudentNumber(String studentNumber);

    /**
     * 通过姓名查询
     * @param studentName
     * @return
     */
    @Select("select * from student where student_name = #{studentName}")
    @Results({
            @Result(column = "student_number", property = "studentNumber"),
            @Result(column = "student_name", property = "studentName"),
            @Result(column = "age", property = "age")
    })
    List<Student> findByStudentName(String studentName);

    /**
     * 通过编码删除
     * @param studentNumber
     * @return
     */
//    @CacheEvict(key = "123")
    @Delete("delete from student where student_number = #{studentNumber}")
    int deleteByStudentNumber(String studentNumber);

    /**
     * 通过对象修改
     * @param student
     * @return
     */
    @Update("update student set student_name = #{studentName}, age = #{age} where student_number = #{studentNumber}")
    int updateByObject(Student student);

    /**
     * 通过编码修改名字
     * @param studentName
     * @param StudentNumber
     * @return
     */
    @Update("update student set student_name = #{studentName} where student_number = #{studentNumber}")
    int updateStudentNameByStudentNumber(@Param("studentName") String studentName, @Param("studentNumber") String StudentNumber);

}
