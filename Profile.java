/**
 * A Profile 
 * @author JavaFine
 */
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

    /**
     * Constructs profile
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param dateOfBirth
     * @param emailAddress
     * @param phoneNumber
     * @param disability
     * @param visa
     * @param occupation
     * @param discount
     */
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

    /**
     * Returns first name
     * @return first name
     */
    public String getFirst() {
        return firstName;
    }

    /**
     * Returns last name
     * @return last name
     */
    public String getLast() {
        return lastName;
    }

    /**
     * Returns date of birth
     * @return date of birth
     */
    public String getDOB() {
        return dateOfBirth;
    }

    /**
     * Returns discount
     * @return discount 
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Returns visa
     * @return visa
     */
    public String getVisa() {
        return visa;
    }

    /**
     * Returns occupation
     * @return occupation
     */
    public String getOccupation() {
        return occupation;
    }
}
