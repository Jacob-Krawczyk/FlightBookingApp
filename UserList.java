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
    public void addUser(User user) {
        users.add(user);
        userDatabaseWriter.add(user);
    }

    /**
     * Removes user from list and from database file
     * @param user
     */
    public void removeUser(User user) {
        users.remove(user);
        userDatabaseWriter.remove(user);
    }

    /**
     * Returns user based on inputted username and password
     * @param username
     * @param password
     */
    public void getUser(String username, String password) {
        for(User user: users) {
            if(users.getUsername.equals(username) && users.getPassword.equals(password)) {
                return user;
            }
        }
    }

    /**
     * Prints list of all users in list
     * @return
     */
    public ArrayList<User> getAllUsers() {
        return users;
    }
}
