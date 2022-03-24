/**
 * Preferences for the flights
 * @author JavaFine
 */
import java.util.ArrayList;

public class Preferences {
    private String airline;
    private String flightClass;
    private ArrayList<String> airportsToExclude = new ArrayList<String>();
    private String ratings;
    private ArrayList<String> preferredAirports = new ArrayList<String>();
    private String flight;
    private String type;

    public Preferences(String airline, String flight, String type, String ratings) {
        this.airline = airline;
        this.flight = flight;
        this.type = type;
        this.ratings = ratings;

    }
    public void addAirportToExclude() {

    }
    public void removeAirportToExclude() {

    }
    public void addPreferredAirport() {

    }
    public void removePreferredAirport() {
        
    }
}
