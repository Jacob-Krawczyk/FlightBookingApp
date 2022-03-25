/**
 * Registered Users
 * @author JavaFine
 */

import java.util.ArrayList;
import java.util.UUID;
public class RegisteredUser extends User {
    private UUID id;
    private Profile userProfile;
    private String username;
    private String password;
    private Preferences pref;
    private ArrayList<FlightBooking> flightBookings;
    private ArrayList<HotelBooking> hotelBookings;
    private ArrayList<Friend> friendList;

    //loading an existing user from json
    public RegisteredUser(UUID id, String userID, String firstName, String lastName, String dateOfBirthday, String discount, ArrayList<friend> friends, Profile user, String username, String password) {
        super(id, userID, password, firstName, lastName, dateOfBirthday, discount, friends, user, username, password);
        this.userProfile = userProfile;
        this.username = username;
        this.password = password;
    }

    //creating a use
    public RegisteredUser(UUID id, String userID, String firstName, String lastName, String dateOfBirthday, String discount, ArrayList<friend> friends, Profile user, String username, String password) {
        this.id = UUID.randomUUID();
        super(id, userID, password, firstName, lastName, dateOfBirthday, discount, friends, user, username, password)
        
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
        System.out.println("Invalid age.");
        return false;
    }
    public void addFlyer(ArrayList<Profile> flyer) {

    }
    public void addNonUserFriend(Profile friend) {
        String first = friend.getFirst();
        String last = friend.getLast();
        String dob = friend.getDOB();
        String discount = friend.getDiscount();
        Friend friend = new Friend(first,last,dob,discount);
        
    }
    public void addUserFriend() {
        System.out.println("Added friend");
    }
    public void removeFriend() {
        System.out.println("Removed friend");
    }

    public void accessItinerary() {
        System.out.println("Booked Flights");
        for(FlightBooking flight:flightBookings) {
            System.out.println(flight);
        }
        System.out.println("Booked Hotels");
        for(HotelBooking hotel:hotelBookings) {
            System.out.println(hotel);
        }
    }

    public Object getID() {
        return this.id;
    }
}
