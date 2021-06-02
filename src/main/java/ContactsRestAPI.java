import java.util.ArrayList;
import java.util.List;

public class ContactsRestAPI {

    List<Contacts> dataList;
    public ContactsRestAPI(List<Contacts> dataList) {
        this.dataList = new ArrayList<>(dataList);
    }

    public long countEntries() {
        return this.dataList.size();
    }

    public void addContact(Contacts contactsData) {
        this.dataList.add(contactsData);
    }
}