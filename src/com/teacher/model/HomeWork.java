package com.teacher.model;

import java.util.Date;

public class HomeWork {
    private long taskId;
    private int taskTime;
    private Date taskstop;
    private String taskContent;
    private long courseId;
    private long studentId;
    private float score;
    private String postil;

    public HomeWork() {
    }

    public HomeWork(long taskId, int taskTime, Date taskstop, String taskContent, long courseId, long studentId, float score, String postil) {
        this.taskId = taskId;
        this.taskTime = taskTime;
        this.taskstop = taskstop;
        this.taskContent = taskContent;
        this.courseId = courseId;
        this.studentId = studentId;
        this.score = score;
        this.postil = postil;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(int taskTime) {
        this.taskTime = taskTime;
    }

    public Date getTaskstop() {
        return taskstop;
    }

    public void setTaskstop(Date taskstop) {
        this.taskstop = taskstop;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getPostil() {
        return postil;
    }

    public void setPostil(String postil) {
        this.postil = postil;
    }
}
