import java.util.ArrayList;

/**
 * Stores information for hotel booking
 * @author JavaFine
 */
public class HotelBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Room> rooms;
    private Flight flight;

    /**
     * Creates an instance of the information for hotel booking
     * @param travelers
     * @param rooms
     * @param flight
     */
    public HotelBooking(ArrayList<Profile> travelers, ArrayList<Room> rooms, Flight flight) {
        this.travelers = travelers;
        this.rooms = rooms;
        this.flight = flight;
    }
}