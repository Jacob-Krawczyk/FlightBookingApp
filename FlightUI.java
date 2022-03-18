import java.util.*;

/**
 * User Interface for Flight Application 
 * @author JavaFine
 */
public class FlightUI {
    static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Flight Booking App!");
        
    }
    public int initialDisplay {
        System.out.println("1. Login\n2. Create Account\n3. Search Flights\n4. Search Hotels\n5. Quit\n\nWhat would you like to do:");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        return response;
    }
    public void printActionsPage() {
        System.out.println("Actions Page\n1. Search Flight\n2. Search Hotel\n3. Look at Itinerary\n4. Go to Friend's List\n5. Preferences\n\nWhat would you like to do: ");
        int reponse = keyboard.nextLine();
    }
}
