import java.util.ArrayList;

/**
 * A Singleton Listing of Users
 * @author JavaFine
 */
public class UserList {
    private UserDatabase userDatabaseLoader;
    private UserDatabaseWriter userDatabaseWriter;
    private ArrayList<User> users;
    private static UserList userList;

    public static UserList getInstance() {
        if(userList == null) {
            userList = new userList();
        }
        return userList;
    }

    /**
     * Adds user to list and to database files
     * @param user
     */
    public void addUser(RegisteredUser user) {
        users.add(user);
        userDatabaseWriter.add(user);
    }

    /**
     * Removes user from list and from database file
     * @param user
     */
    public void removeUser(RegisteredUser user) {
        users.remove(user);
        userDatabaseWriter.remove(user);
    }

    /**
     * Adds friend to friend list of user
     */
    public void addFriend(Profile profile) {

    }

    /**
     * Removes friend from friend list of user
     */
    public void removeFriend(Profile profile) {

    }

    /**
     * Returns user based on inputted username and password
     * @param username
     * @param password
     * @return user based on inputted username and password
     */
    public RegisteredUser getUser(String username, String password) {
        for(RegisteredUser user: users) {
            String userName = (String) personJSON.get("username");
            String passWord = (String) personJSON.get("password"));
            if(userName.equals(username) && passWord.equals(password)) {
                return user;
            }
        }
    }

    /**
     * Returns list of all registered users
     * @return list of users
     */
    public ArrayList<User> getAllUsers() {
        users = userDatabaseLoader.getUser();
        return users;
    }
}
