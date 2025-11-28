package com.hxl.design.entity;

import java.util.List;

/**
 * 个人信息: 姓名、年龄、家庭住址
 *
 * @author hengxiaoliang
 */
public class PersonInfo implements Cloneable {

    // 学生姓名
    private String name;

    // 学过的课文名
    private List<String> reading;

    /**
     * 深拷贝
     */
    @Override
    public PersonInfo clone() throws CloneNotSupportedException {
        return (PersonInfo) super.clone();
    }

    public PersonInfo(String name, List<String> reading) {
        this.name = name;
        this.reading = reading;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReading() {
        return reading;
    }

    public void setReading(List<String> reading) {
        this.reading = reading;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", reading=" + reading +
                '}';
    }
}
