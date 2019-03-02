package com.todolist.controller;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import com.todolist.object.ListItem;
import com.todolist.abstractclasses.ListItemsStorage;

public class ListItemStorageController extends ListItemsStorage {

    URL url ;
    File file = null;

    public ListItemStorageController() throws IOException {
        String directory=System.getProperty("user.dir");

        try {
            file = new File(directory + "FileStore");
        }catch (Exception e){
            file.createNewFile();
        }


    }

    @Override
    public boolean storeList(ArrayList<ListItem> listItems) {
        // write object to file
        FileOutputStream fos = null;
        boolean isSuccess=true;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        try {
            oos.writeObject(listItems);
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        return isSuccess;

    }

    @Override
    public ArrayList<ListItem> loadList() {
        FileInputStream fis = null;
        boolean isSuccess=true;
        ObjectInputStream ois = null;
        ArrayList<ListItem> result = new ArrayList<ListItem>();

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            isSuccess=false;
            return result;

        }

        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        try {
            result = (ArrayList<ListItem>) ois.readObject();
            return result;
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        return result;
    }
}
