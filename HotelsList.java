import java.util.ArrayList;
import java.util.EnumSet;
import java.util.UUID;

/**
 * A Singleton Listing of Hotels
 * @author JavaFine
 */
public class HotelsList {
    private HotelDatabaseLoader hotelLoader;
    private ArrayList<Hotel> hotels;
    private ArrayList<Hotel> returnList;
    private static HotelsList hotelList;

    public static HotelsList getInstance() {
        if(hotelList == null) {
            hotelList = new HotelsList();
        }
        return hotelList;
    }

    /**
     * Clears search array list
     */
    private void clearSearch() {
        returnList.clear();
    }

    /**
     * Returns list of all hotels from database
     * @return list of all hotels from database
     */
    public ArrayList<Hotel> getAllHotels() {
        hotels = HotelDatabaseLoader.getHotel();
        return hotels;
    }
    public Hotel getHotelByUUID(UUID id) {
        for (Hotel hotel: hotels) {
            if (hotel.getID().equals(id))
                return hotel;
        }
        return null;
    }

    public ArrayList<Hotel> getSearch(String location, ArrayList<Amenities> amenities, ArrayList<Accessibility> accessibility, String roomType, int numOfBeds) {
        clearSearch();
        getHotelByLocation(location);
        getHotelByAmenities(amenities);
        getHotelByAccessibility(accessibility);
        getHotelByRoomType(roomType);
        getHotelByNumberOfBeds(numOfBeds);
        return returnList;
    }

    /**
     * Adds hotels that match location to return list
     * @param location
     */
    private void getHotelByLocation(String location) {
        for(Hotel hotel:hotels) {
            String hotelLocation = hotel.getLocation();
            if(hotelLocation.equals(location)) {
                returnList.add(hotel);
            }
        }
    }

    /**
     * Removes hotels that don't match amentiies
     * @param amenities
     */
    private void getHotelByAmenities(ArrayList<Amenities> amenities) {
        EnumSet<Amenities> amenitiesList = EnumSet.allOf(Amenities.class);
        ArrayList<Amenities> removeList = new ArrayList<Amenities>();
        for(Amenities amen: amenitiesList) {
            removeList.add(amen);
        }
        removeList.removeAll(amenities);
        for(Hotel search: returnList) {
            for(Amenities rem: removeList) {
                if(search.getAmenities().equals(rem)) {
                    returnList.remove(rem);
                }
            }
        }
    }

    /**
     * Removes hotels that don't match accessibility
     * @param accessibility
     */
    private void getHotelByAccessibility(ArrayList<Accessibility> accessibility) {
        EnumSet<Accessibility> accessibilityList = EnumSet.allOf(Accessibility.class);
        ArrayList<Accessibility> removeList = new ArrayList<Accessibility>();
        for(Accessibility access: accessibilityList) {
            removeList.add(access);
        }
        removeList.removeAll(accessibility);
        for(Hotel search: returnList) {
            for(Accessibility rem: removeList) {
                if(search.getAccessibility().equals(rem)) {
                    returnList.remove(rem);
                }
            }
        }
    }
    
    /**
     * Removes hotels that don't match room type
     * @param roomType
     */
    public void getHotelByRoomType(String roomType) {
        if(!roomType.equals("none")) {
            for(Hotel search: returnList) {
                if(!search.getRoomType().equals(roomType)) {
                    returnList.remove(search);
                }
            }
        }
    }

    /**
     * Removes hotels that don't match number of beds
     * @param numOfBeds
     */
    public void getHotelByNumberOfBeds(int numOfBeds) {
        if(numOfBeds != 0) {
            for(Hotel search: returnList) {
                if(search.getnumOfBeds() == numOfBeds) {
                    returnList.add(search);
                }
                
            }
        }
    }
}
