import java.util.ArrayList;

/**
 * Registered User's Preferences
 * @author JavaFine
 */
public class Preferences {
    private ArrayList<String> airline;
    private ArrayList<String> flightClass;

    /**
     * Constructs preferences 
     * @param airline
     * @param flightClass
     */
    public Preferences(ArrayList<String> airline, ArrayList<String> flightClass) {
        this.airline = airline;
        this.flightClass = flightClass;
    }

    /**
     * Returns airline preferences 
     * @return airline array list
     */
    public ArrayList<String> getAirline() {
        return airline;
    }

    /**
     * Returns flight class preferences 
     * @return flight class array list 
     */
    public ArrayList<String> getFlightClass() {
        return flightClass;
    }
}
