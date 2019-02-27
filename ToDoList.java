import java.util.ArrayList;

public class ToDoList implements  List {
    ArrayList<ListItem> listItems = new ArrayList<>();
    String listDescription = "";

    @Override
    public boolean addItem(ListItem listItem) {
        listItems.add(listItem);
        return false;
    }

    @Override
    public boolean removeItem(int position) {
        try {
            listItems.remove(position);
            return true;
        }catch (Exception e) {
            return false;
        }

    }

    @Override
    public ListItem editItem(int position) {
        return null;
    }

    @Override
    public ListItem getItem(int position) {
        return null;
    }

    @Override
    public int listCount() {
        return listItems.size();
    }
}
