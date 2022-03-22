import java.util.ArrayList;

/**
 * A Singleton Listing of Hotels
 * @author JavaFine
 */
public class HotelsList {
    private HotelDatabaseLoader hotelLoader;
    private HotelDatabaseWriter hotelWriter;
    private ArrayList<Hotel> hotels;
    private static HotelsList hotelList;

    public static HotelsList getInstance() {
        if(hotelList == null) {
            hotelList = new hotelList();
        }
        return hotelList;
    }

    /**
     * Returns list of all hotels from database
     * @return list of all hotels from database
     */
    public ArrayList<Hotel> getAllHotels() {
        hotels = hotelLoader.getHotel();
        return hotels;
    }

    /**
     * Returns list of hotels that match location
     * @param location
     * @return array list of hotels that match location
     */
    public ArrayList<Hotel> getHotelByLocation(String location) {
        ArrayList<Hotel> returnList = new ArrayList<Hotel>();
        for(Hotel hotel:hotels) {
            String hotelLocation = (String) personJSON.get("location");
            if(hotelLocation.equals(location)) {
                returnList.add(hotel);
            }
        }
        return returnList;
    }

    /**
     * Returns list of hotels that match amenities
     * @param amenities
     * @return array list of hotels that match amenities 
     */
    public ArrayList<Hotel> getHotelByAmenities(String amenities) {
        ArrayList<Hotel> returnList = new ArrayList<Hotel>();
        for(Hotel hotel: hotels) {
            String hotelAmenities = (String) personJSON.get("amenities");
            if(hotelAmenities.equals(amenities)) {
                returnList.add(hotel);
            }
        }
        return returnList;
    }

    /**
     * Returns list of hotels that match accessibility 
     * @param accessibility
     * @return list of hotels that match accessibility
     */
    public ArrayList<Hotel> getHotelByAccessibility(String accessibility) {
        ArrayList<Hotel> returnList = new ArrayList<Hotel>();
        for(Hotel hotel: hotels) {
            String hotelAccessibility = (String) personJSON.get("accessibility");
            if(hotelAccessibility.equals(accessibility)) {
                returnList.add(hotel);
            }
        }
        return returnList;
    }
    
    /**
     * Returns list of hotels that match room type
     * @param roomType
     * @return list of hotels that match room type
     */
    public ArrayList<Hotel> getHotelByRoomType(String roomType) {
        ArrayList<Hotel> returnList = new ArrayList<Hotel>();
        for(Hotel hotel: hotels) {
            String hotelRoomType = (String) personJSON.get("room type");
            if(hotelRoomType.equals(roomType)) {
                returnList.add(hotel);
            }
        }
        return returnList;
    }

    /**
     * Returns list of hotels that match number of beds
     * @param numOfBeds
     * @return list of hotels that match number of beds 
     */
    public ArrayList<Hotel> getHotelByNumberOfBeds(int numOfBeds) {
        ArrayList<Hotel> returnList = new ArrayList<Hotel>();
        for(Hotel hotel: hotels) {
            int hotelNumOfBeds = (int) personJSON.get("number of beds");
            if(hotelNumOfBeds == numOfBeds) {
                returnList.add(hotel);
            }
        }
        return returnList;
    }
}
