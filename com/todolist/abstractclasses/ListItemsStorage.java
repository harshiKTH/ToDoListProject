package com.todolist.abstractclasses;

import java.io.*;
import java.util.ArrayList;

public abstract class ListItemsStorage<E> implements Serializable {

    public abstract boolean storeList(ArrayList<E> listItems);

    public abstract ArrayList<E> loadList();


}
