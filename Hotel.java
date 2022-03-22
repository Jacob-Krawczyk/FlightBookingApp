/**
 * Hotel Class
 * @author JavaFine
 */
import java.util.ArrayList;

public class Hotel{
    private String name;
    private String location;
    private ArrayList<Room> rooms;

    private ArrayList<Amenities> amenities;
    private ArrayList<Accessibility> accessibility;
    private String roomType;
    private int numberOfBeds;
    private String checkOutDay;
    private String checkInDay;

    public Hotel (String name, String checkInDay, String checkOutDay, String location, int numberOfBeds, String roomType){
        this.name = name;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.location = location;
        this.numberOfBeds = numberOfBeds;
        this.roomType = roomType;
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
        return this.accessibility;
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
