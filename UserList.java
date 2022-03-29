import java.util.ArrayList;
import java.util.UUID;

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
