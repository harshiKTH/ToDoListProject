import java.io.*;
import java.net.URL;
import java.util.ArrayList;

abstract class ListItemsStorage implements Serializable {

    abstract boolean storeList(ArrayList<ListItem> listItems);
    abstract ArrayList<ListItem> loadList();


}
