package com.todolist.abstractclasses;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterface<E> {
    private Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in);

    }
    public String getUserInput(String question ){
        System.out.println(question);
        return scanner.nextLine();
    }

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

    // UserInterface.getUserInput

    public abstract boolean clearScreen();

    public abstract boolean updateScreen();

    public abstract void userMenu();

    public abstract void printList(ArrayList<E> list);

    public void notificationMessage(String message){
        System.out.println(message);
    }


    protected abstract void sortTaskByProject();

    public abstract void sortTaskByDate();
}
