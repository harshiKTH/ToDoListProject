package com.todolist.object;

import com.todolist.literals.Constants;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public  class Task implements Serializable{

    private Date dueDate = null;
    private String taskName = null;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private String projectName = null;

    String status="";
    Locale locale = new Locale("en", "US");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);


    public Task(){
        this.status = Constants.STATUS_PENDING;
    }
    public  String getStatus() {
        return status;
    }

    public String getDueDate() {

        String date = dateFormat.format(dueDate);
        return date;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName)  {
        this.taskName = taskName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
