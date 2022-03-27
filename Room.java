import java.util.ArrayList;
import java.util.Date;

/**
 * A Room
 * @author JavaFine
 */
public class Room {
    private String numberOfBeds;
    private String roomType;
    private String checkInDay;
    private String checkOutDay;
    private String checkInTime;
    private String checkOutTime;
    
    /**
     * Constructs a room
     * @param room_type
     * @param number_of_beds
     * @param check_in_date
     * @param check_out_date
     * @param check_in_time
     * @param check_out_time
     */
    public Room(String room_type,String number_of_beds,String check_in_date,String check_out_date,
    String check_in_time, String check_out_time) {
        this.numberOfBeds = number_of_beds;
        this.roomType = room_type;
        this.checkInDay = check_in_date;
        this.checkOutDay = check_out_date;
        this.checkInTime=check_in_time;
        this.checkOutTime=check_out_time;
    }

    /**
     * Returns room type
     * @return room type
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Returns room check in date
     * @return room check in date
     */
    public String getRoomCheckInDate() {
        return this.checkInDay;
    }

    /**
     * Returns room check in time
     * @return room check in time
     */
    public String getRoomCheckInTime() {
        return this.checkInTime;
    }

    /**
     * Returns room check out date 
     * @return room check out date 
     */
    public String getRoomCheckOutDate() {
        return this.checkOutDay;
    }

    /**
     * Returns room check out time 
     * @return room check out time
     */
    public String getRoomCheckOutTime() {
        return this.checkOutTime;
    }

    /**
     * Returns number of beds 
     * @return number of beds 
     */
    public String getRoomNumberOfBeds() {
        return this.numberOfBeds;
    }   
}
