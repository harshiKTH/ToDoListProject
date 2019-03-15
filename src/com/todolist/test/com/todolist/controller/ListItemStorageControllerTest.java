package com.todolist.test.com.todolist.controller;

import com.todolist.ModelClasses.Task;
import com.todolist.ModelClasses.ToDoList;
import com.todolist.controller.ListItemStorageController;
import com.todolist.literals.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.*;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ListItemStorageControllerTest {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Task task1;
    private Task task2;
    File file = new File("FileStore.txt");



    @Before
    public void setUp() throws Exception {

        Date date1 = dateFormat.parse("02-02-2002");
        Date date2 = dateFormat.parse("19-09-2019");
        task1 = new Task("title1", "project1", date1, Constants.STATUS_PENDING);
        task2 = new Task("titel2", "Project2", date2, Constants.STATUS_DONE);


        /*

        Set up everything before testing
         */
    }

    @Test
    public void storeListTest() {
        ListItemStorageController fileStorageTrue = new ListItemStorageController("FileStore.txt");
        ListItemStorageController fileStorageFalse = new ListItemStorageController("");

        ToDoList list = new ToDoList();
        list.addItem(task1);
        list.addItem(task2);
        boolean actual = fileStorageTrue.storeList(list.getListItems());

        assertEquals(true, actual);
        assertEquals(false, fileStorageFalse.storeList(list.getListItems()));

    }

    @Test
    public void loadList(){
        ListItemStorageController fileStorageTrue = new ListItemStorageController("FileStore.txt");
        ListItemStorageController fileStorageFalse = new ListItemStorageController("");
        ListItemStorageController fileStorageFalse1 = new ListItemStorageController("aaa");

        ToDoList list = new ToDoList();
        list.addItem(task1);
        list.addItem(task2);
        ArrayList<ToDoList> actual = fileStorageTrue.loadList();
        assertEquals(2,actual.size());
        ArrayList<ToDoList> actual2 = fileStorageFalse.loadList();
        assertEquals(0,actual2.size());
        ArrayList<ToDoList>actual3 = fileStorageFalse1.loadList();
        assertEquals(0,actual3.size());

    }
    @AfterEach
    void tearDown(){

    }
}


