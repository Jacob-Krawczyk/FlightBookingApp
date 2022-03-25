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
<<<<<<< HEAD
=======
        this.amenities = amenities;
        this.accessibilities = accessibilities;
        this.roomType = roomType;
        this.typeOfBeds = typeOfBeds;
        this.numOfBeds = numOfBeds;
        this.checkOutDay = checkOutDay;
        this.checkInDay = checkInDay;
        this.checkInTime = checkInTime;
>>>>>>> c82a0c812262b5842a12412c5a799e2205b2d6dc
    }

    public ArrayList<Amenities> getAmenities() {
        return this.amenities;
    }

    public String getLocation() {
        return this.city;
    }

<<<<<<< HEAD
=======
    public int getnumOfBeds() {
        return this.numOfBeds;
    }

    public String getRoomType() {
        return this.roomType;
    }

>>>>>>> c82a0c812262b5842a12412c5a799e2205b2d6dc
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
    
    
}
