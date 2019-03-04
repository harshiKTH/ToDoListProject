package com.todolist.object;

import com.todolist.interfaces.List;

import java.util.ArrayList;

public class ToDoList<E> implements List<E> {
    private ArrayList<E> listItems = new ArrayList<>();
    @Override
    public boolean addItem(E listItem) {
        getListItems().add(listItem);
        return false;
    }

    @Override
    public boolean removeItem(int position) {
        try {
            getListItems().remove(position);
            return true;
        }catch (Exception e) {
            return false;
        }

    }

    @Override
    public E editItem(int position,E listItem) {
        this.listItems.set(position-1,listItem);
        return null;
    }

    @Override
    public E getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public int listCount() {
        return getListItems().size();
    }

    public ArrayList<E> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<E> listItems) {
        this.listItems=null;
        this.listItems = listItems;
    }


}
