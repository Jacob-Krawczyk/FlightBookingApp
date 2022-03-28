import java.util.ArrayList;

/**
 * Stores information for hotel booking
 * @author JavaFine
 */
public class HotelBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Room> rooms;
    private Hotel hotel;

    /**
     * Creates an instance of the information for hotel booking
     * @param travelers
     * @param rooms
     * @param hotel
     */
    public HotelBooking(ArrayList<Profile> travelers, ArrayList<Room> rooms, Hotel hotel) {
        this.travelers = travelers;
        this.rooms = rooms;
        this.hotel = hotel;
    }

    public void addTraveler(Profile profile) {
        travelers.add(profile);
    }
    
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public String toString() {
        return "Guests: " + this.travelers + "\nRooms: " + this.rooms + "\nHotel: " + this.hotel;
    }
}