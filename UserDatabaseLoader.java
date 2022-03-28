import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * User Database Loader
 * 
 * @author JavaFine
 */
public class UserDatabaseLoader {
  protected static final String User_FILE_NAME = "src/users.json";
  protected static final String User_FILE_Id = "id";
  protected static final String User_FILE_User_Id = "user-id";
  protected static final String User_FILE_Password = "password";
  protected static final String User_FILE_First_Name = "firstname";
  protected static final String User_FILE_Last_Name = "lastname";
  protected static final String User_FILE_Address = "address";
  protected static final String User_FILE_City = "city";
  protected static final String User_FILE_State = "state";
  protected static final String User_FILE_Zip = "zip";
  protected static final String User_FILE_Date_Of_Birthday = "d.o.b";
  protected static final String User_FILE_Email_Address = "emailAddress";
  protected static final String User_FILE_Phone_Number = "phoneNumber";
  protected static final String User_FILE_Disability = "disability";
  protected static final String User_FILE_Visa = "visa";
  protected static final String User_FILE_Occupation = "occupation";
  protected static final String User_FILE_Discount = "discount";

  protected static final String User_Friends = "Friends";

  /**
   * Returns list of users from JSON file
   * 
   * @return array list of users
   */
  public static ArrayList<RegisteredUser> getUser() {
    ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Flight> flights = new ArrayList<Flight>();
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    try {
      // read json file
      FileReader reader = new FileReader(User_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJason = (JSONArray) new JSONParser().parse(reader);

      for (int i = 0; i < userJason.size(); i++) {
        JSONObject userJSON = (JSONObject) userJason.get(i);
        UUID id = (UUID) userJSON.get("id");
        String userID = (String) userJSON.get("user-id");
        String password = (String) userJSON.get("password");
        String firstName = (String) userJSON.get("firstname");
        String lastName = (String) userJSON.get("lastname");
	  	  String address =(String) userJSON.get("address");
		    String city =(String) userJSON.get("city");
		    String state =(String) userJSON.get("state");
	    	String zip=(String) userJSON.get("zip");
        String dateOfBirthday = (String) userJSON.get("d.o.b");
	    	String emailAddress =(String) userJSON.get("emailAddress");
	    	String phoneNumber =(String) userJSON.get("phoneNumber");
	    	String disability =(String) userJSON.get("disability");
	    	String visa =(String) userJSON.get("visa");
	    	String occupation =(String) userJSON.get("occupation");
        String discount = (String) userJSON.get("discount");

        JSONArray list = (JSONArray) userJSON.get("Friends");
        for (int j = 0; j < list.size(); j++) {
          JSONObject getFriends = (JSONObject) list.get(j);
          UUID Friend_ID = (UUID) getFriends.get("id");
          String Friend_FirstName = (String) getFriends.get("firstname");
          String Friend_LastName = (String) getFriends.get("lastname");
          String Friend_DateOfBirthday = (String) getFriends.get("d.o.b");
          String Friend_Discount = (String) getFriends.get("discount");

          JSONArray list_flight = (JSONArray) userJSON.get("flights");
          for (int k = 0; k < list_flight.size(); k++) {
            JSONObject getFri_flight = (JSONObject) list.get(k);
            UUID Flight_ID = (UUID) getFri_flight.get("flightid");
            String Flight_Seat = (String) getFri_flight.get("seat");
            // Flight friend_flight = new Flight();
            // friend_flight.getFlightByUUID(Flight_ID);
            // flights.add(friend_flight);
          }
          JSONArray list_hotel = (JSONArray) userJSON.get("hotels");
          for (int m = 0; m < list_hotel.size(); m++) {
            JSONObject getFri_hotel = (JSONObject) list.get(m);
            UUID Hotel_ID = (UUID) getFri_hotel.get("roomid");
            String Hotel_Room_Check_IN_Day = (String) getFri_hotel.get("check in day");
           // HotelsList new_Hotels = new HotelsList();
            //new_Hotels.getHotelByUUID(Hotel_ID);
           // hotels.add(new_Hotel);
          }
          Friend new_friend = new Friend(Friend_ID, Friend_FirstName, Friend_LastName,
              Friend_DateOfBirthday, Friend_Discount, flights, hotels);
          friends.add(new_friend);
        }
	        	Profile new_User=new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress, phoneNumber, disability, visa, occupation, discount);
            RegisteredUser user =
            new RegisteredUser(id, friends,new_User,userID,password);
            users.add(user);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return users;
  }
}