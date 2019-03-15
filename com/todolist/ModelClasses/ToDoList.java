package com.todolist.ModelClasses;

import com.todolist.interfaces.List;


import java.util.ArrayList;

public class ToDoList<E> implements List<E> {

    private ArrayList<E> listItems = new ArrayList<>();

    //method to add list item to list
    @Override
    public boolean addItem(E listItem) {
        getListItems().add(listItem);
        return false;
    }

    //method to remove item from the list given a position
    @Override
    public boolean removeItem(int position) {
        try {
            getListItems().remove(position);
            return true;
        }catch (Exception e) {
            return false;
        }

    }

    //method to edit item in the list given a position
    @Override
    public E editItem(int position,E listItem) {
        this.listItems.set(position-1,listItem);
        return null;
    }

    //method to get item from the list
    @Override
    public E getItem(int position) {
        return listItems.get(position);
    }

    //method to get the size of the current list
    @Override
    public int listCount() {
        return getListItems().size();
    }

    public ArrayList<E> getListItems() {
        return listItems;
    }

    //method to re-assign a list to existing list array
    public void setListItems(ArrayList<E> listItems) {
        this.listItems=null;
        this.listItems = listItems;
    }


}
