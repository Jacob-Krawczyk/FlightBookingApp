import java.util.ArrayList;

public class Preferences {
    private ArrayList<String> airline;
    private ArrayList<String> flightClass;

    public Preferences(ArrayList<String> airline, ArrayList<String> flightClass) {
        this.airline = airline;
        this.flightClass = flightClass;
    }
    public ArrayList<String> getAirline() {
        return airline;
    }
    public ArrayList<String> getFlightClass() {
        return flightClass;
    }
}
