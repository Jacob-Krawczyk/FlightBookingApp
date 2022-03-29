import java.util.*;

/**
 * A Singleton Listing of Hotels
 * @author JavaFine
 */
public class HotelsList {
    private HotelDatabaseLoader hotelLoader;
    private ArrayList<Hotel> hotels;
    private ArrayList<Hotel> returnList;
    private static HotelsList hotelList;

    /**
     * Creates a single instance of HotelsList and returns that single instance
     * @return HotelsList
     */
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

    /**
     * Returns hotel based on UUID
     * @param id
     * @return hotel
     */
    public Hotel getHotelByUUID(UUID id) {
        for (Hotel hotel: hotels) {
            if (hotel.getID().equals(id))
                return hotel;
        }
        return null;
    }

    /**
     * Returns hotel search result 
     * @param location
     * @param amenities
     * @param accessibility
     * @param roomType
     * @param numOfBeds
     * @return hotel search array list
     */
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
            ArrayList<Amenities> amenity = search.getAmenities();
            for(Amenities rem: removeList) {
                for(Amenities cur: amenity) {
                    if(cur.equals(rem)) {
                        returnList.remove(search);
                    }
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
                ArrayList<Accessibility> accessibilities = search.getAccessibility();
                for(Accessibility cur: accessibilities) {
                    if(cur.equals(rem)) {
                        returnList.remove(search);
                    }
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

    public void printRoomByDateAndTime(Hotel hotel, Date checkInDate, String checkinTime, Date checkOutDate, String checkOutTime) {
        ArrayList<Room> rooms = hotel.getHotelRooms();
        for(int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomCheckInDate().equals(checkInDate) && rooms.get(i).getRoomCheckInTime().equals(checkinTime)
                    && rooms.get(i).getRoomCheckOutDate().equals(checkOutDate)
                    && rooms.get(i).getRoomCheckOutTime().equals(checkOutTime)) {
                System.out.println(rooms.get(i).toString());
            }
        }
    }

    public Room getRoom(Hotel hotel, int roomNum) {
        ArrayList<Room> rooms = hotel.getHotelRooms();
        return rooms.get(roomNum);
    }
}
