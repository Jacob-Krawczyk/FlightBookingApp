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
    * Creates profile for new registered user
    */
   public Profile createAccount() {
       try {
           Profile newUser = new Profile(firstName, lastName, address, city, state, zip, dob, email, phone, mobile, disability, visa, occupation);
       } catch (Exception e) {
           System.out.println(e);
           return null;
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
    * Creates and checks validity of password
    */
   public String createPassword() {
       System.out.println("Password: ");
       String password = keyboard.nextLine();
       System.out.println("Retype Password: ");
       String passwordCheck = keyboard.nextLine();
       if (!password.equals(passwordCheck)) {
           System.out.println("These passwords don't match! Try again.");
           createPassword();
       }
       return password;
   }
   /**
    * Adds RegisteredUser to User.json file 
    */
   public User addUser(Profile newUser) {
       String username = createUsername();
       String password = createPassword();
       userDatabaseWriter.addUser(newUser);
       }
   }

   public Preferences addPreferences() {
       System.out.println("Please choose airlines you wish to travel with from the following list. Separate the airlines with commas.");
       for(String airline: EnumSet.allOf(AirlineCompany.class)) {
           System.out.println(airline.toString());
       }
       String prefAirline = keyboard.nextLine();
       ArrayList<String> prefAirlines = prefAirline.split("[,]", 0);
       System.out.print("Please choose your preferred flight class from the following list. Separate the flight classes with commas.");
       for(String class: EnumSet.allOf(FlightClass.class)) {
           System.out.println(class.toString());
       }
       String prefClass = keyboard.nextLine();
       ArrayList<String> prefClasses = prefClass.split("[,]", 0);
       System.out.print("Preferred Airports: ");
       ArrayList<String> preferredAirports = keyboard.nextLine();
       System.out.print("Airports to Exclude: ");
       ArrayList<String> excludedAirports = keyboard.nextLine();

   }
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
