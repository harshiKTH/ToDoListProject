package com.todolist.interfaces;

public interface List<E> {


    boolean addItem(E item);
    boolean removeItem(int position);
    E editItem(int position,E listItem);
    E getItem(int position);
    int listCount();


}
