package com.todolist.abstractclasses;

import com.todolist.object.ListItem;

import java.io.*;
import java.util.ArrayList;

public abstract class ListItemsStorage implements Serializable {

    public abstract boolean storeList(ArrayList<ListItem> listItems);

    public abstract ArrayList<ListItem> loadList();


}
