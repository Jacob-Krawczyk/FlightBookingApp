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
    private ArrayList<Accessibility> accessibilities;
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

    public String getAmenities() {
        return this.amenities;
    }

    public String getLocation() {
        return this.location;
    }

    public int getNumOfBed() {
        return this.numberOfBeds;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public ArrayList<Accessibility> getAccessibility() {
        return this.accessibilities;
    }

    public void addAmenities(Amenities amenity){
        amenities.add(amenity);
    }

    public void removeAmenity(Amenities amenity){
        amenities.remove(amenity);
    }
    public void addAccessibility(Accessibility accessibility){
        accessibilities.add(accessibility);
    }
    public void removeAccessibility(Accessibility accessibility) {
        accessibilities.remove(accessibility);
    }

    
}
