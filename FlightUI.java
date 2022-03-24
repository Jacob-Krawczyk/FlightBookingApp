import java.util.*;

/**
 * User Interface for Flight Application 
 * @author JavaFine
 */
public class FlightUI {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final FlightApp app = new FlightApp();
    public static void main(String[] args) {
        printWelcomingPage();
    }
    public void printWelcomingPage() {
        try {
            System.out.println("Welcome to the Flight Booking App!\n\n1. Login\n2. Create Account\n3. Search Flights\n4. Search Hotels\n5. Quit\n\nType the number corresponding with what you want to do: ");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            switch(response) {
                case 1:
                    printLogin();
                    break;
                case 2:
                    printCreateAccount();
                    break;
                case 3:
                    printFlightSearch();
                    break;
                case 4:
                    printHotelSearch();
                    break;
                case 5:
                    printQuit();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e + "\n\nTry Again");
            printWelcomingPage();
        }
    }
    public void printLogin() {
        try {
            System.out.print("Login\n\nEnter your username: ");
            String username = keyboard.nextLine();
            System.out.print("Enter your password: ");
            String password = keyboard.nextLine();
            RegisteredUser currentUser = app.login(username, password);
            printActionsPage(currentUser);
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            printLogin();
        }
    }
    public void printActionsPage(RegisteredUser currentUser) {
        try {
            System.out.println("Welcome, " + currentUser.getUsername().toString()
                    + "!\n\n1. Search Flight\n2. Search Hotel\n3. Look at Itinerary\n4. Go to Friend's List\n5. Set Preferences\n\nType the number corresponding to what you wuold like to do: ");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            switch (response) {
                case 1:
                    printFlightSearch();
                    break;
                case 2:
                    printHotelSearch();
                    break;
                case 3:
                    printItinerary();
                    break;
                case 4:
                    printFriendsList();
                    break;
                case 5:
                    printSetPrefQuestion(currentUser);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e + "\nTry Again.");
            printActionsPage(currentUser);
        }
    }
    public void printFlightSearch() {

    }
    public void printHotelSearch() {

    }
    public void printQuit() {
        System.out.println("Thank you for using the Flight Booking App!");
    }
    public void printCreateAccount() {
        try {
            System.out.print("Please enter your information below.");
            System.out.print("First Name: ");
            String firstName = keyboard.nextLine();
            System.out.print("Last Name: ");
            String lastName = keyboard.nextLine();
            System.out.print("Address: ");
            String address = keyboard.nextLine();
            System.out.print("City: ");
            String city = keyboard.nextLine();
            System.out.print("State: ");
            String state = keyboard.nextLine();
            System.out.print("Zip: ");
            String zip = keyboard.nextLine();
            System.out.print("Date of Birth: ");
            String dob = keyboard.nextLine();
            System.out.print("Email Address: ");
            String email = keyboard.nextLine();
            System.out.print("Phone Number: ");
            String phone = keyboard.nextLine();
            System.out.print("Mobile Number: ");
            String mobile = keyboard.nextLine();
            System.out.print("Disability: ");
            String disability = keyboard.nextLine();
            System.out.print("Visa: ");
            String visa = keyboard.nextLine();
            System.out.print("Occupation: ");
            String occupaton = keyboard.nextLine();
            Profile newUser = new Profile(firstName, lastName, address, city, state, zip, dob, email, phone, mobile, disability, visa, occupation);
            String username = createUsername();
            String password = createPassword();
            RegisteredUser currentUser = new RegisteredUser(newUser, username, password);
            app.addUser(currentUser);
            System.out.println("Account creation successful!");
            printSetPrefQuestion(currentUser);
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            printCreateAccount();
        }
    }
    public String createUsername() {
        try {
            System.out.println("Username: ");
            String username = keyboard.nextLine();
            if (!app.checkValidityOfUsername(username)) {
                System.out.println("Sorry! This username is already taken. Try again.");
                createUsername();
            }
            return username;
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            createUsername();
        }
        return null;
    }
    public String createPassword() {
        try {
            System.out.println("Password: ");
            String password = keyboard.nextLine();
            System.out.println("Retype Password: ");
            String passwordCheck = keyboard.nextLine();
            if (!password.equals(passwordCheck)) {
                System.out.println("These passwords don't match! Try again.");
                createPassword();
            }
            return password;
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            createPassword();
        }
        return null;
    }
    public void printSetPrefQuestion(RegisteredUser currentUser) {
        try {
            System.out.println("Do you want to set your preferences? Type \"y\" or \"no\".");
            String setPref = keyboard.nextLine();
            if (setPref.equals("y")) {
                printSetPreferences(currentUser);
            } else if (setPref.equals("n")) {
                printActionsPage(currentUser);
            } else {
                System.out.println("Invalid response. Try again.");
                printSetPreferences();
            }
        } catch (Exception e) {
            System.out.println(e +" Try again.");
            printSetPrefQuestion(currentUser);
        }
    }
    public void printSetPreferences(RegisteredUser currentUser) {
        try {
            System.out.println("Setting Preferences\n\n");
            ArrayList<String> prefAirlines = addAirlinePref();
            ArrayList<String> prefClasses = addClassPref();
            Preferences pref = new Preferences(prefAirlines, prefClasses);
            currentUser.setPreferences(pref);
            System.out.println("Preferences successfully updated!");
            printActionsPage(currentUser);
        } catch (Exception e) {
            System.out.println(e + " Try again");
            printSetPreferences(currentUser);
        }
    }
    public ArrayList<String> addAirlinePref() {
        System.out.println(
                "Please choose airlines you wish to travel with from the following list. Write each preferred airline as a new line and write \"done\" when you're done.");
        for (AirlineCompany airline : EnumSet.allOf(AirlineCompany.class)) {
            System.out.println(airline.toString());
        }
        ArrayList<String> prefAirlines = new ArrayList<String>();
        String airline = keyboard.nextLine();
        while (!airline.equalsIgnoreCase("done")) {
            if(!validAirline(airline)) {
                System.out.println("Invalid airport. Try again.");
            }
            prefAirlines.add(airline);
            airline = keyboard.nextLine();
        }
        return prefAirlines;
    }
    public boolean validAirline(String airline) {
        for(AirlineCompany comp: EnumSet.allOf(AirlineCompany.class)) {
            if(airline.equals(comp)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<String> addClassPref() {
        System.out.print(
                "Please choose your preferred flight class from the following list. Write each preferred class as a new line and write \"done\" when you're done.");
        for (FlightClass flightClass : EnumSet.allOf(FlightClass.class)) {
            System.out.println(flightClass.toString());
        }
        ArrayList<String> prefClasses = new ArrayList<String>();
        String prefClass = keyboard.nextLine();
        while(!prefClass.equalsIgnoreCase("done")) {
            if(!validClass(prefClass)) {
                System.out.println("Invalid class. Try again.");
            }
            prefClasses.add(prefClass);
            prefClass = keyboard.nextLine();
        }
        return prefClasses;
    }
    public boolean validClass(String prefClass) {
        for(FlightClass flightClass: EnumSet.allOf(FlightClass.class)) {
            if(prefClass.equals(flightClass)) {
                return true;
            }
        }
        return false;
    }
    public void printBookingNotLogin () {
        
    }
}
