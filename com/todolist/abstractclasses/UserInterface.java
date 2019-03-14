package com.todolist.abstractclasses;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterface<E> {
    private Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in);

    }
    //method to get sting input from user
    public String getUserInput(String question ){
        System.out.println(question);
        return scanner.nextLine();
    }

    //method to get number input from user
    //User is requested to insert a valid number in between a range
    public  int getuserInt(int min,int max,String message)
    {
        boolean con=true;
        int ret=0;
        while(con)
        {
            System.out.println(message + "between (" + min + "-" + max + ")");
            ret =scanner.nextInt();
            if( min <= ret && max >= ret)
                    break;
        }
        return ret;
    }

    //method for clear the screen
    public abstract boolean clearScreen();

    //method to refresh the screen
    public abstract boolean updateScreen();

    //method to print user menu
    public abstract void userMenu();

    //method to print array list
    public abstract void printList(ArrayList<E> list);

    // Method to print notification to user
    public void notificationMessage(String message){
        System.out.println(message + " !!!");
    }

    //method to sort task list by project name
    protected abstract void sortTaskByProject();

    //method to sort the list by task date
    public abstract void sortTaskByDate();
}
