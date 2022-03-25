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
    private String typeOfBeds;
    private int numOfBeds;
    private String checkOutDay;
    private String checkInDay;
    private String checkInTime;
    private String checkOutTime;
    private String pricePerNight;
    private String totalPrice;

    // public Hotel (UUID id, String city, String hotel_name,  ArrayList<Room> rooms ){
    //     this.id = id;
    //     this.city = city;
    //     this.name = hotel_name;
    //     this.rooms = rooms;
        
    // }

    public Hotel(UUID id, String name, String city, ArrayList<Room> rooms, ArrayList<Amenities> amenities,
            ArrayList<Accessibility> accessibilities, String roomType, String typeOfBeds, int numOfBeds,
            String checkOutDay, String checkInDay, String checkInTime) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    public ArrayList<Amenities> getAmenities() {
        return this.amenities;
    }

    public String getLocation() {
        return this.city;
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

    public Object getID() {
        return this.id;
    }
    public String getHotelName()
    {
        return this.name;
    }
    public ArrayList<Room> getHotelRooms() {
        return this.getHotelRooms();
      }

    public Object getRoomType() {
        return this.getRoomType();
    }

    public int getnumOfBeds() {
        return this.getnumOfBeds();
    }
    
    
}
