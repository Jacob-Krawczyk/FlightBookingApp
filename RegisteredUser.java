import java.util.ArrayList;

/**
 * Registered Users
 * @author JavaFine
 */
import java.util.ArrayList;
import java.util.UUID;
public class RegisteredUser implements User {
    private UUID id;
    private Profile userProfile;
    private String username;
    private String password;
    private Preferences pref;
    private ArrayList<FlightBooking> flightBookings;
    private ArrayList<HotelBooking> hotelBookings;
    private ArrayList<Friend> friendList;

    public RegisteredUser(Profile user, String username, String password) {
        this.userProfile = userProfile;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<Friend> getFriends() {
        return friendList;
    }
    public void setPreferences(Preferences pref) {
        this.pref = pref;
    }
    public Preferences getPreferences() {
        return pref;
    }
    public void bookFlight() {
       
    }
    public void CancelFlight() {

    }
    public void bookHotel() {

    }
    public void cancelHotel() {

    }
    public void setPreferences() {

    }
    public void accessTicketInfo() {
        
    }
    private boolean ofAge(int age) {
        if(age >= 18) {
            return true;
        }
        else if(age <= 0) {
            System.out.println("Invalid age. Try again");
            
        }
        return false;
    }
    public void addFlyer(ArrayList<Profile> flyer) {

    }
    public void addNonUserFriend(Profile friend) {
        String first = friend.getFirst();
        String last = friend.getLast();
        String dob = friend.getDOB();
        String discount = friend.getDiscount();
        Friend newFriend = new Friend(first,last,dob,discount);
        
    }
    public void addUserFriend() {
        System.out.println("Added friend");
    }
    public void removeFriend() {
        System.out.println("Removed friend");
    }

    public ArrayList<String> accessItinerary() {
        

    }

    public Object getID() {
        return this.id;
    }
}
