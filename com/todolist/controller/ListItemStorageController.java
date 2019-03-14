package com.todolist.controller;

import java.io.*;
import java.util.ArrayList;
import com.todolist.abstractclasses.ListItemsStorage;

public class ListItemStorageController<E> extends ListItemsStorage<E> {
    private static final long serialVersionUID = -3L;



    private File file;
    public ListItemStorageController(String path)  {
        file =  new File(path);



    }
    public ListItemStorageController()  {
        file =  new File("FileStore.txt");



    }

    @Override
    public boolean storeList(ArrayList<E> listItems)
    {
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


    @Override
    public ArrayList<E> loadList()
    {
        boolean isSuccess=true;
        ArrayList<E> result = new ArrayList<E>();

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(file.getAbsolutePath());

            result = (ArrayList<E>) ois.readObject();

            fis.close();
            ois.close();

        }
        catch (EOFException e)
        {
            System.out.println("The file is empty");
        }
        catch (IOException e) {
            System.out.println("can't find the file ");
            //e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }



        return result;
    }
}
