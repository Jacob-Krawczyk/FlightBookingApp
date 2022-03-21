/**
 * Hotel Class
 * @author JavaFine
 */
import java.util.ArrayList;
import java.util.UUID;

public class Hotel{
    private UUID id; 
    private String name;
    private String city;
    private ArrayList<Room> rooms;

    private ArrayList<Amenities> amenities;
    private ArrayList<Accessibility> accessibility;
    private String roomType;
    private String numberOfBeds;
    private String checkOutDay;
    private String checkInDay;
    private String checkInTime;
    private String checkOutTime;
    private String pricePerNight;
    private String totalPrice;

    public Hotel (UUID id, String city, String hotel_name,  ArrayList rooms ){
        this.id =id;
        this.city=city;
        this.name=hotel_name;
        this.rooms=rooms;
        
    }
    public void addAmenities(){

    }
    public void removeAmenities(){

    }
    public void addAccessibility(){

    }
    public void removeAccessibility() {

    }

    
}
