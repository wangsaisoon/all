    package com.ws.all.bean.mapper;

    import com.ws.all.bean.Student;
    import org.junit.Assert;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import static org.junit.Assert.*;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class StudentMapperTest {

        @Autowired
        private StudentMapper studentMapper;

        @Test
        public void insertByMap() throws Exception {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("studentNumber", "1001");
            map.put("studentName", "小白");
            map.put("age", 22);
            int result = studentMapper.insertByMap(map);
            Assert.assertEquals(1, result);
        }

        @Test
        public void insertByObject() throws Exception {
            Student student = new Student("1002", "小黑", 23);
            int result = studentMapper.insertByObject(student);
            Assert.assertEquals(1, result);
        }

        @Test
        public void findByStudentNumber() {
            Student student = studentMapper.findByStudentNumber("1001");
            Assert.assertEquals("1001", student.getStudentNumber());
        }

        @Test
        public void findByStudentName() {
            List<Student> studentList = studentMapper.findByStudentName("小白");
            Assert.assertNotEquals(0, studentList.size());
        }

        @Test
        public void deleteByStudentNumber() {
            int result = studentMapper.deleteByStudentNumber("1003");
            Assert.assertEquals(1, result);
        }

        @Test
        public void updateByStudentNumber() {
            Student student = new Student("1002", "小白白", 10);
            int result = studentMapper.updateByObject(student);
            Assert.assertNotEquals(0, result);
        }

        @Test
        public void updateStudentNameByStudentNumber() {
            int result = studentMapper.updateStudentNameByStudentNumber("小黑黑", "1002");
            Assert.assertNotEquals(0, result);
        }
    }