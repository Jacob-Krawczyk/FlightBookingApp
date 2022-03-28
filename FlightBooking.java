import java.util.ArrayList;

/**
 * Stores information for flight booking
 * @author JavaFine
 */
public class FlightBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Seat> seats;
    private Flight flights;

    /**
     * Constructs an instance of the information for flight booking
     * @param travelers
     * @param seats
     * @param flights
     */
    public FlightBooking(ArrayList<Profile> travelers, ArrayList<Seat> seats, Flight flights) {
        this.travelers = travelers;
        this.seats = seats;
        this.flights = flights;
    }

    public void addTraveler(Profile profile) {
        travelers.add(profile);
    }

    /**
     * Return the flights
     * @return
     */
    public Flight getFlight() {
        return this.flights;
    }

    /**
     * Returns the number of travelers, seats and flights.
     */
    public String toString() {
        return "Travelers: " + this.travelers + "\nSeats: " + this.seats + "\nFlights: " + this.flights;
    }
}
