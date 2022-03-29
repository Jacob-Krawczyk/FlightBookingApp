import java.io.*;
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
     * Adds friend to hotel booking
     * @param currentUser
     * @param first
     * @param last
     * @param hotelBooking
     */
    public void addFriendToHotelBooking(RegisteredUser currentUser, String first, String last, HotelBooking hotelBooking) {
        Friend friend = currentUser.getFriendByFristAndLast(first, last);
        hotelBooking.addTraveler(friend.getProfile());
    }

    /**
     * Adds friend to flight booking
     * @param currentUser
     * @param first
     * @param last
     * @param flightBooking
     */
    public void addFriendToFlightBooking(RegisteredUser currentUser, String first, String last, FlightBooking flightBooking) {
        Friend friend = currentUser.getFriendByFristAndLast(first, last);
        flightBooking.addTraveler(friend.getProfile());
    }

    /**
     * Adds room to hotel booking
     * @param hotelBooking
     * @param roomNum
     */
    public void addRoomToHotelBooking(HotelBooking hotelBooking, int roomNum) {
        Room room = hotelList.getRoom(hotelBooking.getHotel(), roomNum);
        hotelBooking.addRoom(room);
    }

    public FlightBooking createFlightBooking(RegisteredUser currentUser, ArrayList<Flight> flightSearch) {
        ArrayList<Profile> travelers = new ArrayList<Profile>();
        travelers.add(currentUser.getProfile());
        ArrayList<Seat> seats = new ArrayList<Seat>();
        return new FlightBooking(travelers, seats, flightSearch);
    }

    /**
     * Adds seats to flight booking
     * @param flightBooking
     * @param seatNum
     */
    public void addSeatsToFlightBooking(FlightBooking flightBooking, int flight, String seatNum) {
        Seat seat = flightList.getSeatBySeatNumber(flightBooking.getFlight().get(flight), seatNum);
        flightBooking.addSeat(seat);
    }
    
    /**
     * Prints rooms of hotel
     * @param hotel
     * @param checkInDate
     * @param checkinTime
     * @param checkOutDate
     * @param checkOutTime
     */
    public void printRooms(Hotel hotel, Date checkInDate, String checkinTime, Date checkOutDate, String checkOutTime) {
        hotelList.printRoomByDateAndTime(hotel, checkInDate, checkinTime, checkOutDate, checkOutTime);
    }

    /**
     * Prints available seats on flight
     * @param flight
     */
    public void printAvailableSeats(Flight flight) {
        flightList.getAvailableSeats(flight);
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
            if (airline.equals(comp.toString())) {
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
            if (prefClass.equals(flightClass.toString())) {
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
            if (accessibility.equals(access.toString())) {
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
            if (amenity.equals(amen.toString())) {
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
    public ArrayList<Flight> getSingleFlights(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getSingles(departLocation, destination, airline);
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
    public void bookHotel(RegisteredUser currentUser, HotelBooking hotel) {
        currentUser.bookHotel(hotel);
    }

    /**
     * Books flight
     * @param currentUser
     * @param flight
     */
    public void bookFlight(RegisteredUser currentUser, FlightBooking flight) {
        currentUser.bookFlight(flight);
    }

    /**
     * Returns booked flights list
     * @param currentUser
     * @return array list of booked flights
     */
    public ArrayList<FlightBooking> getBookedFlights(RegisteredUser currentUser) {
        return currentUser.getFlight();
    }

    /**
     * Removes flight from bookedf light list
     * @param currentUser
     * @param flight
     */
    public void cancelFlight(RegisteredUser currentUser, FlightBooking flight) {
        currentUser.CancelFlight(flight);
    }

    /**
     * Returns booked hotels list
     * @param currentUser
     * @return
     */
    public ArrayList<HotelBooking> getBookedHotels(RegisteredUser currentUser) {
        return currentUser.getHotel();
    }

    /**
     * Removes hotel from booked hotels list
     * @param currentUser
     * @param hotel
     */
    public void cancelHotel(RegisteredUser currentUser, HotelBooking hotel) {
        currentUser.cancelHotel(hotel);
    }

    /**
     * Writes itinerary to file
     * @param currentUser
     */
    public void writeItineraryToFile(RegisteredUser currentUser, String title) {
        try {
            ArrayList<FlightBooking> flightList = currentUser.getFlight();
            ArrayList<HotelBooking> hotelList = currentUser.getHotel();
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(title));
            fileWriter.println("Flight Bookings");
            for (FlightBooking flight : flightList) {
                fileWriter.println(flight.toString());
            }
            fileWriter.println("Hotel Bookings");
            for (HotelBooking hotel: hotelList) {
                fileWriter.println(hotel.toString());
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<ArrayList<Flight>> getConnectingFlights(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getConnectingFlights(departLocation, destination, airline);
    }

    public String getFourMatches(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getFourMatches(departLocation, destination, airline);
    }

    public ArrayList<Flight> getFirstMatch(String departLocation, String destination, ArrayList<String> airline) {
        Flight flight = flightList.getFirstMatch(departLocation, destination, airline);
        ArrayList<Flight> firstMatch = new ArrayList<Flight>();
        firstMatch.add(flight);
        return firstMatch;
    }

    public ArrayList<Flight> getSecondMatch(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getSecondMatch(departLocation, destination, airline);
    }

    public ArrayList<Flight> getThirdMatch(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getThirdMatch(departLocation, destination, airline);
    }

    public ArrayList<Flight> getFourthMatch(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getFourthMatch(departLocation, destination, airline);
    }
}
