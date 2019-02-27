import java.util.ArrayList;

class FileListStore extends ListStore {
    @Override
    boolean storeList(ArrayList<ListItem> listItems) {
        return false;
    }

    @Override
    boolean loadList(ArrayList<ListItem> listItems) {
        return false;
    }
}
