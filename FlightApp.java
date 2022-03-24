import java.util.*;

/**
 * Flight Application
 * @author JavaFine
 */
public class FlightApp {
    private User currentUser;
    private FlightsList flightList;
    private HotelsList hotelList;
    private UserList userList;
   
    public FlightApp() {

    }

    /**
     * Searches for RegisteredUser based on information inputted by user
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
        userDatabaseWriter.addUser(newUser);
        userList.addUser(newUser);
        return newUser;
    }

    /**
     * Returns list of all flights 
     */
    public ArrayList<Flight> getAllFlights() {
        return flightList.getAllFlights();
    }

   /**
    * Returns flight based on inputted keyword
    */
   public Flight getFlight(String keyword) {
    return null;

   }

   /**
    * Returns hotel based on inputted keyword
    */
   public Hotel getHotel(String keyword) {
    return null;

   }
}
