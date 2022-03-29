import java.util.*;

/**
 * A Singleton Listing of Users
 * @author JavaFine
 */
public class UserList {
    private UserDatabaseLoader userDatabaseLoader;
    private UserDatabaseWriter userDatabaseWriter;
    private ArrayList<RegisteredUser> users;
    private static UserList userList;

    /**
     * Creates and returns a single instance of UserList
     * @return UserList
     */
    public static UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Returns user by UUID
     * @param id
     * @return registered user 
     */
    public RegisteredUser getUserByUUID(UUID id) {
        for (RegisteredUser user: users) {
            if (user.getID().equals(id))
                return user;
        }
        return null;
    }
    
    /**
     * Returns user by username
     * @param username
     * @return registered user
     */
    public RegisteredUser getUserByUsername(String username) {
        for(RegisteredUser user: users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    /**
     * Adds user to list and to database files
     * @param user
     */
    public void addUser(RegisteredUser user) {
        users.add(user);
        ((List<RegisteredUser>) userDatabaseWriter).add(user);
    }

    /**
     * Removes user from list and from database file
     * @param user
     */
    public void removeUser(RegisteredUser user) {
        users.remove(user);
        ((List<RegisteredUser>) userDatabaseWriter).remove(user);
    }

    /**
     * Adds friend to friend list of user
     * @param friend
     */
    public void addFriend(RegisteredUser currentUser, Friend friend) {
        currentUser.addFriend(friend);
    }

    /**
     * Removes friend from friend list of user
     * @param friend
     */
    public void removeFriend(RegisteredUser currentUser, String first, String last) {
        currentUser.removeFriend(first, last);
    }

    /**
     * Prints list of friends associated with current user
     * @param currentUser
     * @return list of friends
     */
    public void getFriendsList(RegisteredUser currentUser) {
        ArrayList<Friend> friendsList = currentUser.getFriends();
        for (Friend friend : friendsList) {
            System.out.println(friend.toString());
        }
    }

    public void addNonUserFriend(RegisteredUser currentUser, String first, String last, String dob, String discount) {
        Friend friend = currentUser.addNonUserFriend(first, last, dob, discount);
        addFriend(currentUser, friend);
    }

    public void addUserFriend(RegisteredUser currentUser, String username) {
        Friend friend = currentUser.addUserFriend(username);
        addFriend(currentUser, friend);
    }

    /**
     * Returns user based on inputted username and password
     * @param username
     * @param password
     * @return user based on inputted username and password
     */
    public RegisteredUser getUser(String username, String password) {
        
        for(RegisteredUser user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Removes flight from user's flight list
     * @param flights
     */
    public void cancelFlight(RegisteredUser currentUser, FlightBooking flight) {
        currentUser.cancelFlight(flight);
    }

    /**
     * Adds flight to user's flight list
     * @param flights
     */
    public void bookFlight(RegisteredUser currentUser, FlightBooking flight) {
        currentUser.bookFlight(flight);
    }

    /**
     * Removes hotel from user's hotel list
     * @param hotel
     */
    public void cancelHotel(RegisteredUser currentUser, HotelBooking hotel) {
        currentUser.cancelHotel(hotel);
    }

    /**
     * Adds hotel to user's hotel list
     * @param hotel
     */
    public void bookHotel(RegisteredUser currentUser, HotelBooking hotel) {
        currentUser.bookHotel(hotel);
    }

    /**
     * Returns list of all registered users
     * @return list of users
     */
    public ArrayList<RegisteredUser> getAllUsers() {
        users = userDatabaseLoader.getUser();
        return users;
    }

    public void printItinerary(RegisteredUser currentUser) {
        currentUser.accessItinerary();
    }

}
