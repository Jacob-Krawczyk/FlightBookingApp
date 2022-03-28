import java.util.ArrayList;

/**
 * Stores information for flight booking
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

    public Flight getFlight() {
        return this.flights;
    }

    public String toString() {
        return "Travelers: " + this.travelers + "\nSeats: " + this.seats + "\nFlights: " + this.flights;
    }
}
