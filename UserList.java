import java.util.*;
import java.io.*;

/**
 * A Singleton Listing of Users
 * 
 * @author JavaFine
 */
public class UserList {
  private UserDatabaseLoader userDatabaseLoader;
  private UserDatabaseWriter userDatabaseWriter;
  private ArrayList<RegisteredUser> users;
  private static UserList userList;

  /**
   * Creates and returns a single instance of UserList
   * 
   * @return UserList
   */
  public static UserList getInstance() {
    if (userList == null) {
      userList = new UserList();
    }
    return userList;
  }

  /**
   * Returns user by UUID
   * 
   * @param id
   * @return registered user
   */
  public RegisteredUser getUserByUUID(UUID id) {
    for (RegisteredUser user : users) {
      if (user.getID().equals(id))
        return user;
    }
    return null;
  }

  public void printItinerary(RegisteredUser currentUser) {
      currentUser.accessItinerary();
  }

  public void writeItineraryToFile(RegisteredUser currentUser, String title) {
      try {
          ArrayList<FlightBooking> flightList = currentUser.getFlight();
          ArrayList<HotelBooking> hotelList = currentUser.getHotel();
          PrintWriter fileWriter = new PrintWriter(new FileOutputStream(title));
          fileWriter.println("Flight Bookings");
          for (FlightBooking flight : flightList) {
              fileWriter.println(flight.toString());
          }
          fileWriter.println("Hotel Bookings");
          for (HotelBooking hotel : hotelList) {
              fileWriter.println(hotel.toString());
          }
          fileWriter.close();
      } catch (Exception e) {
          System.out.println(e);
      }

  }

  public boolean checkValidityOfUsername(String username) {
      for (RegisteredUser user : users) {
          if (username.equals(user.getUsername())) {
              return false;
          }
      }
      return true;
  }

  public void getFriendsList(RegisteredUser currentUser) {
      ArrayList<Friend> friends = currentUser.getFriends(); 
      for(Friend friend: friends) {
          System.out.println(friend.toString());
      }
  }

  public void addNonUserFriend(RegisteredUser currentUser, String firstName, String lastName, String dob, String discount) {
      currentUser.addNonUserFriend(firstName, lastName, dob, discount);
  }

  public void bookHotel(RegisteredUser currentUser, HotelBooking hotel) {
      currentUser.bookHotel(hotel);
  }

  public ArrayList<FlightBooking> getBookedFlights(RegisteredUser currentUser) {
      return currentUser.getFlight();
  }

  public ArrayList<HotelBooking> getBookedHotels(RegisteredUser currentUser) {
      return currentUser.getHotel();
  }

  public void cancelFlight(RegisteredUser currentUser, FlightBooking flight) {
      currentUser.cancelFlight(flight);
  }

  public void cancelHotel(RegisteredUser currentUser, HotelBooking hotel) {
      currentUser.cancelHotel(hotel);
  }

  public void bookFlight(RegisteredUser currentUser, FlightBooking flight) {
      currentUser.bookFlight(flight);
  }

  public void setPreferences(RegisteredUser currentUser, Preferences pref) {
      currentUser.setPreferences(pref);
  }

  public void removeFriend(RegisteredUser currentUser, String first, String last) {
      currentUser.removeFriend(first, last);
  }

  public void addUserFriend(RegisteredUser currentUser, String username) {
      currentUser.addUserFriend(username);
  }

  /**
   * Returns user by username
   * 
   * @param username
   * @return registered user
   */
  public RegisteredUser getUserByUsername(String username) {
    for (RegisteredUser user : users) {
      if (user.getUsername().equals(username)) {
        return user;
      }
    }
    return null;
  }

  /**
   * Adds user to list and to database files
   * 
   * @param user
   */
  public void addUser(RegisteredUser user) {
    users.add(user);
    // ((List<RegisteredUser>) userDatabaseWriter).add(user);
  }

  /**
   * Removes user from list and from database file
   * 
   * @param user
   */
  public void removeUser(UUID userID) {
    for (RegisteredUser user : users) {
      if (user.getID().equals(userID)) {
        int pos = this.users.indexOf(user);
        users.remove(pos);
      }
    }
    // ((List<RegisteredUser>) userDatabaseWriter).remove(user);
  }


  /**
   * Returns the list of friends associated with current user
   * 
   * @return list of friends
   */
  public ArrayList<Friend> getFriendsList() {
    return userList.getFriendsList();
  }

  /**
   * Returns user based on inputted username and password
   * 
   * @param username
   * @param password
   * @return user based on inputted username and password
   */
  public RegisteredUser getUser(String username, String password) {
    for (RegisteredUser user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return user;
      }
    }
    return null;
  }

  /*
   * public void cancelFlight(ArrayList<Flight> flights) { for(Flight flight: flights) {
   * userDatabaseWriter.removeFlight(flight); } }
   * 
   * public void bookFlight(ArrayList<Flight> flights) { for(Flight flight: flights) {
   * userDatabaseWriter.addFlight(flight); } }
   */
  /*
   * public void cancelHotel(Hotel hotel) { userDatabaseWriter.removeHotel(hotel); }
   * 
   * public void bookHotel(Hotel hotel) { userDatabaseWriter.addHotel(hotel); }
   */

  /**
   * Returns list of all registered users
   * 
   * @return list of users
   */
  public ArrayList<RegisteredUser> getAllUsers() {
    users = userDatabaseLoader.getUser();
    return users;
  }
}
