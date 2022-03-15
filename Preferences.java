public class Preferences {
    private double lowerPriceRange;
    private double upperPriceRange;
    private String airline;
    private String flightClass;
    private String typeOfFlight;
    private Arrayist<String> airportsToExclude;
    private String ratings;
    private ArrayList<String> preferredAirports;

    public Preferences(String airline, String class, String type, String ratings) {
        this.lowerPriceRange = 0.0;
        this.upperPriceRange = 500000.0;
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