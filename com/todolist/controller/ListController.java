package com.todolist.controller;


import com.todolist.literals.Constants;
import com.todolist.ModelClasses.Task;
import com.todolist.ModelClasses.ToDoList;
import com.todolist.abstractclasses.UserInterface;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

import static com.todolist.literals.Constants.STATUS_DONE;


public class ListController<E> extends UserInterface<E> {

    private static ListItemStorageController<Task> listItemStorageController;
    private static ListController listController;
    private ToDoList<Task> toDoList;

    public static void main(String args[]) throws IOException {
        //initialize list contoller
        listController = new ListController();
        //initialize to do lits
        listController.toDoList = new ToDoList();
        //initialize list item storage
        listItemStorageController = new ListItemStorageController();
        // assign the list objects from the file store
        listController.toDoList.setListItems(listItemStorageController.loadList());
        boolean isQuit = false;
        String userInput;

        System.out.println("\nWelcome to ToDoly !!! \nYou have total of " + listController.toDoList.getListItems().size() + " and "
                + listController.getNumItemsInList(Constants.STATUS_PENDING) + " task to do");

        //Print user menu for application actions untill user quits from the program
        while (!isQuit) {

            listController.userMenu();
            userInput = listController.getUserInput("\nEnter your choice : ");

            //option to quit from the program
            if (userInput.equals("0") || userInput.equalsIgnoreCase("q")) {
                isQuit = true;
                listController.listItemStorageController.storeList(listController.toDoList.getListItems());

            }
            //option to show user menyu
            else if (userInput.equals("1")) {
                listController.userMenu();
            }
            //option to add task to task list
            else if (userInput.equals("2")) {
                listController.addListItem();
            }
            //option to remove a task from the task list
            else if (userInput.equals("3")) {
                listController.removeListItem(listController.getuserInt(1, listController.toDoList.getListItems().size(), "Enter the task number "));
            }
            //option to edit a task in the task list
            else if (userInput.equals("4")) {
                listController.editListItem(listController.getuserInt(1, listController.toDoList.getListItems().size(), "Enter task number "));
            }
            //option to show all tasks in the task list
            else if (userInput.equals("5")) {
                listController.printList(listController.toDoList.getListItems());
            }
            //option to update a given task to done state
            else if (userInput.equals("6")) {
                listController.markListItemDone(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            }
            //option to update a given task to pending state
            else if (userInput.equals("7")) {
                listController.markListItemPending(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            }
            //option to store the item list if user wishes, also note by default when user exists from the program the list is saved
            else if (userInput.equals("8")) {
                if (listController.listItemStorageController.storeList(listController.toDoList.getListItems())) {
                    listController.notificationMessage("To do list saved successfully ...");
                } else {
                    listController.notificationMessage("To do list saving failure due to system error...");
                }
            }
            //option to sort the task list by project name
            else if (userInput.equals("9")) {
                listController.sortTaskByProject();
            }
            //option to sort the task list by task date
            else if (userInput.equals("10")) {
                listController.sortTaskByDate();
            }
        }
        System.exit(0);
    }

    //method to add list items called by user menu options
    private void addListItem() {
        Task tempTask = new Task();
        try {
            tempTask.setProjectName(listController.getUserInput("Enter Project Name"));
            tempTask.setTaskName(listController.getUserInput("Enter Task"));
            tempTask.setDueDate(listController.getDate("Enter date to be completed \"dd/MM/yyyy\""));
            if(listController.toDoList.addItem(tempTask))
                listController.notificationMessage("New task has been added");
            else
                listController.notificationMessage("Error adding task to the list");

        } catch (Exception e) {
            System.out.println("Invalid data format entered");
        }
    }

    //method to edit a given list item, called by user menu option
    private boolean editListItem(int listItemNum) {
        Task tempTask = new Task();
        Task tempInTask;
        try {
            tempInTask = (Task) listController.toDoList.getItem(listItemNum - 1);
            tempTask.setProjectName(listController.getUserInput("Update Project Name (" + tempInTask.getProjectName() + ")"));
            tempTask.setTaskName(listController.getUserInput("Update Task (" + tempInTask.getTaskName() + ")"));
            tempTask.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Update Task date \"dd/MM/yyyy\" (" + tempInTask.getDueDate() + ")")));
            listController.toDoList.editItem(listItemNum, tempTask);
        } catch (Exception e) {
            System.out.println("Invalid data format entered!!!");
        }
        return true;
    }

    //method to remove a task from the task list, called by user menu option
    private void removeListItem(int position) {
        listController.printList(listController.toDoList.getListItems());
        if (position > 0 && position <= listController.toDoList.listCount()) {
            if (listController.toDoList.removeItem(position - 1)) {
                listController.notificationMessage("Task number " + position + " removed ");
            } else {
                listController.notificationMessage("Task number " + position + " not removed ");
            }
        } else
            System.out.println("Number entered not in range \n" + "##############################");
    }

    //method to mark a given task to done status, called by user menu option
    private boolean markListItemDone(int listItemNum) {
        try {
            Task tempTask;
            tempTask = (Task) listController.toDoList.getItem(listItemNum - 1);
            tempTask.setStatus(STATUS_DONE);
            listController.toDoList.editItem(listItemNum, tempTask);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //method to mark a given task to pending status, called by user menu option
    private boolean markListItemPending(int listItemNum) {
        try {
            Task tempTask;
            tempTask = (Task) listController.toDoList.getItem(listItemNum - 1);
            tempTask.setStatus(Constants.STATUS_PENDING);
            listController.toDoList.editItem(listItemNum, tempTask);
            return true;
        } catch (Exception e) {
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

    //method to print user menu options
    @Override
    public void userMenu() {
        System.out.print("\n (1) Show Menu\n " +
                "(2)  Add a task\n " +
                "(3)  Remove a task\n " +
                "(4)  Edit a task\n " +
                "(5)  Show All tasks\n " +
                "(6)  Mark a task completed\n " +
                "(7)  Mark a task not completed\n " +
                "(8)  Save current tasks\n " +
                "(9)  Sort tasks by project\n " +
                "(10) Sort tasks by date\n " +
                "(0|Q|q) Quit\n ");
    }

    //method to print array list with text formatting
    @Override
    public void printList(ArrayList<E> arrayList) {
        int listNumber = 1;
        System.out.println("*****************************************************************************");
        System.out.printf("%-2s %-15s %-15s %-10s %-30s", "TASK#", "PROJECT NAME", "DUE DATE", "STATUS", "TASK NAME");
        System.out.print("\n");
        System.out.println("*****************************************************************************");
        System.out.print("\n");

        ArrayList<Task> myList = (ArrayList<Task>) listController.toDoList.getListItems();
        IntStream.range(0, myList.size())
                .forEach(idx ->
                        System.out.format("%-5s %-15s %-15s %-10s %-30s\n", (idx + 1),
                                myList.get(idx).getProjectName(), myList.get(idx).getDueDate(),
                                myList.get(idx).getStatusString(), myList.get(idx).getTaskName())

                );
    }

    //method to sort the task  list by project name
    @Override
    protected void sortTaskByProject() {
        // sort by project name
        listController.toDoList.getListItems().sort(Comparator.comparing(Task::getProjectName));
    }

    //method to sort the task list by task date
    @Override
    public void sortTaskByDate() {
        listController.toDoList.getListItems().sort(Comparator.comparing(Task::getDueDate));
    }

    //method to get the number of tasks exists in the current task list
    public int getNumItemsInList(Constants status) {
        ArrayList<Task> myList = (ArrayList<Task>) listController.toDoList.getListItems();

        int doneTask = (int) myList
                .stream()
                .filter(task -> task.getStatus().equals(status))
                .count();

        return doneTask;
    }
}
