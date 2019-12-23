package com.qf.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author 炜哥哥
 * @date 2019/12/18 14:28
 */
public class Subject implements Serializable {
    private  Integer id;
    private  String subjectName;
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
