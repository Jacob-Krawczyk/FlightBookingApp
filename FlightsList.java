import java.util.ArrayList;
import java.util.UUID;

/**
 * A Singleton Listing of Flights
 * @author JavaFine
 */
public class FlightsList {
    private FlightDatabaseLoader flightLoader;
    private FlightDatabaseWriter flightWriter;
    private ArrayList<Flight> flights;
    private ArrayList<Flight> returnList;
    private static FlightsList flightList;

    /**
     * Returns instance of flights list
     * @return flights list
     */
    public static FlightsList getInstance() {
        if(flightList == null) {
            flightList = new FlightsList();
        }
        return flightList;
    }
public Flight getFlightByUUID(UUID id) {
    for (Flight flight: flights) {
        if (flight.getID().equals(id))
            return flight;
    }
    return null;
}
    /**
     * Returns list of all flights
     * @return all flights
     */
    public ArrayList<Flight> getAllFlights() {
        flights = flightLoader.getFlight();
        return flights;
    }

    /**
     * Clears search array list
     */
    public void clearSearch() {
        returnList.clear();
    }

    /**
     * Adds flights based on destination inputted by user
     */
    public void getFlightByDestination(String destination) {
        for(Flight flight: flights) {
            if(flight.getDestination().equals(destination)) {
                returnList.add(flight);
            }
        }
    }

    /**
     * Removes flights if they don't match airline
     */
    public void getFlightByAirline(String airline) {
        if(!airline.equals("none")) {
            for(Flight search: flights) {
                if(!search.getAirline.equals(airline)) {
                    returnList.remove(search);
                }
            }
        }
    }
}
