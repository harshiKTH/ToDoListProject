package com.todolist.test.com.todolist.ModelClasses;

import com.todolist.ModelClasses.Task;
import com.todolist.abstractclasses.UserInterface;


import com.todolist.literals.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

public class TaskTest {

    private Locale locale = new Locale("en", "US");
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
    private Task task1;
    private Task task2;
    private Date date1;
    private Constants status;


    @Before
    public void setUp() throws Exception
    {
        date1 = new SimpleDateFormat("dd/MM/yyyy").parse("02/02/2022");

        status = Constants.STATUS_PENDING;
        task1 = new Task("title1", "project1" , date1, status);
        task2 = new Task();


    }

    @After
    public void tearDown() throws Exception {

        /*
         */
    }

    @Test
    public void setAndGetProjectTest()
    {
        assertEquals("project1", task1.getProjectName());
        assertNull(task2.getProjectName());
        task2.setProjectName("project2");
        assertEquals("project2", task2.getProjectName());

    }


    @Test
    public void getStatusTest() {
        assertEquals(status,task1.getStatus());

    }

    @Test
    public void getDueDateTest()  {

        assertEquals(dateFormat.format(date1),task1.getDueDate());
    }



    @Test
    public void getTaskNameTest() {
        assertEquals("title1", task1.getTaskName());
        assertNull(task2.getTaskName());
        task2.setTaskName("title1");
        assertEquals("title1", task2.getTaskName());

    }




}