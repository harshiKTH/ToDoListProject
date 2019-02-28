import java.util.ArrayList;

public class ToDoList implements  List {
    private ArrayList<ListItem> listItems = new ArrayList<>();
    @Override
    public boolean addItem(ListItem listItem) {
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
    public ListItem editItem(int position,ListItem listItem) {
        this.listItems.set(position-1,listItem);
        return null;
    }

    @Override
    public ListItem getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public int listCount() {
        return getListItems().size();
    }

    public ArrayList<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<ListItem> listItems) {
        this.listItems=null;
        this.listItems = listItems;
    }

}
