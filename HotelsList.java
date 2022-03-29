import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.UUID;

/**
 * A Singleton Listing of Hotels
 * 
 * @author JavaFine
 */
public class HotelsList {
  private HotelDatabaseLoader hotelLoader;
  private ArrayList<Hotel> hotels;
  private ArrayList<Hotel> returnList;
  private static HotelsList hotelList;

  /**
   * Creates a single instance of HotelsList and returns that single instance
   * 
   * @return HotelsList
   */
  public static HotelsList getInstance() {
    if (hotelList == null) {
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
   * 
   * @return list of all hotels from database
   */
  public ArrayList<Hotel> getAllHotels() {
    hotels = HotelDatabaseLoader.getHotel();
    return hotels;
  }

  /**
   * Returns hotel based on UUID
   * 
   * @param id
   * @return hotel
   */
  public Hotel getHotelByUUID(UUID id) {
    for (Hotel hotel : hotels) {
      if (hotel.getID().equals(id))
        return hotel;
    }
    return null;
  }

  public void addTraveler(RegisteredUser currentUser, String first, String last, HotelBooking hotelBooking) {
    Friend friend = currentUser.getFriendByFristAndLast(first, last);
    hotelBooking.addTraveler(friend.getProfile());
  }

  public void addRoom(HotelBooking hotelBooking, Hotel hotel, int roomNum) {
      Room room = hotel.getHotelRooms().get(roomNum);
      hotelBooking.addRoom(room);
  }

  /**
   * Returns hotel search result
   * 
   * @param location
   * @param amenities
   * @param accessibility
   * @param roomType
   * @param numOfBeds
   * @param rating
   * @return hotel search array list
   */
  public ArrayList<Hotel> getSearch(String location, ArrayList<Amenities> amenities,
      ArrayList<Accessibility> accessibility, String roomType, int numOfBeds, double rating) {
    clearSearch();
    getHotelByLocation(location);
    getHotelByAmenities(amenities);
    getHotelByAccessibility(accessibility);
    getHotelByRoomType(roomType);
    getHotelByNumberOfBeds(numOfBeds);
    getHotelByRating(rating);
    return returnList;
  }

  public ArrayList<Hotel> getFourMatchesByLocation(String location) {
      clearSearch();
      getHotelByLocation(location);
      ArrayList<Hotel> fourMatches = new ArrayList<Hotel>();
      for(int i = 0; i < 4; i++) {
          fourMatches.add(returnList.get(i));
      }
      return fourMatches;
  }

  /**
   * Adds hotels that match location to return list
   * 
   * @param location
   */
  private void getHotelByLocation(String location) {
    for (Hotel hotel : hotels) {
      String hotelLocation = hotel.getLocation();
      if (hotelLocation.equals(location)) {
        returnList.add(hotel);
      }
    }
  }

  public boolean checkValidityOfAccessibility(String accessibility) {
      for (Accessibility access : EnumSet.allOf(Accessibility.class)) {
          if (accessibility.equals(access.toString())) {
              return true;
          }
      }
      return false;
  }
  public boolean checkValidityOfAmenity(String amenity) {
      for (Amenities amen : EnumSet.allOf(Amenities.class)) {
          if (amenity.equals(amen.toString())) {
              return true;
          }
      }
      return false;
  }
  private void getHotelByRating(double rating) {
      for (Hotel hotel: hotels) {
          double hotelRating = hotel.getRating();
          if (hotelRating != rating) {
              returnList.remove(hotel);
          }
      }
  }
  /**
   * Removes hotels that don't match amentiies
   * 
   * @param amenities
   */
  private void getHotelByAmenities(ArrayList<Amenities> amenities) {
    EnumSet<Amenities> amenitiesList = EnumSet.allOf(Amenities.class);
    ArrayList<Amenities> removeList = new ArrayList<Amenities>();
    for (Amenities amen : amenitiesList) {
      removeList.add(amen);
    }
    removeList.removeAll(amenities);
    for (Hotel search : returnList) {
      ArrayList<Amenities> amenity = search.getAmenities();
      for (Amenities rem : removeList) {
        for (Amenities cur : amenity) {
          if (cur.equals(rem)) {
            returnList.remove(search);
          }
        }
      }
    }
  }

  /**
   * Removes hotels that don't match accessibility
   * 
   * @param accessibility
   */
  private void getHotelByAccessibility(ArrayList<Accessibility> accessibility) {
    EnumSet<Accessibility> accessibilityList = EnumSet.allOf(Accessibility.class);
    ArrayList<Accessibility> removeList = new ArrayList<Accessibility>();
    for (Accessibility access : accessibilityList) {
      removeList.add(access);
    }
    removeList.removeAll(accessibility);
    for (Hotel search : returnList) {
      for (Accessibility rem : removeList) {
        ArrayList<Accessibility> accessibilities = search.getAccessibility();
        for (Accessibility cur : accessibilities) {
          if (cur.equals(rem)) {
            returnList.remove(search);
          }
        }
      }
    }
  }

  /**
   * Removes hotels that don't match room type
   * 
   * @param roomType
   */
  public void getHotelByRoomType(String roomType) {
    if (!roomType.equals("none")) {
      for (Hotel search : returnList) {
        if (!search.getRoomType().equals(roomType)) {
          returnList.remove(search);
        }
      }
    }
  }

  /**
   * Removes hotels that don't match number of beds
   * 
   * @param numOfBeds
   */
  public void getHotelByNumberOfBeds(int numOfBeds) {
    if (numOfBeds != 0) {
      for (Hotel search : returnList) {
        if (search.getnumOfBeds() == numOfBeds) {
          returnList.add(search);
        }

      }
    }
  }

  public void printRoomByDateAndTime(Hotel hotel, Date checkInDate, String checkinTime,
      Date checkOutDate, String checkOutTime) {
    ArrayList<Room> rooms = hotel.getHotelRooms();
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i).getRoomCheckInDate().equals(checkInDate)
          && rooms.get(i).getRoomCheckInTime().equals(checkinTime)
          && rooms.get(i).getRoomCheckOutDate().equals(checkOutDate)
          && rooms.get(i).getRoomCheckOutTime().equals(checkOutTime)) {
        System.out.println(rooms.get(i).toString());
      }
    }
  }

  public void cancelHotel(UUID hotelID) {
    for (Hotel hotel : hotels) {
      if (hotel.getID().equals(hotelID)) {
        int pos = this.hotels.indexOf(hotel);
        hotels.remove(pos);
      }
    }
  }

  public void bookHotel(Hotel hotel) {
    hotels.add(hotel);
  }


}
