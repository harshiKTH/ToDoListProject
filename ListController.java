import java.io.IOException;
import java.text.ParseException;
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
        listController.toDoList.setListItems(listItemStorageController.loadList());
        boolean isQuit = false;
        String userInput;

        System.out.println("\nYou have total " + listController.toDoList.listCount()+ " task to do");


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
                listController.editItem(Integer.parseInt(listController.getUserInput("Enter item number to edit :")));
            } else if (userInput.equals("5")) { //Show all list items
                listController.printList(listController.toDoList.getListItems());
            } else if (userInput.equals("6")) { //Mark a task status to done
                listController.markTaskDone(Integer.parseInt(listController.getUserInput("Enter the task number :")));
            } else if (userInput.equals("7")) { //Store the list items
                listController.listItemStorageController.storeList(listController.toDoList.getListItems());
        }


        }
    }

    private void addListItem(){
    ListItem tempListItem = new ListItem();
    try {
        tempListItem.setTask(listController.getUserInput("Enter Task"));
        tempListItem.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Enter task date \"dd/MM/yyyy\"")));
        listController.toDoList.addItem(tempListItem);
        }
    catch (ParseException e) {
        e.printStackTrace();
        }
    }

    private boolean editItem(int editItemNum){
        ListItem tempListItem = new ListItem();
       try {
           tempListItem.setTask(listController.getUserInput("Update Task (" + listController.toDoList.getListItems().get(editItemNum-1).getTask() + ")"));
           tempListItem.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(listController.getUserInput("Update Task date \"dd/MM/yyyy\" (" + listController.toDoList.getListItems().get(editItemNum-1).getDueDate()+ ")")));
           listController.toDoList.getListItems().set(editItemNum-1,tempListItem);
        }
        catch (Exception e) {
            e.printStackTrace();
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

    private boolean markTaskDone(int taskNumber){
        try {
            ArrayList<ListItem> tmpList=listController.toDoList.getListItems();
            tmpList.get(taskNumber-1).setStatus(Constants.STATUS_DONE);
            listController.toDoList.setListItems(tmpList);

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
                "(7) Save Current List\n " +
                "(0|Q|q) Quit\n ");
    }

    @Override
    public void printList(ArrayList<ListItem> arrayList) {
        int listNumber = 1;
        System.out.println("*****************************************************************************");
        System.out.printf("%-2s %-30s %-10s %-30s","TASK#", "DUE DATE", "STATUS", "TASK NAME");
        System.out.print("\n");
        System.out.println("*****************************************************************************");
        System.out.print("\n");
        for (ListItem listItem : arrayList) {
            //System.out.println( "(" + listNumber++ + ")"+  "\tTask Name : " + listItem.getTask() + "\tDue Date : " +listItem.getDueDate() + "\tStatus : " +listItem.getStatus());
            System.out.printf("%-5s %-30s %-10s %-30s", listNumber++, listItem.getDueDate(),listItem.getStatus(), listItem.getTask() + "\n");
            System.out.print("\n");
        }
        System.out.println();

    }
}
