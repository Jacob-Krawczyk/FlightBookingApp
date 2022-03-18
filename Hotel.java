/**
 * Hotel Class
 * @author JavaFine
 */
public class Hotel{
    private String name;
    private String location;
    private ArrayList<Room> rooms;

    private ArrayList<Amenities> amenities;
    private ArrayList<Accessibility> accessibility;

    public Hotel (String name, String checkInDay, String checkOutDay, String location, int numberOfBeds, String roomType){
        this.name = name;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.location = location;
        this.numberOfBeds = numberOfBeds;
        this.roomType = roomType;
    }
    public void addAmenities(){

    }
    public void removeAmenities(){

    }
    public void addAccessibility(){

    }
    public void removeAccessibility(){

    }

}
