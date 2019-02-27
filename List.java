

public interface List {


    boolean addItem(ListItem listItem);
    boolean removeItem(int position);
    ListItem editItem(int position);
    ListItem getItem(int position);
    int listCount();


}
