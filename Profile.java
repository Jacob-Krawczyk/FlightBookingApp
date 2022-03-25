/**
 * Flight Application
 * @author JavaFine
 */
import java.util.ArrayList;

public class Profile {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String dateOfBirth;
    private String emailAddress;
    private String phoneNumber;
    private String disability;
    private String visa;
    private String occupation;
    private String discount;

    public Profile(String firstName, String lastName, String address, String city, String state, String zip,
            String dateOfBirth, String emailAddress, String phoneNumber, String disability, String visa,
            String occupation, String discount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.disability = disability;
        this.visa = visa;
        this.occupation = occupation;
        this.discount = discount;
    }
    public String getFirst() {
        return firstName;
    }
    public String getLast() {
        return lastName;
    }
    public String getDOB() {
        return dateOfBirth;
    }
    public String getDiscount() {
        return discount;
    }
    public String getVisa() {
        return visa;
    }
    public String getOccupation() {
        return occupation;
    }
}
