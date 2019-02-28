package com.todolist.object;

import com.todolist.literals.Constants;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public  class ListItem implements Serializable{

    private Date dueDate = null;
    private String task = null;
    String status="";
    Locale locale = new Locale("en", "US");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);


    public ListItem(){
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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
