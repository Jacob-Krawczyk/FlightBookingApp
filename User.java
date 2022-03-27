import java.util.*;
/**
 * Users 
 * @author JavaFine
 */
public abstract class User {
    private FlightsList flightList;
    private HotelsList hotelList;

    /**
     * Returns flight search result
     * @param destination
     * @param airline
     * @return flight search array list
     */
    public ArrayList<Flight> searchFlights(String destination, ArrayList<String> airline) {
        return flightList.getSearch(destination, airline);
    }

    /**
     * Returns hotel search result
     * @param location
     * @param amenities
     * @param accessibility
     * @param roomType
     * @param numOfBeds
     * @return hotel search array list
     */
    public ArrayList<Hotel> searchHotels(String location, ArrayList<Amenities> amenities, ArrayList<Accessibility> accessibility, String roomType, int numOfBeds) {
        return hotelList.getSearch(location, amenities, accessibility, roomType, numOfBeds);
    }
}
