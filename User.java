import java.util.*;
/**
 * Users 
 * @author JavaFine
 */
public abstract class User {
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
    public User(UUID id2, String userID2, String password2, String firstName2, String lastName2, String dateOfBirthday2,
            String discount2, ArrayList<Friend> friendList, Profile user, String username, String password3) {
    }
    public User(UUID id2, String password2, String firstName2, String lastName2, String dateOfBirthday2,
            String discount2, ArrayList<Friend> friendList, Profile user, String username, String password3) {
    }
    public void searchFlights() {
        return;
    }
    public void searchHotels() {
        return;
    }
    public Object getID() {
        return this.id;
    }
}
