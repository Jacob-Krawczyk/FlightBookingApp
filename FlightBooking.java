/**
 * Flight Application
 * @author JavaFine
 */
import java.util.ArrayList;

public class FlightBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Seat> seats;
    private Flight flights;
    
    public void book(Flight flight, ArrayList<Seat> seats, ArrayList<Profile> travlelers) {
        this.flights = flights;
        this.seats = seats;
        this.travelers = travelers;
    }

}
