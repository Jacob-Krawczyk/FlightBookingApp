import java.util.*;

/**
 * Flight Application
 * @author JavaFine
 */
public class FlightApp {
    private FlightsList flightList;
    private HotelsList hotelList;
    private UserList userList;
   
    public FlightApp() {

    }

    /**
     * Returns user based on username and password
     * @param username
     * @param password
     * @return registered user
     */
    public RegisteredUser login(String username, String password) {
        try {
            return userList.getUser(username, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
    }

    /**
     * Checks validity of username
     * @return boolean
     */
    public boolean checkValidityOfUsername (String username) {
        try {
            ArrayList<RegisteredUser> users = userList.getAllUsers();
            for(RegisteredUser user: users) {
                if(username.equals(user.getUsername())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Adds RegisteredUser to User.json file 
     */
    public RegisteredUser addUser(RegisteredUser newUser) {
        try {
            userList.addUser(newUser);
            return newUser;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns list of all flights
     * @return array list of flights
     */
    public ArrayList<Flight> getAllFlights() {
        return flightList.getAllFlights();
    }

    /**
     * Prints itinerary of current userx
     * @param currentUser
     */
    public void printItinerary(RegisteredUser currentUser) {
        currentUser.accessItinerary();
    }

    /**
     * Prints friend list of current user
     * @param currentUser
     */
    public void printFriendsList(RegisteredUser currentUser) {
        ArrayList<Friend> friendsList = currentUser.getFriends();
        for(Friend friend:friendsList) {
            System.out.println(friend.toString());
        }
    }

    /**
     * Adds non-user friend to friend list
     * @param currentUser
     * @param first
     * @param last
     * @param dob
     * @param discount
     */
    public void addNonUserFriend(RegisteredUser currentUser, String first, String last, String dob, String discount) {
        Friend friend = currentUser.addNonUserFriend(first, last, dob, discount);
        userList.addFriend(friend);
    }

    /**
     * Adds user friend to friend list
     * @param currentUser
     * @param username
     */
    public void addUserFriend(RegisteredUser currentUser, String username) {
         currentUser.addUserFriend(username);
    }
   
    /**
     * Removes friend from friend list
     * @param currentUser
     * @param first
     * @param last
     */
    public void removeFriend(RegisteredUser currentUser, String first, String last) {
        currentUser.removeFriend(first,last);
        Friend friend = currentUser.getFriendByFristAndLast(first, last);
        userList.removeFriend(friend);
    }

    /**
     * Sets preferences of current user
     * @param currentUser
     * @param pref
     */
    public void setPreferences(RegisteredUser currentUser, Preferences pref) {
        currentUser.setPreferences(pref);
    }

    /**
     * Checks validity of inputted airline
     * @param airline
     * @return boolean
     */
    public boolean checkValidityOfAirline(String airline) {
        for (AirlineCompany comp : EnumSet.allOf(AirlineCompany.class)) {
            if (airline.equals(comp)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks validity of inputted class
     * @param prefClass
     * @return boolean
     */
    public boolean checkValidityOfClass(String prefClass) {
        for (FlightClass flightClass : EnumSet.allOf(FlightClass.class)) {
            if (prefClass.equals(flightClass)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks validity of accessibility inputted by user
     * @param accessibility
     * @return boolean
     */
    public boolean CheckValidityOfAccessibility(String accessibility) {
        for (Accessibility access : EnumSet.allOf(Accessibility.class)) {
            if (accessibility.equals(access)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks validity of amenity inputted by user
     * @param amenity
     * @return boolena
     */
    public boolean checkValidityOfAmenity(String amenity) {
        for (Amenities amen : EnumSet.allOf(Amenities.class)) {
            if (amenity.equals(amen)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns flight search result
     * @param destination
     * @param airline
     * @return array list of filtered flights 
     */
    public ArrayList<Flight> getFlightSearch(String destination, ArrayList<String> airline) {
        return flightList.getSearch(destination, airline);
    }

    /**
     * Returns hotel search result
     * @param location
     * @param amenities
     * @param accessibility
     * @param roomType
     * @param numOfBeds
     * @return array list of filtered hotels
     */
    public ArrayList<Hotel> getHotelSearch(String location, ArrayList<Amenities> amenities, ArrayList<Accessibility> accessibility, String roomType, int numOfBeds) {
        return hotelList.getSearch(location, amenities, accessibility, roomType, numOfBeds);
    }

    /**
     * Books hotel
     * @param currentUser
     * @param hotel
     */
    public void bookHotel(RegisteredUser currentUser, Hotel hotel) {
        currentUser.bookHotel(hotel);
    }

    /**
     * Books flight
     * @param currentUser
     * @param flight
     */
    public void bookFlight(RegisteredUser currentUser, Flight flight) {
        currentUser.bookFlight(flight);
    }

    public void printBookedHotels(RegisteredUser currentUser) {
        ArrayList<HotelBooking> hotelBookings = currentUser.getHotel();
        for(int i = 0; i < hotelBookings.size(); i++) {
            System.out.println(i + ". " + hotelBookings.get(i).toString());
        }
    }

    public void printTickets(RegisteredUser currentUser) {
        ArrayList<FlightBooking> flightList = currentUser.getFlight();
        for(FlightBooking flight: flightList) {
            
        }
        try {
            File tickets = new File("tickets.txt");
            if
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
