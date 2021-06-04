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

    public Contacts getContact(String name) {
        return this.dataList.stream().filter(dataItem -> dataItem.firstName.equals(name)).findFirst().orElse(null);
    }


    public void updateContact(String name, String phonenumber) {
        Contacts contactData = this.getContact(name);
        if(contactData != null) {
            contactData.phoneNumber = phonenumber;
        }
    }
}