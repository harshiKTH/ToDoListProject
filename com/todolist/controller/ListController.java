package com.todolist.controller;

import com.todolist.literals.Constants;
import com.todolist.object.ListItem;
import com.todolist.object.ToDoList;
import com.todolist.abstractclasses.UserInterface;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ListController extends UserInterface {

    private ToDoList toDoList;
    private static ListItemStorageController listItemStorageController;
    private static ListController listController;


    public static void main(String args[]) throws IOException {
        listController = new ListController();
        listController.toDoList = new ToDoList();
        listItemStorageController = new ListItemStorageController();
        // assign the list objects from the file store
        listController.toDoList.setListItems(listItemStorageController.loadList());
        boolean isQuit = false;
        String userInput;

        System.out.println("\nWelcome toToDoly!!! \nYou have total " + listController.toDoList.listCount()+ " task to do");


        while (!isQuit) {
            listController.userMenu();
            userInput = listController.getUserInput("\nEnter your choice : ");
            if (userInput.equals("0") || userInput.equalsIgnoreCase("q")) {
                isQuit = true;
                listController.listItemStorageController.storeList(listController.toDoList.getListItems());

            } else if (userInput.equals("1")) { //Show user menu
                listController.userMenu();
            } else if (userInput.equals("2")) { //Add list item to the list
                listController.addListItem();
            } else if (userInput.equals("3")) { //Remove list item
                listController.removeListItem();
            } else if (userInput.equals("4")) { //Edit list item
                listController.editListItem(Integer.parseInt(listController.getUserInput("Enter item number to edit :")));
            } else if (userInput.equals("5")) { //Show all list items
                listController.printList(listController.toDoList.getListItems());
            } else if (userInput.equals("6")) { //Mark a task status to done
                listController.markListItemDone(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            } else if (userInput.equals("7")) { //Mark a task status to not done
                listController.markListItemPending(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            }
              else if (userInput.equals("8")) { //Store the list items
                listController.listItemStorageController.storeList(listController.toDoList.getListItems());
        }


        }
        System.exit(0);
    }

    private void addListItem(){
    ListItem tempListItem = new ListItem();
    try {
        tempListItem.setTask(listController.getUserInput("Enter Task"));
        tempListItem.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Enter task date \"dd/MM/yyyy\"")));
        listController.toDoList.addItem(tempListItem);
        }
    catch (Exception e) {
        System.out.println("Invalid data format entered");
        }
    }

    private boolean editListItem(int listItemNum){
        ListItem tempListItem = new ListItem();
       try {
           tempListItem.setTask(listController.getUserInput("Update Task (" + listController.toDoList.getItem(listItemNum-1).getTask() + ")"));
           tempListItem.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Update Task date \"dd/MM/yyyy\" (" + listController.toDoList.getItem(listItemNum-1).getDueDate()+ ")")));
           listController.toDoList.editItem(listItemNum,tempListItem);
        }
        catch (Exception e) {
            System.out.println("Invalid data format entered!!!");
        }
        return true;
    }

    private void removeListItem(){
        listController.printList(listController.toDoList.getListItems());
        int pos = Integer.parseInt(listController.getUserInput("Enter list item to delete :"));
        if(pos > 0 && pos <= listController.toDoList.listCount())
            listController.toDoList.removeItem(pos-1);
        else
            System.out.println("Number entered not in range \n" + "##############################");
    }

    private boolean markListItemDone(int listItemNum){
        try {
            ListItem tempListItem;
            tempListItem=listController.toDoList.getItem(listItemNum-1);
            tempListItem.setStatus(Constants.STATUS_DONE);
            listController.toDoList.editItem(listItemNum,tempListItem);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean markListItemPending(int listItemNum){
        try {
            ListItem tempListItem;
            tempListItem=listController.toDoList.getItem(listItemNum-1);
            tempListItem.setStatus(Constants.STATUS_PENDING);
            listController.toDoList.editItem(listItemNum,tempListItem);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean clearScreen() {
        return false;
    }

    @Override
    public boolean updateScreen() {
        return false;
    }

    @Override
    public void userMenu() {
        System.out.print("\n (1) Show Menu\n " +
                "(2) Add List Item\n " +
                "(3) Remove List Item\n " +
                "(4) Edit List Item\n " +
                "(5) Show List Items\n " +
                "(6) Mark a task completed\n " +
                "(7) Mark a task not completed\n "+
                "(8) Save Current List\n " +
                "(0|Q|q) Quit\n ");
    }

    @Override
    public void printList(ArrayList<ListItem> arrayList) {
        int listNumber = 1;
        System.out.println("*****************************************************************************");
        System.out.printf("%-2s %-15s %-10s %-30s","TASK#", "DUE DATE", "STATUS", "TASK NAME");
        System.out.print("\n");
        System.out.println("*****************************************************************************");
        System.out.print("\n");
        for (ListItem listItem : arrayList) {
            System.out.printf("%-5s %-15s %-10s %-30s", listNumber++, listItem.getDueDate(),listItem.getStatus(), listItem.getTask() + "\n");
            System.out.print("\n");
        }
        System.out.println();
        //list.forEach(System.out::println);

    }
}
