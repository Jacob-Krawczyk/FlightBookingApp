/**
 * Registered Users
 * @author JavaFine
 */
public class RegisteredUser implements User {
    private Profile userProfile;
    private String username;
    private String password;
    private ArrayList<FlightBooking> flightBookings = new ArrayList<FightBooking>();
    private ArrayList<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();
    private ArrayList<Profile> friendList = new ArrayList<Profile>();

    public RegisteredUser(Profile user, String username, String password) {
        this.user = userProfile;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPreferences() {

    }
    public void accessTicketInfo() {
        
    }
    private boolean ofAge() {
        return age;

    }
    public void addFlyer(ArrayList<Profile>) {

    }
    public void addNonUserFriend(Profile friend) {

    }
    public void addUserFriend() {
        System.out.println("Added friend");

    }
    public void removeFriend() {
        System.out.println("Removed friend");

    }
    public void accessItinerary(ArrayList<FlightBooking> flightBookings, ArrayList<HotelBooking> hotelBookings) {
        

    }
}
