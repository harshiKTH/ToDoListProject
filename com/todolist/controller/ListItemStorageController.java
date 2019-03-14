package com.todolist.controller;

import java.io.*;
import java.util.ArrayList;

import com.todolist.abstractclasses.ListItemsStorage;

public class ListItemStorageController<E> extends ListItemsStorage<E> {
    private static final long serialVersionUID = -3L;
    private File file;

    //initialise a file to store the user list for permanent storage
    public ListItemStorageController(String path) {
        file = new File(path);
    }

    //set file name to be used for permanent storage
    public ListItemStorageController() {
        file = new File("FileStore.txt");
    }

    //methos to store the itesm passed in array lust
    @Override
    public boolean storeList(ArrayList<E> listItems) {
        boolean succes = true;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listItems);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("the file doesn't exist before");
            succes = false;
        }

        return succes;
    }

    //method to load the initial object list from the permanent storage
    @Override
    public ArrayList<E> loadList() {
        ArrayList<E> result = new ArrayList<E>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(file.getAbsolutePath());
            result = (ArrayList<E>) ois.readObject();
            fis.close();
            ois.close();
        } catch (EOFException e) {
            System.out.println("The file is empty");
        } catch (IOException e) {
            System.out.println("can't find the file ");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getCause());
        }
        return result;
    }
}
