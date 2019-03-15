package com.todolist.ModelClasses;

import com.todolist.literals.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TaskTest {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Task task1;
    private Task task2;


    @Before
    public void setUp() throws Exception
    {
        Date date1 = dateFormat.parse("02-02-2002");
        task1 = new Task("title1", "project1" , date1, Constants.STATUS_PENDING);

        task2 = new Task();

        /*

        Set up everything before testing

         */
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
        assertEquals("project2", task2.getProjectName()); //Then

    }


    @Test
    public void getStatus() {
        //assertEquals(());
    }

    @Test
    public void getDueDate() {
    }

    @Test
    public void setDueDate() {
    }

    @Test
    public void getTaskName() {
    }

    @Test
    public void setTaskName() {
    }

    @Test
    public void setStatus() {
    }
}