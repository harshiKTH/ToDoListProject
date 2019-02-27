import java.io.Serializable;
import java.util.ArrayList;

abstract class ListStore implements Serializable {

    abstract boolean storeList(ArrayList<ListItem> listItems);
    abstract boolean loadList(ArrayList<ListItem> listItems);


}
