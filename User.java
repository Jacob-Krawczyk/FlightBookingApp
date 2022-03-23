import java.util.UUID;

import java.util.*;
/**
 * Users 
 * @author JavaFine
 */
public class User {
    private UUID id;
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirthday;
    private String discount;
    private ArrayList<Friend> friends;

    public User(UUID id, String userID,String password,String firstName,String lastName,String dateOfBirthday,String discount,ArrayList<Friend> friends) {
        this.id=id;
        this.userId=userID;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirthday=dateOfBirthday;
        this.discount=discount;
        this.friends=friends;
    }
    public searchFlights() {

    }
    public searchHotels() {
        
    }
}
