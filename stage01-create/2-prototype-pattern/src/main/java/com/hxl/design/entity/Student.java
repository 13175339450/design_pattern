package com.hxl.design.entity;

import java.util.List;

/**
 * 学生类: 学号、班级、个人信息、老师
 */
public class Student implements Cloneable {

    // 调用 Set方法修改属性值（关键）
    private Integer stuId;

    private String clazz;

    // 调用 Set方法修改属性值（关键）
    private PersonInfo personInfo;

    private Teacher teachers;

    /**
     * 深拷贝克隆
     */
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", clazz='" + clazz + '\'' +
                ", personInfo=" + personInfo +
                ", teachers=" + teachers +
                '}';
    }
}
