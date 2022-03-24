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
            printActionsPage();
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            printLogin(currentUser);
        }
    }
    public void printActionsPage(RegisteredUser currentUser) {
        try {
            System.out.println("Welcome, " + currentUser.getUsername().toString()
                    + "!\n\n1. Search Flight\n2. Search Hotel\n3. Look at Itinerary\n4. Go to Friend's List\n5. Preferences\n\nType the number corresponding to what you wuold like to do: ");
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
                    printPreferences();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e + "\nTry Again.");
            printActionsPage();
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
            printCreateUsername();
            printCreatePassword();
            app.addUser();
            System.out.println("Account creation successful!");
            printSetPref();
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            printCreateAccount();
        }
    }
    public void printCreateUsername() {
        try {
            System.out.println("Username: ");
            String username = keyboard.nextLine();
            if (!app.checkValidityOfUsername(username)) {
                System.out.println("Sorry! This username is already taken. Try again.");
                printCreateUsername();
            }
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            printCreateUsername();
        }
    }
    public void printCreatePassword() {
        try {
            System.out.println("Password: ");
            String password = keyboard.nextLine();
            System.out.println("Retype Password: ");
            String passwordCheck = keyboard.nextLine();
            if (!password.equals(passwordCheck)) {
                System.out.println("These passwords don't match! Try again.");
                printCreatePassword();
            }
            printSetPrefQuestion();
        } catch (Exception e) {
            System.out.println(e + " Try again.");
            printCreatePassword();
        }
    }
    public void printSetPrefQuestion() {
        try {
            System.out.println("Do you want to set your preferences? Type \"y\" or \"no\".");
            String setPref = keyboard.nextLine();
            if (setPref.equals("y")) {
                printSetPreferences();
            } else if (setPref.equals("n")) {
                printActionsPage();
            } else {
                System.out.println("Invalid response. Try again.");
                printSetPreferences();
            }
        } catch (Exception e) {
            System.out.println(e +" Try again.");
            printSetPrefQuestion();
        }
    }
    public void printSetPreferences() {
        try {
            System.out.println("Setting Preferences\n\nPlease choose airlines you wish to travel with from the following list. Separate the airlines with commas");
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

            System.out.println("Preferences successfully updated!");
        } catch (Exception e) {
            System.out.println(e + " Try again");
            printSetPreferences();
        }
    }
    public void printBookingNotLogin () {
        
    }
}
