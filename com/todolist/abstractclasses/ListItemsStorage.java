package com.todolist.abstractclasses;

import java.io.*;
import java.util.ArrayList;

public abstract class ListItemsStorage<E> implements Serializable {
    private static final long serialVersionUID = -2L;

    //method to store the list items
    public abstract boolean storeList(ArrayList<E> listItems);

    //method to load the list items from storage
    public abstract ArrayList<E> loadList();


}
