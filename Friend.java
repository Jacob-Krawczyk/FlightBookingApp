import java.util.*;

/**
 * A Friend 
 * @author JavaFine
 */
public class Friend {
    private UUID id ;
	private String firstName;
	private String lastName;
	private String dateOfBirthday;
	private String discount;
    ArrayList<Flight> flights;
    ArrayList<Hotel> hotels;

    /**
     * Loads friend from JSON file
     * @param Friend_ID
     * @param Friend_FirstName
     * @param Friend_LastName
     * @param Friend_DateOfBirthday
     * @param Friend_Discount
     * @param friend_flight
     * @param new_Room
     */
    public Friend(UUID Friend_ID,String Friend_FirstName,String Friend_LastName,String Friend_DateOfBirthday,String Friend_Discount,ArrayList<Flight> friend_flight,ArrayList<Hotel> new_Hotel) {
       this.id=Friend_ID;
	   this.firstName=Friend_FirstName;
	   this.lastName=Friend_LastName;
	   this.dateOfBirthday=Friend_DateOfBirthday;
	   this.discount=Friend_Discount;
       this.flights=friend_flight;
       this.hotels=new_Hotel;
    }

    public Friend(String first, String last, String dob, String discount) {
        UUID uuid = UUID.randomUUID();
        ArrayList<Flight> emptyFlightList = new ArrayList<Flight>();
        ArrayList<Hotel> emptyHotelList = new ArrayList<Hotel>();
        Friend newFriend = new Friend(uuid, first, last, dob, discount, emptyFlightList, emptyHotelList);
    }

    /**
     * Returns first name 
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns date of birth
     * @return
     */
    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    /**
     * Returns discount
     * @return
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Returns string containing friend's information 
     * @return string
     */
    public String toString() {
        return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Date of Birth: " + this.dateOfBirthday + " Discount: " + this.discount + " Flights: " + this.flights.toString() + " Hotels: " + this.hotels.toString(); 
    }
 } 