import java.util.ArrayList;

/**
 * A Singleton Listing of Flights
 * @author JavaFine
 */
public class FlightsList {
    private FlightDatabaseLoader flightLoader;
    private FlightDatabaseWriter flightWriter;
    private ArrayList<Flight> flights;
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

    /**
     * Returns list of all flights
     * @return all flights
     */
    public ArrayList<Flight> getAllFlights() {
        flights = flightLoader.getFlight();
        return flights;
    }

    /**
     * Returns list of flights based on destination inputted by user 
     * @return list of flights based on destination
     */
    public ArrayList<Flight> getFlightByDestination(String destination) {
        ArrayList<Flight> returnList = new ArrayList<Flight>();
        for(Flight flight: flights) {
            String flightDestination = (String) personJSON.get("destination");
            if(flightDestination.equals(destination)) {
                returnList.add(flight);
            }
        }
        return returnList;
    }

    /**
     * Returns list of flights based on airline
     * @return list of flights based on airline
     */
    public ArrayList<Flight> getFlightByAirline(String airline) {
        ArrayList<Flight> returnList = new ArrayList<Flight>();
        for(Flight flight:flights) {
            String flightAirline = (String) personJSON.get("Airline");
            if(flightAirline.equals(airline)) {
                returnList.add(flight);
            }
        }
        return returnList;
    }
}
