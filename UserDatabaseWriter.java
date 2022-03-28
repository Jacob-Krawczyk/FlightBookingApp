import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Hotel Database Writer 
 * @author JavaFine
 */
public class UserDatabaseWriter {
  protected static final String User_FILE = "src/users.json";
  protected static final String User_ID = "user-id";
  protected static final String password= "password";
  protected static final String User_First_Name = "firstname";
  protected static final String User_Last_Name= "lastname";
  protected static final String User_Date_Of_Birthday = "d.0.b";
  protected static final String User_Discount = "discount";
  protected static final String Friends = "Friends";
  protected static final String Friend_ID = "id";
  protected static final String Friend_First_Name = "firstname";
  protected static final String Friend_Last_Name = "lastname";
  protected static final String Friend_Date_Of_Birthday = "d.0.b";
  protected static final String Friend_Discount = "discount";
  protected static final String Friend_Flights = "flights";
  protected static final String Friend_Flight_id = "flightid";
  protected static final String Friend_Flight_Seat = "seat";
  protected static final String Friend_Hotels = "hotels";
  protected static final String Friend_Hotel_id = "hotelid";
  protected static final String Friend_Hotel_Check_In_Day = "check in day";
  protected static final String Friend_Hotel_Check_Out_Day = "check out day";


  public static void saveUsers() {
    UserList users = UserList.getInstance();
    ArrayList<User> currentUsers = users.getAllUsers();
    JSONArray jasonUsers = new JSONArray();

    for (int i = 0; i < currentUsers.size(); i++) {
      // give a array in the begining
      jasonUsers.add(getUsersJSON(currentUsers.get(i)));
    }
    try (FileWriter file = new FileWriter(User_FILE)) {
      file.write(jasonUsers.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static JSONObject getUsersJSON(User user) {
    // creat a object of jason
    JSONObject jsonoF = new JSONObject();

    String StringUUID = user.getID().toString();
    jsonoF.put(User_ID, StringUUID);
    jsonoF.put(password, user.getPassword());
    jsonoF.put(User_First_Name,user.getFirstName());
	jsonoF.put(User_Last_Name,user.getLastName());
	jsonoF.put(User_Date_Of_Birthday,user.getDateOfBirthday());
	jsonoF.put(User_Discount,user.getDiscount());
	
    JSONArray jasonFriends = new JSONArray();
    jsonoF.put(Friends, jasonFriends);
    ArrayList<Friend> currentFriends = User.getFriends();

    for (int j = 0; j < currentFriends.size(); j++) {
		
	JSONArray jasonFlight = new JSONArray();
   	jsonoF.put(Friend_Flights, jasonFlight);
    ArrayList<Flight> currentFlights = user.getFriendFlights();
	
    for (int k = 0; k < currentFlights.size(); k++) 
	{
      jasonFlight.add(getFlightsJSON(currentFlights.get(k)));
    }

	JSONArray jasonHotel = new JSONArray();
   	jsonoF.put(Friend_Hotels, jasonHotel);
    ArrayList<Hotel> currentHotels = user.getFriendHotels();
	
    for (int i= 0; i < currentHotels.size(); i++) 
	{
      jasonHotel.add(getHotelsJSON(currentHotels.get(i)));
    }
	jasonFriends.add(getFriendsJSON(currentFriends.get(j)));
    }
    return jsonoF;
  }

  public static JSONObject getFriendsJSON(Friend friend) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Friend_ID , friend.getId());
	jsonoS.put(Friend_First_Name,friend.getFirstName());
	jsonoS.put(Friend_Last_Name,friend.getLastName());
	jsonoS.put(Friend_Date_Of_Birthday,friend.getDateOfBirthday());
	jsonoS.put(Friend_Discount,friend.getDiscount());
	jsonoS.put(Friend_Flights,friend.getFlights());
	jsonoS.put(Friend_Hotels,friend.getHotels());
    return jsonoS;
  }
  public static JSONObject getFlightsJSON(Flight flight) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Friend_Flight_id , flight.getId());
	jsonoS.put(Friend_Flight_Seat,flight.getSeat());
    return jsonoS;
  }
  public static JSONObject getHotelsJSON(Hotel hotel) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Friend_Hotel_id, hotel.getId());
	jsonoS.put(Friend_Hotel_Check_In_Day,hotel.getCheckInDay());
	jsonoS.put(Friend_Hotel_Check_Out_Day,hotel.getCheckOutDay());
    return jsonoS;
  }


}