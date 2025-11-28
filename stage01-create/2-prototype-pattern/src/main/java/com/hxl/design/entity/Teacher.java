package com.hxl.design.entity;

import java.util.Map;

/**
 * 老师信息: 姓名、科目
 *
 * @author hengxiaoliang
 */
public class Teacher {

    private Map<String, String> teacher;

    public Teacher(Map<String, String> teacher) {
        this.teacher = teacher;
    }

    public Map<String, String> getTeacher() {
        return teacher;
    }

    public void setTeacher(Map<String, String> teacher) {
        this.teacher = teacher;
    }
}
