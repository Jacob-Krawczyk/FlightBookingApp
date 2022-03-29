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
        this.flightList = flightList.getInstance();
        this.hotelList = hotelList.getInstance();
        this.userList = userList.getInstance();

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
     * @return new RegisteredUser
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
        try {
            return flightList.getAllFlights();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Prints itinerary of current userx
     * @param currentUser
     */
    public void printItinerary(RegisteredUser currentUser) {
        try {
            userList.printItinerary(currentUser);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Prints friend list of current user
     * @param currentUser
     */
    public void printFriendsList(RegisteredUser currentUser) {
        try {
            userList.getFriendsList(currentUser);
        } catch (Exception e) {
            System.out.println(e);
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
        try {
            userList.addNonUserFriend(currentUser, first, last, dob, discount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds user friend to friend list
     * @param currentUser
     * @param username
     */
    public void addUserFriend(RegisteredUser currentUser, String username) {
        try {
            userList.addUserFriend(currentUser, username);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
    /**
     * Removes friend from friend list
     * @param currentUser
     * @param first
     * @param last
     */
    public void removeFriend(RegisteredUser currentUser, String first, String last) {
        try {
            currentUser.removeFriend(first,last);
            Friend friend = currentUser.getFriendByFristAndLast(first, last);
            userList.removeFriend(friend);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds friend to hotel booking
     * @param currentUser
     * @param first
     * @param last
     * @param hotelBooking
     */
    public void addFriendToHotelBooking(RegisteredUser currentUser, String first, String last, HotelBooking hotelBooking) {
        try {
            Friend friend = currentUser.getFriendByFristAndLast(first, last);
            hotelList.addTraveler(friend.getProfile());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds friend to flight booking
     * @param currentUser
     * @param first
     * @param last
     * @param flightBooking
     */
    public void addFriendToFlightBooking(RegisteredUser currentUser, String first, String last, FlightBooking flightBooking) {
        try {
            Friend friend = currentUser.getFriendByFristAndLast(first, last);
            flightList.addTraveler(friend.getProfile());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds room to hotel booking
     * @param hotelBooking
     * @param roomNum
     */
    public void addRoomToHotelBooking(HotelBooking hotelBooking, int roomNum) {
        try {
            Room room = hotelList.getRoom(hotelBooking.getHotel(), roomNum);
            hotelList.addRoom(room);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Creates and returns flight booking
     * @param currentUser
     * @param flightSearch
     * @return flight booking
     */
    public FlightBooking createFlightBooking(RegisteredUser currentUser, ArrayList<Flight> flightSearch) {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            travelers.add(currentUser.getProfile());
            ArrayList<Seat> seats = new ArrayList<Seat>();
            return new FlightBooking(travelers, seats, flightSearch);
        } catch (Exception e) {
            System.out.println(e); 
        }
        return null;
    }

    /**
     * Adds seats to flight booking
     * @param flightBooking
     * @param flight
     * @param seatNum
     */
    public void addSeatsToFlightBooking(FlightBooking flightBooking, int flight, String seatNum) {
        try {
            Seat seat = flightList.getSeatBySeatNumber(flightBooking.getFlight().get(flight), seatNum);
            flightList.addSeat(seat);
        } catch (Exception e) {
            System.out.println(e);
        }
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
        try {
            hotelList.printRoomByDateAndTime(hotel, checkInDate, checkinTime, checkOutDate, checkOutTime);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Prints available seats on flight
     * @param flight
     */
    public void printAvailableSeats(Flight flight) {
        try {
            flightList.getAvailableSeats(flight);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Sets preferences of current user
     * @param currentUser
     * @param pref
     */
    public void setPreferences(RegisteredUser currentUser, Preferences pref) {
        try {
            currentUser.setPreferences(pref);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Checks validity of inputted airline
     * @param airline
     * @return boolean
     */
    public boolean checkValidityOfAirline(String airline) {
        try {
            for (AirlineCompany comp : EnumSet.allOf(AirlineCompany.class)) {
                if (airline.equals(comp.toString())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    /**
     * Checks validity of inputted class
     * @param prefClass
     * @return boolean
     */
    public boolean checkValidityOfClass(String prefClass) {
        try {
            for (FlightClass flightClass : EnumSet.allOf(FlightClass.class)) {
                if (prefClass.equals(flightClass.toString())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    /**
     * Checks validity of accessibility inputted by user
     * @param accessibility
     * @return boolean
     */
    public boolean CheckValidityOfAccessibility(String accessibility) {
        try {
            for (Accessibility access : EnumSet.allOf(Accessibility.class)) {
                if (accessibility.equals(access.toString())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Checks validity of amenity inputted by user
     * @param amenity
     * @return boolean
     */
    public boolean checkValidityOfAmenity(String amenity) {
        try {
            for (Amenities amen : EnumSet.allOf(Amenities.class)) {
                if (amenity.equals(amen.toString())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Returns flight search result
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of filtered flights 
     */
    public ArrayList<Flight> getSingleFlights(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getSingles(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
    public ArrayList<Hotel> getHotelSearch(String location, ArrayList<Amenities> amenities, ArrayList<Accessibility> accessibility, String roomType, int numOfBeds, double rating) {
        try {
            return hotelList.getSearch(location, amenities, accessibility, roomType, numOfBeds, rating);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Books hotel
     * @param currentUser
     * @param hotel
     */
    public void bookHotel(RegisteredUser currentUser, HotelBooking hotel) {
        try {
            currentUser.bookHotel(hotel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Books flight
     * @param currentUser
     * @param flight
     */
    public void bookFlight(RegisteredUser currentUser, FlightBooking flight) {
        try {
            currentUser.bookFlight(flight);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns booked flights list
     * @param currentUser
     * @return array list of booked flights
     */
    public ArrayList<FlightBooking> getBookedFlights(RegisteredUser currentUser) {
        try {
            return currentUser.getFlight();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Removes flight from bookedf light list
     * @param currentUser
     * @param flight
     */
    public void cancelFlight(RegisteredUser currentUser, FlightBooking flight) {
        try {
            userList.cancelFlight(currentUser, flight);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns booked hotels list
     * @param currentUser
     * @return array list of hotel bookings
     */
    public ArrayList<HotelBooking> getBookedHotels(RegisteredUser currentUser) {
        try {
            return currentUser.getHotel();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Removes hotel from booked hotels list
     * @param currentUser
     * @param hotel
     */
    public void cancelHotel(RegisteredUser currentUser, HotelBooking hotel) {
        try {
            currentUser.cancelHotel(hotel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Writes itinerary to file user named
     * @param currentUser
     * @param title
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

    /**
     * Returns list all connecting flights
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of connecting flights
     */
    public ArrayList<ArrayList<Flight>> getConnectingFlights(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getConnectingFlights(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns four matches - 1 direct flight, 2 single transfer, 1 double transfer
     * @param departLocation
     * @param destination
     * @param airline
     * @return string of four matches 
     */
    public String getFourMatches(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getFourMatches(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns direct flight match
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of single direct flight
     */
    public ArrayList<Flight> getFirstMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            Flight flight = flightList.getFirstMatch(departLocation, destination, airline);
            ArrayList<Flight> firstMatch = new ArrayList<Flight>();
            firstMatch.add(flight);
            return firstMatch;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Hotel> getFourMatchesByLocation(String location) {
        try {
            return hotelList.getFourMatchesByLocation(location);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns all flights in first one transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights for one transfer flight
     */
    public ArrayList<Flight> getSecondMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getSecondMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns all flights in second one transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights for one transfer flight
     */
    public ArrayList<Flight> getThirdMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getThirdMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns all flights in two transflight flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights for one transfer flight
     */
    public ArrayList<Flight> getFourthMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getFourthMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
