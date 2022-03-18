/**
 * Room class
 * @author JavaFine
 */
import java.util.ArrayList;
import java.util.Date;

public class Room {
    private ArrayList<Date> occupiedDates;
    private ArrayList<Date> availDates;
    private int numberOfBeds;
    private String roomType;
    private String checkInDay;
    private String checkOutDay;

    public Room(ArrayList<Date> occupiedDates, ArrayList<Date> availDates, int numberOfBeds, String roomType,
            String checkInDay, String checkOutDay) {
        this.occupiedDates = occupiedDates;
        this.availDates = availDates;
        this.numberOfBeds = numberOfBeds;
        this.roomType = roomType;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
    }
}
