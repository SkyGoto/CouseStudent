package com.teacher.model;

public class Course {
    private String course_id ;
    private String course_name;
    private int course_time;
    private String course_info;

    public Course() {}

    public Course(String course_id, String course_name, int course_time, String course_info) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_time = course_time;
        this.course_info = course_info;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_time() {
        return course_time;
    }

    public void setCourse_time(int course_time) {
        this.course_time = course_time;
    }

    public String getCourse_info() {
        return course_info;
    }

    public void setCourse_info(String course_info) {
        this.course_info = course_info;
    }
}
