import java.util.ArrayList;
import java.util.UUID;

/**
 * Registered Users
 * @author JavaFine
 */
public class RegisteredUser extends User {
    private UUID id;
    private Profile userProfile;
    private String username;
    private String password;
    private Preferences pref;
    private ArrayList<FlightBooking> flightBookings;
    private ArrayList<HotelBooking> hotelBookings;
    private ArrayList<Friend> friendList;

    /**
     * Loads JSON file 
     * @param id
     * @param friendList
     * @param user
     * @param username
     * @param password
     */
    public RegisteredUser(UUID id, ArrayList<Friend> friendList, Profile user, String username, String password) {
        this.id = id;
        this.friendList = friendList;
        this.userProfile = userProfile;
        this.username = username;
        this.password = password;
    }

    /**
     * Creates new registered user 
     * @param userProfile
     * @param username
     * @param password
     */ 
    public void createUser(Profile userProfile, String username, String password) {
        UUID uuid = UUID.randomUUID();
        friendList = null;
        RegisteredUser newUser = new RegisteredUser(uuid, friendList, userProfile, username, password);
    }

    /**
     * Returns username
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Returns password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns user profile
     * @return profile 
     */
    public Profile getProfile() {
        return userProfile;
    }

    /**
     * Returns friend list
     * @return friend list 
     */
    public ArrayList<Friend> getFriends() {
        return friendList;
    }

    /**
     * Sets user preferences 
     * @param pref
     */
    public void setPreferences(Preferences pref) {
        this.pref = pref;
    }

    /**
     * Returns user preferences 
     * @return preferences 
     */
    public Preferences getPreferences() {
        return pref;
    }

   
    public void bookFlight(Flight flight) {
       
    }

    
    public void CancelFlight(Flight flight) {

    }

   
    public void bookHotel(Hotel hotel) {
        hotelBookings.add(hotel);
    }

    
    public void cancelHotel(Hotel hotel) {
        hotelBookings.remove(hotel);
    }
    
    /**
     * Checks if user is of age 
     * @param age
     * @return boolean
     */
    private boolean ofAge(int age) {
        if(age >= 18) {
            return true;
        }
        System.out.println("Invalid age.");
        return false;
    }
    
    /**
     * Adds non-user friend to friends list
     * @param friend
     */
    public void addNonUserFriend(Profile friend) {
        String first = friend.getFirst();
        String last = friend.getLast();
        String dob = friend.getDOB();
        String discount = friend.getDiscount();
        Friend aFriend = new Friend(first,last,dob,discount);
        friendList.add(aFriend);
    }

    /**
     * Adds user friend to friend's list
     * @param friend
     */
    public void addUserFriend(RegisteredUser friend) {
        String first = friend.getProfile().getFirst();
        String last = friend.getProfile().getLast();
        String dob = friend.getProfile().getDOB();
        String discount = friend.getProfile().getDiscount();
        Friend aFriend = new Friend(first, last, dob, discount);
        friendList.add(aFriend);
    }

    /**
     * Removes friend from friends list
     * @param friend
     */
    public void removeFriend(Friend friend) {
        friendList.remove(friend);
    }

    /**
     * Prints itinerary 
     */
    public void accessItinerary() {
        System.out.println("Booked Flights");
        for(FlightBooking flight:flightBookings) {
            System.out.println(flight.toString());
        }
        System.out.println("Booked Hotels");
        for(HotelBooking hotel:hotelBookings) {
            System.out.println(hotel.toString());
        }
    }

    /**
     * Returns UUID
     * @return UUID
     */
    public Object getID() {
        return this.id;
    }
}
