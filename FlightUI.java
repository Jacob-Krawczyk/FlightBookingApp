import java.text.SimpleDateFormat;
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
    public static void printWelcomingPage() {
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
                    printFlightSearchNotLoggedIn();
                    break;
                case 4:
                    printHotelSearchNotLoggedIn();
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
    public static void printLogin() {
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
    public static void printActionsPage(RegisteredUser currentUser) {
        try {
            System.out.println("Welcome, " + currentUser.getUsername().toString()
                    + "!\n\n1. Search Flight\n2. Search Hotel\n3. Look at Itinerary\n4. Go to Friend's List\n5. Set Preferences\n\nType the number corresponding to what you wuold like to do: ");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            switch (response) {
                case 1:
                    printFlightSearch(currentUser);
                    break;
                case 2:
                    printHotelSearch(currentUser);
                    break;
                case 3:
                    printItinerary(currentUser);
                    break;
                case 4:
                    printFriendsList(currentUser);
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
    public static void printFlightSearchNotLoggedIn() {
        System.out.println("Where are you departing from?");
        String departLocation = keyboard.nextLine();
        System.out.println("What is your destination?");
        String destination = keyboard.nextLine();
        ArrayList<String> airline = addAirlinePref();
        System.out.println("1. Four matches (1 direct, 2 single transfers, 1 two tranfers)\n2. All matching flights\n3. Single Flights only\n4. Connecting flights only\nType the number corresponding with the search result you want: ");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        switch(response) {
            case 1:
                printFourMatchesNotLoggedIn(departLocation, destination, airline);
                break;
            case 2:
                printSingleFlightsOnlyNotLoggedIn(departLocation, destination, airline);
                break;
            case 4: 
                printConnectingFlightsOnlyNotLoggedIn(departLocation, destination, airline);
                break;
        }
    }
    public static void printFourMatchesNotLoggedIn(String departLocation, String destination, ArrayList<String> airline) {
        System.out.println("Here are four matches.");
        app.getFourMatches(departLocation, destination, airline);
        System.out.println(
                "Type the number corresponding with the flight you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        if (response == 99) {
            printWelcomingPage();
        }
        printBookingNotLogin();
    }
    public static void printSingleFlightsOnlyNotLoggedIn(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<Flight> flightSearch = printSingleFlights(departLocation, destination, airline);
        System.out.println("Type the number corresponding with the flight you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        if (response == 99) {
            printWelcomingPage();
        } 
        printBookingNotLogin();
    }
    public static void printConnectingFlightsOnlyNotLoggedIn(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<ArrayList<Flight>> flightSearch = printConnectingFlight(departLocation, destination, airline);
        System.out.println("Type the number corresponding with the connecting flight you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        if (response == 99) {
            printWelcomingPage();
        }
        printBookingNotLogin();
    }
    public static void printFlightSearch(RegisteredUser currentUser) {
        ArrayList<String> airline = currentUser.getPreferences().getAirline();
        System.out.println("Where are you departing from?");
        String departLocation = keyboard.nextLine();
        System.out.println("What is your destination?");
        String destination = keyboard.nextLine();
        System.out.println("1. Four matches (1 direct, 2 single transfers, 1 two tranfers)\n2. Single Flights only\n3. Connecting flights only\nType the number corresponding with the search result you want: ");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        switch (response) {
            case 1:
                printFourMatchesPage(currentUser, departLocation, destination, airline);
                break;
            case 2:
                printSingleFlightsPage(currentUser, departLocation, destination, airline);
                break;
            case 4:
                printConnectingFlightsPage(currentUser, departLocation, destination, airline);
                break;
        }
    }
    public static void printFourMatchesPage(RegisteredUser currentUser, String departLocation, String destination, ArrayList<String> airline) {
        System.out.println("Here are four matches.");
        app.getFourMatches(departLocation, destination, airline);
        System.out.println("Type the number corresponding with the flight you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        switch(response) {
            case 1:
                ArrayList<Flight> firstFlightSearch = app.getFirstMatch(departLocation, destination, airline);
                printBookFlight(currentUser, firstFlightSearch);
                break;
            case 2:
                ArrayList<Flight> secondFlightSearch = app.getSecondMatch(departLocation, destination, airline);
                printBookFlight(currentUser, secondFlightSearch);
                break;
            case 3:
                ArrayList<Flight> thirdFlightSearch = app.getThirdMatch(departLocation, destination, airline);
                printBookFlight(currentUser, thirdFlightSearch);
                break;
            case 4:
                ArrayList<Flight> fourthFlightSearch = app.getFourthMatch(departLocation, destination, airline);
                printBookFlight(currentUser, fourthFlightSearch);
                break;
            case 99:
                printActionsPage(currentUser);
                break;
        }
    }
    public static void printBookFlight(RegisteredUser currentUser, ArrayList<Flight> flightSearch) {
        FlightBooking flightBooking = app.createFlightBooking(currentUser, flightSearch);
        int numPeople = printAddFriendsToFlightBooking(currentUser, flightBooking);
        System.out.println("Here are all the seats available on the flight.");
        app.printAvailableSeats(flightBooking.getFlight().get(0));
        for (int i = 0; i < numPeople; i++) {
            printAddSeat(flightBooking, 0);
        }
        app.bookFlight(currentUser, flightBooking);
        System.out.println("Flight successfully booked! Returning to the actions page.");
        printActionsPage(currentUser);
    }
    public static void printSingleFlightsPage(RegisteredUser currentUser, String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<Flight> flightSearch = printSingleFlights(departLocation, destination, airline);
        System.out.println("Type the number corresponding with the flight you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        if (response == 99) {
            printActionsPage(currentUser);
        }
        printBookFlight(currentUser, flightSearch);
    }
    public static ArrayList<Flight> printSingleFlights(String departLocation, String destination, ArrayList<String> airline) {
        System.out.println("Here are all single flights that match your preferences.");
        ArrayList<Flight> flightSearch = app.getSingleFlights(departLocation, destination, airline);
        for (int i = 0; i < flightSearch.size(); i++) {
            System.out.println("Flight " + i + ": " + flightSearch.get(i).toString());
        }
        return flightSearch;
    }
    public static void printConnectingFlightsPage(RegisteredUser currentUser, String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<ArrayList<Flight>> flightSearch = printConnectingFlight(departLocation, destination, airline);
        System.out.println("Type the number corresponding with the connecting flight you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        if (response == 99) {
            printActionsPage(currentUser);
        }
        FlightBooking flightBooking = app.createFlightBooking(currentUser, flightSearch.get(response));
        int numPeople = printAddFriendsToFlightBooking(currentUser, flightBooking);
        for(int i = 0; i < flightBooking.getFlight().size(); i++) {
            System.out.println("Here are the seats that are available on flight " + i + ". Remember you need to book one seat per person.");
            app.printAvailableSeats(flightBooking.getFlight().get(i));
            for(int j = numPeople; j > 0; j--) {
                printAddSeat(flightBooking, i);
            }
        }
        app.bookFlight(currentUser, flightBooking);
        System.out.println("Flight successfully booked! Returning to the actions page.");
        printActionsPage(currentUser);
    }
    public static void printAddSeat(FlightBooking flightBooking, int num) {
        System.out.println("Type the number of the seat you wish to book.");
        String seatNum = keyboard.nextLine();
        app.addSeatsToFlightBooking(flightBooking, num, seatNum);
        System.out.println("Seat added to flight booking.");
    }
    public static ArrayList<ArrayList<Flight>> printConnectingFlight(String departLocation, String destination, ArrayList<String> airline) {
        System.out.println("Here are all the connecting flights that match your preferences.");
        ArrayList<ArrayList<Flight>> flightSearch = app.getConnectingFlights(departLocation, destination, airline);
        for (int i = 0; i < flightSearch.size(); i++) {
            System.out.println("Connecting Flight " + i + ": " + flightSearch.get(i).toString());
        }
        return flightSearch;
    }
    public static int printAddFriendsToFlightBooking(RegisteredUser currentUser, FlightBooking flightBooking) {
        System.out.println("How many people are you booking for?");
        int numPeople = keyboard.nextInt();
        if (numPeople > 1) {
            app.printFriendsList(currentUser);
            for (int i = numPeople; i > 0; i--) {
                System.out.println("What is the first name of the friend you want to book for?");
                String friendFirst = keyboard.nextLine();
                System.out.println("What is the last name of the friend you want to book for?");
                String friendLast = keyboard.nextLine();
                app.addFriendToFlightBooking(currentUser, friendFirst, friendLast, flightBooking);
                System.out.println("Friend successfully added to flight booking!");
            }
        }
        return numPeople;
    }
    public static void printHotelSearch(RegisteredUser currentUser) {
        try {
            System.out.println("Where do you want to book a hotel?");
            String location = keyboard.nextLine();
            ArrayList<Amenities> amenities = addAmenitiesPref();
            ArrayList<Accessibility> accessibility = addAccessibilityPref();
            System.out.println("What type of room do you want?");
            String roomType = keyboard.nextLine();
            System.out.println("How many beds do you want?");
            int numOfBeds = keyboard.nextInt();
            keyboard.nextLine();
            ArrayList<Hotel> hotelSearch = app.getHotelSearch(location, amenities, accessibility, roomType, numOfBeds);
            for (int i = 0; i < hotelSearch.size(); i++) {
                System.out.println("Hotel " + i + hotelSearch.get(i).toString());
            }
            System.out.println("Type the number corresponding with the hotel you wish to book or type 99 to return to the actions page.");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            if (response == 99) {
                printActionsPage(currentUser);
            }
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            travelers.add(currentUser.getProfile());
            ArrayList<Room> rooms = new ArrayList<Room>();
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotelSearch.get(response));
            System.out.println("How many people are you booking for?");
            int numPeople = keyboard.nextInt();
            keyboard.nextLine();
            if (numPeople > 1) {
                app.printFriendsList(currentUser);
                for(int i = numPeople; i > 0; i--) {
                    System.out.println("What is the first name of the friend you want to book for?");
                    String friendFirst = keyboard.nextLine();
                    System.out.println("What is the last name of the friend you want to book for?");
                    String friendLast = keyboard.nextLine();
                    app.addFriendToHotelBooking(currentUser, friendFirst, friendLast, hotelBooking);
                    System.out.println("Friend successfully added!");
                }
            }
            System.out.println("What check in day do you want for the room? Type in the format \"dd/mm/yyyy\".");
            String checkinDay = keyboard.nextLine();
            Date checkInDay = new SimpleDateFormat("dd/mm/yyyy").parse(checkinDay);
            System.out.println("What check in time do you want for the room?");
            String checkinTime = keyboard.nextLine();
            System.out.println("What check out day do you want for the room?");
            String checkoutDay = keyboard.nextLine();
            Date checkOutDay = new SimpleDateFormat("dd/mm/yyyy").parse(checkoutDay);
            System.out.println("What check out time do you want for the room?");
            String checkoutTime = keyboard.nextLine();
            System.out.println("Here are the rooms that fit that criteria.");
            app.printRooms(hotelBooking.getHotel(), checkInDay, checkinTime, checkOutDay, checkoutTime);
            System.out.println("How many rooms are you planning on booking?");
            int roomNum = keyboard.nextInt();
            keyboard.nextLine();
            for(int i = roomNum; i > 0; i--) {
                System.out.println("Type the number corresponding to the room you wish to book.");
                app.addRoomToHotelBooking(hotelBooking, roomNum);
                System.out.println("Room added to hotel booking.");
            }
            app.bookHotel(currentUser, hotelBooking);
            System.out.println("Successfully booked hotel! Returning to Actions Page.");
            printActionsPage(currentUser);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void printHotelSearchNotLoggedIn() {
        System.out.println("Where do you want to book a hotel?");
        String location = keyboard.nextLine();
        ArrayList<Amenities> amenities = addAmenitiesPref();
        ArrayList<Accessibility> accessibility = addAccessibilityPref();
        System.out.println("What type of room do you want?");
        String roomType = keyboard.nextLine();
        System.out.println("How many beds do you want?");
        int numOfBeds = keyboard.nextInt();
        keyboard.nextLine();
        ArrayList<Hotel> hotelSearch = app.getHotelSearch(location, amenities, accessibility, roomType, numOfBeds);
        for(int i = 0; i < hotelSearch.size(); i++) {
            System.out.println("Hotel " + i + hotelSearch.get(i).toString());
        }
        System.out.println("Type the number corresponding with the hotel you wish to book or type 99 to return to the actions page.");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        if(response == 99) {
            printWelcomingPage();
        }
        printBookingNotLogin();
    }
    public static ArrayList<Amenities> addAmenitiesPref() {
        System.out.println("Please choose amenities you wish the hotel to have from the following list. Write each amentity on a separate line and write \"done\" when you're done.");
        for(Amenities amenity: EnumSet.allOf(Amenities.class)) {
            System.out.println(amenity.toString());
        }
        ArrayList<Amenities> prefAmenities = new ArrayList<Amenities>();
        String amenityString = keyboard.nextLine();
        while (!amenityString.equals("done")) {
            if(!app.checkValidityOfAmenity(amenityString)) {
                System.out.println("Invalid amenity. Try again.");
            }
            Amenities amenity = Amenities.valueOf(amenityString.toUpperCase());
            prefAmenities.add(amenity);
        }
        return prefAmenities;
    }
    public static ArrayList<Accessibility> addAccessibilityPref() {
        System.out.println("Please choose accessibilities you wish the hotel to have from the following list. Write each accessibility on a separate line and write \"done\" when you're done.");
        for(Accessibility accessibility: EnumSet.allOf(Accessibility.class)) {
            System.out.println(accessibility.toString());
        }
        ArrayList<Accessibility> prefAccessibilities = new ArrayList<Accessibility>();
        String accessibilityString = keyboard.nextLine();
        while(!accessibilityString.equals("done")) {
            if(!app.CheckValidityOfAccessibility(accessibilityString)) {
                System.out.println("Invalid accessibility. Try again.");
            }
            Accessibility accessibility = Accessibility.valueOf(accessibilityString.toUpperCase());
            prefAccessibilities.add(accessibility);
        }
        return prefAccessibilities;
    }
    public static void printQuit() {
        System.out.println("Thank you for using the Flight Booking App!");
    }
    public static void printCreateAccount() {
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
            String occupation = keyboard.nextLine();
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
    public static String createUsername() {
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
    public static String createPassword() {
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
    public static void printSetPrefQuestion(RegisteredUser currentUser) {
        try {
            System.out.println("Do you want to set your preferences? Type \"y\" or \"no\".");
            String setPref = keyboard.nextLine();
            if (setPref.equals("y")) {
                printSetPreferences(currentUser);
            } else if (setPref.equals("n")) {
                printActionsPage(currentUser);
            } else {
                System.out.println("Invalid response. Try again.");
                printSetPreferences(currentUser);
            }
        } catch (Exception e) {
            System.out.println(e +" Try again.");
            printSetPrefQuestion(currentUser);
        }
    }
    public static void printSetPreferences(RegisteredUser currentUser) {
        try {
            System.out.println("Setting Preferences\n\n");
            ArrayList<String> prefAirlines = addAirlinePref();
            ArrayList<String> prefClasses = addClassPref();
            Preferences pref = new Preferences(prefAirlines, prefClasses);
            app.setPreferences(currentUser, pref);
            System.out.println("Preferences successfully updated!");
            printActionsPage(currentUser);
        } catch (Exception e) {
            System.out.println(e + " Try again");
            printSetPreferences(currentUser);
        }
    }
    public static ArrayList<String> addAirlinePref() {
        System.out.println(
                "Please choose airlines you wish to travel with from the following list. Write each preferred airline as a new line and write \"done\" when you're done.");
        for (AirlineCompany airline : EnumSet.allOf(AirlineCompany.class)) {
            System.out.println(airline.toString());
        }
        ArrayList<String> prefAirlines = new ArrayList<String>();
        String airline = keyboard.nextLine();
        while (!airline.equalsIgnoreCase("done")) {
            if(!app.checkValidityOfAirline(airline)) {
                System.out.println("Invalid airport. Try again.");
            }
            prefAirlines.add(airline);
            airline = keyboard.nextLine();
        }
        return prefAirlines;
    }
    public static ArrayList<String> addClassPref() {
        System.out.print(
                "Please choose your preferred flight class from the following list. Write each preferred class as a new line and write \"done\" when you're done.");
        for (FlightClass flightClass : EnumSet.allOf(FlightClass.class)) {
            System.out.println(flightClass.toString());
        }
        ArrayList<String> prefClasses = new ArrayList<String>();
        String prefClass = keyboard.nextLine();
        while(!prefClass.equalsIgnoreCase("done")) {
            if(!app.checkValidityOfClass(prefClass)) {
                System.out.println("Invalid class. Try again.");
            }
            prefClasses.add(prefClass);
            prefClass = keyboard.nextLine();
        }
        return prefClasses;
    }
    public static void printBookingNotLogin () {
        System.out.println("To be able to book, you must be logged in.\n1. Create Account\n2. Login\n3. Quit\nType the number corresponding with the action you wish to take.");
        int resp = keyboard.nextInt();
        keyboard.nextLine();
        switch(resp) {
            case 1:
                printCreateAccount();
                break;
            case 2:
                printLogin();
                break;
            case 3:
                printQuit();
                break;
        }
    }
    public static void printItineraryPage(RegisteredUser currentUser) {
        System.out.println("Current Itinerary");
        app.printItinerary(currentUser);
        System.out.println("1. Cancel Flight Booking\n2. Cancel Hotel Booking\n3. Print itinerary to file\n4. Return to Actions Page\nType the number corresponding to the action you wish to take: ");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        switch(response) {
            case 1: 
                printCancelFlight(currentUser);
                break;
            case 2: 
                printCancelHotel(currentUser);
                break;
            case 3:
                printItinerary(currentUser);
                break;
            case 4: 
                printActionsPage(currentUser);
                break;
        }
    }
    public static void printItinerary(RegisteredUser currentUser) {
        System.out.println("What is the name of the file you wish to print the ticketes on?");
        String title = keyboard.nextLine();
        app.writeItineraryToFile(currentUser, title);
        System.out.println("Tickets successfully printed onto file!");
        printItineraryPage(currentUser);
    }
    public static void printCancelFlight(RegisteredUser currentUser) {
        ArrayList<FlightBooking> flightBookings = app.getBookedFlights(currentUser);
        for (int i = 0; i < flightBookings.size(); i++) {
            System.out.println(i + ". " + flightBookings.get(i).toString());
        }
        System.out.println("Type the number corresponding with the flight booking you wish to cancel.");
        int cancel = keyboard.nextInt();
        keyboard.nextLine();
        app.cancelFlight(currentUser, flightBookings.get(cancel));
        System.out.println("Flight successfully canceled!");
        printItinerary(currentUser);
    }
    public static void printCancelHotel(RegisteredUser currentUser) {
        ArrayList<HotelBooking> hotelBookings = app.getBookedHotels(currentUser);
        for (int i = 0; i < hotelBookings.size(); i++) {
            System.out.println(i + ". " + hotelBookings.get(i).toString());
        }
        System.out.println("Type the number corresponding with the hotel booking you wish to cancel.");
        int cancel = keyboard.nextInt();
        keyboard.nextLine();
        app.cancelHotel(currentUser, hotelBookings.get(cancel));
        System.out.println("Hotel booking successfully canceled!");
        printItinerary(currentUser);
    }
    public static void printFriendsList(RegisteredUser currentUser) {
        System.out.println("Friends List");
        app.printFriendsList(currentUser);
        System.out.println("1. Add Non-User Friend\n2. Add User Friend\n3. Remove Friend\n4. Return to Actions Page\nType the number corresponding to the action you wish to take: ");
        int response = keyboard.nextInt();
        keyboard.nextLine();
        switch(response) {
            case 1:
                printAddNonUserFriend(currentUser);
                break;
            case 2:
                printAddUserFriend(currentUser);
                break;
            case 3:
                printRemoveFriend(currentUser);
                break;
            case 4: 
                printActionsPage(currentUser);
                break;
        }
    }
    public static void printAddNonUserFriend(RegisteredUser currentUser) {
        System.out.println("What is your friend's first name?");
        String firstName = keyboard.nextLine();
        System.out.println("What is your friend's last name?");
        String lastName = keyboard.nextLine();
        System.out.println("What is your friend's date of birth?");
        String dob = keyboard.nextLine();
        System.out.println("What discounts do your friend qualify for?");
        String discount = keyboard.nextLine();
        app.addNonUserFriend(currentUser, firstName, lastName, dob, discount);
        System.out.println("New friend successfully added!");
        printFriendsList(currentUser);
    }
    public static void printAddUserFriend(RegisteredUser currentUser) {
        System.out.println("What is the username of the user you wish to add to your friend list?");
        String username = keyboard.nextLine();
        app.addUserFriend(currentUser, username);
        System.out.println("New friend successfully added!");
    }
    public static void printRemoveFriend(RegisteredUser currentUser) {
        System.out.println("What is the first name of the person you wish to remove from your friend list?");
        String first = keyboard.nextLine();
        System.out.println("What is the last name of the pereson you wish to remove from your friend list?");
        String last = keyboard.nextLine();
        app.removeFriend(currentUser, first, last);
        System.out.println("Friend successfully removed!");
        printFriendsList(currentUser);
    }
}
