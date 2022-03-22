/**
 * Flight Application
 * @author JavaFine
 */
import java.util.ArrayList;

public class FlightBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Seat> seats;
    private Flight flights;
    public FlightBooking(ArrayList<Profile> travelers, ArrayList<Seat> seats, Flight flights) {
        this.travelers = travelers;
        this.seats = seats;
        this.flights = flights;
    }
}
