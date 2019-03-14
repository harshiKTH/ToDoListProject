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

    private ToDoList <Task>toDoList;
    private static ListItemStorageController<Task> listItemStorageController;
    private static ListController listController;


    public static void main(String args[]) throws IOException {
        listController = new ListController();
        listController.toDoList = new ToDoList();
        listItemStorageController = new ListItemStorageController();
        // assign the list objects from the file store
        listController.toDoList.setListItems(listItemStorageController.loadList());
        boolean isQuit = false;
        String userInput;

        System.out.println("\nWelcome toToDoly!!! \nYou have total of " + listController.toDoList.getListItems().size() + " and "
                + listController.getNumItemsInList(Constants.STATUS_PENDING)+ " task to do");


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
                //listController.editListItem(Integer.parseInt(listController.getUserInput("Enter item number to edit :")));
                listController.editListItem(listController.getuserInt(1,listController.toDoList.getListItems().size(),"Enter task "));
            } else if (userInput.equals("5")) { //Show all list items
                listController.printList(listController.toDoList.getListItems());
            } else if (userInput.equals("6")) { //Mark a task status to done
                listController.markListItemDone(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            } else if (userInput.equals("7")) { //Mark a task status to not done
                listController.markListItemPending(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            }
            else if (userInput.equals("8")) { //Store the list items
               if( listController.listItemStorageController.storeList(listController.toDoList.getListItems())){
                   listController.notificationMessage("To do list saved successfully ...");
               } else {
                   listController.notificationMessage("To do list saving failure due to system error...");
               }
            }
            else if (userInput.equals("9")) {//Sort task by project
                listController.sortTaskByProject();
            }
            else if (userInput.equals("10")) { //Sort task by date
                listController.sortTaskByDate();}




        }
        System.exit(0);
    }

    private void addListItem(){
    Task tempTask = new Task();
    try {
        tempTask.setProjectName(listController.getUserInput("Enter Project Name"));
        tempTask.setTaskName(listController.getUserInput("Enter Task"));
        tempTask.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Enter task date \"dd/MM/yyyy\"")));
        listController.toDoList.addItem(tempTask);
        }
    catch (Exception e) {
        System.out.println("Invalid data format entered");
        }
    }

    private boolean editListItem(int listItemNum){
        Task tempTask = new Task();
        Task tempInTask;
       try {
           tempInTask = (Task)listController.toDoList.getItem(listItemNum-1);
           tempTask.setProjectName(listController.getUserInput("Update Project Name (" + tempInTask.getProjectName() + ")"));
           tempTask.setTaskName(listController.getUserInput("Update Task (" + tempInTask.getTaskName() + ")"));
           tempTask.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Update Task date \"dd/MM/yyyy\" (" + tempInTask.getDueDate()+ ")")));
           listController.toDoList.editItem(listItemNum, tempTask);
        }
        catch (Exception e) {
            System.out.println("Invalid data format entered!!!");
        }
        return true;
    }

    private void removeListItem(){
        listController.printList(listController.toDoList.getListItems());
        int position = Integer.parseInt(listController.getUserInput("Enter list item to delete :"));
        if(position > 0 && position <= listController.toDoList.listCount())
            listController.toDoList.removeItem(position-1);
        else
            System.out.println("Number entered not in range \n" + "##############################");
    }

    private boolean markListItemDone(int listItemNum){
        try {
            Task tempTask;
            tempTask = (Task) listController.toDoList.getItem(listItemNum-1);
            tempTask.setStatus(STATUS_DONE);
            listController.toDoList.editItem(listItemNum, tempTask);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean markListItemPending(int listItemNum){
        try {
            Task tempTask;
            tempTask = (Task) listController.toDoList.getItem(listItemNum-1);
            tempTask.setStatus(Constants.STATUS_PENDING);
            listController.toDoList.editItem(listItemNum, tempTask);
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
                "(9) Sort task by project\n " +
                "(10) Sort task by date\n " +
                "(0|Q|q) Quit\n ");
    }

    @Override
    public void printList(ArrayList<E> arrayList) {
        int listNumber = 1;
        System.out.println("*****************************************************************************");
        System.out.printf("%-2s %-15s %-15s %-10s %-30s","TASK#", "PROJECT NAME", "DUE DATE", "STATUS", "TASK NAME");
        System.out.print("\n");
        System.out.println("*****************************************************************************");
        System.out.print("\n");

        ArrayList<Task> myList = (ArrayList<Task>) listController.toDoList.getListItems();
        IntStream.range(0, myList.size())
                .forEach(idx ->
                         System.out.format("%-5s %-15s %-15s %-10s %-30s\n", (idx+1),
                                 myList.get(idx).getProjectName(), myList.get(idx).getDueDate(),
                                 myList.get(idx).getStatusString(), myList.get(idx).getTaskName())

                        );
    }

    @Override
    protected void sortTaskByProject() {
        // sort by project name
        listController.toDoList.getListItems().sort(Comparator.comparing(Task::getProjectName));
    }

    @Override
    public void sortTaskByDate() {
        listController.toDoList.getListItems().sort(Comparator.comparing(Task::getDueDate));
    }

    public int getNumItemsInList(Constants status)
    {
        ArrayList<Task> myList = (ArrayList<Task>) listController.toDoList.getListItems();

       int doneTask = (int)myList
               .stream()
               .filter(task -> task.getStatus().equals(status))
               .count();

        return doneTask;
    }
}
