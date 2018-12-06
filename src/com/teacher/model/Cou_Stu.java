package com.teacher.model;

public class Cou_Stu {
    long student_uuid;
    long course_id;
    String course_name;

    public Cou_Stu() {
    }

    public long getStudent_uuid() {
        return student_uuid;
    }

    public void setStudent_uuid(long student_uuid) {
        this.student_uuid = student_uuid;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}

