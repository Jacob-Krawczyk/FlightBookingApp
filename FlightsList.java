import java.util.ArrayList;
import java.util.EnumSet;
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

    public ArrayList<Flight> getSearch(String destination, ArrayList<String> airline) {
        clearSearch();
        getFlightByDestination(destination);
        getFlightByAirline(airline);
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
    public void getFlightByAirline(ArrayList<String> airline) {
        EnumSet<AirlineCompany> airlineList = EnumSet.allOf(AirlineCompany.class);
        ArrayList<String> removeList = new ArrayList<String>();
        for(AirlineCompany comp: airlineList) {
            removeList.add(comp.toString());
        }
        removeList.removeAll(airline);
        for(Flight flight: flights) {
            for(String rem: removeList) {
                if(flight.getAirline().equals(rem)) {
                    returnList.remove(flight);
                }
            }
        }
    }
}
