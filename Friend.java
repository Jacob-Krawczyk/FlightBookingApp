import java.util.*;
/**
 * Flight Application
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

    public Friend(UUID Friend_ID,String Friend_FirstName,String Friend_LastName,String Friend_DateOfBirthday,String Friend_Discount,Flight friend_flight
    ,Hotel new_Room) {
       this.id=Friend_ID;
	   this.firstName=Friend_FirstName;
	   this.lastName=Friend_LastName;
	   this.dateOfBirthday=Friend_DateOfBirthday;
	   this.discount=Friend_Discount;
    }

    public void setFirstName(String name) {
        this.firstName=name;
    }

    public void setLastName(String name) {
        this.lastName=name;
    }
    public void setdateOfBirthday(String date)
    {
        this.dateOfBirthday=date;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    public String getDateOfBirthday()
    {
        return dateOfBirthday;
    }
    public String getDiscount()
    {
        return discount;
    }
 } 