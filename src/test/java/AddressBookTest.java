import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AddressBookTest {
    static AddressBookService addressBookService;

    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        Assertions.assertEquals(5, addressBookData.size());
    }

    @Test
    public void givenAddressBook_WhenUpdate_ShouldSyncWithDB() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        addressBookService.updateRecord("Tanmay", "ABC Colony");
        boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("Tanmay");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAddressBook_WhenRetrieved_ShouldMatchCountInGivenRange() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO, "2018-02-14", "2020-06-02");
        Assertions.assertEquals(3, addressBookData.size());
    }

    @Test
    public void givenAddressBook_WhenRetrieved_ShouldReturnCountOfCity() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        Assertions.assertEquals(1, addressBookService.readAddressBookData("count", "Nagpur"));
    }

    @Test
    public void givenAddressBookDetails_WhenAdded_ShouldSyncWithDB() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        addressBookService.addNewContact("Samay", "Raina", "QW Colony", "Pune", "Maharashtra", "517586", "8975785412", "samay@gmail.com", "2020-11-22");
        boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("Samay");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMultipleContact_WhenAdded_ShouldSyncWithDB() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        AddressBookData[] contactArray = {
                new AddressBookData("Bill", "Gates", "Mcl", "New york", "NY", "517536", "8975658741",
                        "Bill@gmail.com", "2020-11-23"),
                new AddressBookData("Elon", "Musk", "NY square", "New York", "NY", "517533", "9874563201",
                        "Elon@gmail.com", "2020-11-23") };
        addressBookService.addMultipleContactsToDBUsingThreads(Arrays.asList(contactArray));
        boolean result1 = addressBookService.checkUpdatedRecordSyncWithDatabase("Bill");
        boolean result2 = addressBookService.checkUpdatedRecordSyncWithDatabase("Elon");
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);

    }
}
