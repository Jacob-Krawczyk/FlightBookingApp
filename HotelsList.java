import java.util.ArrayList;
import java.util.UUID;

/**
 * A Singleton Listing of Hotels
 * @author JavaFine
 */
public class HotelsList {
    private HotelDatabaseLoader hotelLoader;
    private HotelDatabaseWriter hotelWriter;
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
        hotels = hotelLoader.getHotel();
        return hotels;
    }
    public Hotel getHotelByUUID(UUID id) {
        for (Hotel hotel: hotels) {
            if (hotel.getID().equals(id))
                return hotel;
        }
        return null;
    }

    public ArrayList<Hotel> getSearch(String location, String amenities, String accessibility, String roomType, int numOfBeds) {
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
    private void getHotelByAmenities(String amenities) {
        if(!amenities.equals("none")) {
            for(Hotel search:returnList) {
                if(!search.getAmenities().equals(amenities)) {
                    returnList.remove(search);
                }
            }
        }
    }

    /**
     * Removes hotels that don't match accessibility
     * @param accessibility
     */
    private void getHotelByAccessibility(ArrayList<Accessibility> accessibility) {
        if(!accessibility.equals("none")) {
            for(Hotel search: returnList) {
                if(!search.getAccessibility().containsAll(accessibility)) {
                    returnList.remove(search);
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
                if(search.getNumOfBed() != numOfBeds) {
                    returnList.remove(search);
                }
            }
        }
    }
}
