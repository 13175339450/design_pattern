package com.hxl.design;

import com.hxl.design.entity.PersonInfo;
import com.hxl.design.entity.Student;
import com.hxl.design.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: 假设需求是，打印 黄湾小学二年级三班 所有学生的信息，共有1000人（老师信息都相同、阅读的书籍都相同）
 *  总结: 当需要创建很多个类似的复杂对象（可能需要经历数据库连接、网络、大量计算等高消耗场景），而这些对象只有小部分的属性值不同，
 *       此时如果每次都重新 new对象，那么每个对象创建的成本太高（小部分不同 + 大部分相同）。此时使用原型 Prototype 可以很好的解决这个问题。
 *       首先创建一个原型对象，其余对象在此原型对象进行深拷贝，并修改部分属性即可！此时深拷贝的性能远高于 new对象的高消耗。（如果是简单对象，深拷贝性能可能不如直接 new对象）
 *       如果对象里某个引用类型的属性实例化也非常消耗性能（阅读书籍信息），同时也只有部分属性不同（姓名），此时也可以对该引用对应的类实现深靠拷贝（个人信息）。
 *       如果某个引用类型没有实现深拷贝，那么拷贝的是引用类型的值（地址值），本质还是只想同一个引用对象（老师信息）。
 */
@SpringBootTest
public class PrototypePatternTest {

    private static final String CALZZ = "黄湾小学二年级三班";

    /**
     * 传统模式
     * 缺点: 当创建多个类似的复杂对象时，重复new会带来很大的性能损耗，使用克隆会节省很多CPU资源
     */
    @Test
    public void testCustom() {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 1000; i++) {
            Student student = new Student();
            student.setStuId(i);
            student.setClazz(CALZZ);

            // 设置个人信息
            // 模拟创建对象的成本高（放入循环，每次都要重新准备）
            List<String> readings = createReading();
            student.setPersonInfo(new PersonInfo("姓名" + i, readings));

            // 设置老师信息
            // 模拟创建对象的成本高（放入循环，每次都要重新准备）
            Teacher teacher = createTeacher();
            student.setTeachers(teacher);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("========> 消耗的时间为: " + (endTime - startTime) + " ms");
    }

    /**
     * 原型模式
     */
    @Test
    public void testPrototype() throws CloneNotSupportedException {
        long startTime = System.currentTimeMillis();

        // 准备原型对象
        Student student = new Student();
        student.setStuId(1);
        student.setClazz(CALZZ);
        // 设置个人信息
        List<String> readings = createReading();
        student.setPersonInfo(new PersonInfo("姓名1", readings));

        // 设置老师信息
        Teacher teacher = createTeacher();
        student.setTeachers(teacher);

        for (int i = 2; i <= 1000; i++) {
            // 克隆原型
            Student studentClone = student.clone();
            // 修改属性
            studentClone.setStuId(i);
            PersonInfo personClone = student.getPersonInfo().clone();
            personClone.setName("姓名" + i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("========> 消耗的时间为: " + (endTime - startTime) + " ms");
    }

    /**
     * 模拟创建对象时，每次都要准备很多复杂的对象（实际开发是大量计算、复杂初始化、数据库连接、网络请求等等）
     */
    private List<String> createReading() {
        List<String> readings = new ArrayList<>();
        for (int j = 0; j < 100000; j++) {
            readings.add("课文" + j);
        }
        return readings;
    }

    /**
     * 模拟创建对象时，每次都要准备很多复杂的对象（实际开发是大量计算、复杂初始化、数据库连接、网络请求等等）
     */
    private Teacher createTeacher() {
        Map<String, String> teachers = new HashMap<>();
        for (int j = 0; j < 100000; j++) {
            teachers.put("老师" + j, "科目" + j);
        }
        return new Teacher(teachers);
    }
}
