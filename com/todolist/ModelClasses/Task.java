package com.todolist.ModelClasses;

import com.todolist.literals.Constants;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public  class Task implements Serializable{

    private static final long serialVersionUID = -1L;
    private Locale locale = new Locale("en", "US");
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

    private String projectName = null;
    private Constants status;
    private Date dueDate = null;
    private String taskName = null;


    public Task(String title, String project, Date date, Constants status)
    {
        this.taskName = title;
        this.projectName = project;
        this.dueDate = date;
        this.status = status;
    }


    public Task(){
        this.status = Constants.STATUS_PENDING;
    }



    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public  Constants getStatus() {
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

    public void setStatus(Constants status) {
        this.status = status;
    }

    public String getStatusString()
    {
        if (status.equals(Constants.STATUS_DONE))
            return "done";
        else if (status.equals(Constants.STATUS_PENDING))
            return "pending";
        else
            return null;
    }

    public String toString(){
        return this.getProjectName()+"    " +this.getDueDate() + this.getStatusString() +this.getTaskName();
    }

}
