import java.util.*;

/**
 * Flight Application
 * @author JavaFine
 */
public class FlightApp {
   private User currentUser;
   private UserDatabaseWriter userDatabase;
   
   public FlightApp() {

   }

   /**
    * Searches for RegisteredUser based on information inputted by user
    */
   public User login(String username, String password) {
       try {
           return UserDatabase.getUser(username, password);
       } catch (Exception e) {
           System.out.println(e);
       }
   }

   /**
    * Checks validity of username
    */
   public boolean checkValidityOfUsername (String username) {
       try {
           UserDatabaseLoader userDatabase = UserDatabaseLoader.getInstance();
           userDatabase.loadJsonFile();
           RegisteredUser users = json.entries;
           for(RegisteredUser user:users) {
               if(username.equals(user.Username)) {
                   return false;
               }
           }
           return true;
       } catch (Exception e) {
           System.out.println(e);
       }
   }

   /**
    * Adds RegisteredUser to User.json file 
    */
   public User addUser(Profile newUser) {
       userDatabaseWriter.addUser(newUser);
       }
   }

   // public Preferences addPreferences

   /**
    * Returns list of all flights 
    */
   public ArrayList<Flight> getAllFlights() {
       FlightDatabaseLoader flightDatabase = FlightDatabaseLoader.getInstance();
       flightDatabase.loadJsonFile();
       ArrayList<Flight> allFlights = new ArrayList<Flight>();
       Flight flights = json.entries;
       for(currentFlight:flights) {
           allFlights.add(currentFlight);
       }
       return allFlights;
   }

   /**
    * Returns flight based on inputted keyword
    */
   public Flight getFlight(String keyword) {

   }

   /**
    * Returns hotel based on inputted keyword
    */
   public Hotel getHotel(String keyword) {

   }
}
