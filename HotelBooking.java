/**
 * Hotel Booking
 * @author JavaFine
 */
import java.util.ArrayList;

public class HotelBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Room> rooms;
    private Flight flight;
    public HotelBooking(ArrayList<Profile> travelers, ArrayList<Room> rooms, Flight flight) {
        this.travelers = travelers;
        this.rooms = rooms;
        this.flight = flight;
    }
    
}