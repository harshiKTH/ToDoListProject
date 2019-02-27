import java.util.ArrayList;

public class ToDoList implements  List {
    private ArrayList<ListItem> listItems = new ArrayList<>();
    private String listDescription = "";

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
    public ListItem editItem(int position) {
        return null;
    }

    @Override
    public ListItem getItem(int position) {
        return null;
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

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }
}
