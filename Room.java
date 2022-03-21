/**
 * Room class
 * @author JavaFine
 */
import java.util.ArrayList;
import java.util.Date;

public class Room {
   
    private String numberOfBeds;
    private String roomType;
    private String checkInDay;
    private String checkOutDay;
    private String checkInTime;
    private String checkOutTime;
    private String pricePerNight;
    private String totalPrice;

    public Room(String room_type,String number_of_beds,String check_in_date,String check_out_date,
    String check_in_time, String check_out_time,String price_per_night,String total_price) {
        this.numberOfBeds = number_of_beds;
        this.roomType = room_type;
        this.checkInDay = check_in_date;
        this.checkOutDay = check_out_date;
        this.checkInTime=check_in_time;
        this.checkOutTime=check_out_time;
        this.pricePerNight=price_per_night;
        this.totalPrice=total_price;
        
    }

}
