import java.math.BigDecimal;

public class AddressBookData {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    BigDecimal zip;
    BigDecimal phoneNo;
    String email;

    public AddressBookData(String firstName, String lastName, String address, String city, String state, java.math.BigDecimal zip, java.math.BigDecimal phoneNo,
                           String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getZip() {
        return zip;
    }

    public void setZip(BigDecimal zip) {
        this.zip = zip;
    }

    public BigDecimal getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigDecimal phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
                + city + ", state=" + state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", email=" + email + "]";
    }
}