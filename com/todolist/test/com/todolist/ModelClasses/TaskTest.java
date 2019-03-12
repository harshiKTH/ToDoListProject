package com.todolist.ModelClasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Before
    public void setUp() throws Exception {

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
    public void getProjectName() {
        Task task = new Task();
        task.setProjectName("asdasdas");




        assertEquals("asdasdas", task.getProjectName());


    }

    @Test
    public void setProjectName() {

    }

    @Test
    public void getStatus() {
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