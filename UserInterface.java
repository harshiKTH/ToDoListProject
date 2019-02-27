import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterface {
    private Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in);

    }
    public String getUserInput(String question ){
        System.out.println(question);
        return scanner.nextLine();
    }

    public abstract boolean clearScreen();

    public abstract boolean updateScreen();

    public abstract void userMenu();

    public abstract void printList(ArrayList<ListItem> list);




}
