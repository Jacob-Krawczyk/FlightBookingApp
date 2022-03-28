import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * User Database Loader 
 * @author JavaFine
 */
public class UserDatabaseLoader{
	protected static final String User_FILE_NAME = "src/users.json";
	protected static final String User_FILE_Id = "id";
	protected static final String User_FILE_User_Id="user-id";
	protected static final String User_FILE_Password = "password";
	protected static final String User_FILE_First_Name = "firstname";
	protected static final String User_FILE_Last_Name="lastname";
	protected static final String User_FILE_Date_Of_Birthday="d.o.b";
	protected static final String User_FILE_Discount="discount";
	protected static final String HOTEL_FILE_ID = "id";
	protected static final String HOTEL_ROOM_TYPE="room type";

	/**
	 * Returns list of users from JSON file
	 * @return array list of users
	 */
	public static ArrayList<User> getUser()
	{
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Friend> friends = new ArrayList<Friend>();
		ArrayList<Flight> flights = new ArrayList<Flight>();
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();

		try {
			//read json file
			FileReader reader = new FileReader(User_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray userJason = (JSONArray) new JSONParser().parse(reader);
			
			for(int i =0;i<userJason.size();i++)
			{
				JSONObject userJSON =(JSONObject) userJason.get(i);
				UUID id =(UUID) userJSON.get("id");
				String userID = (String) userJSON.get("user-id");
				String password=(String)userJSON.get("password");
				String firstName=(String) userJSON.get("firstname");
				String lastName=(String)userJSON.get("lastname");
				String dateOfBirthday=(String)userJSON.get("d.o.b");
				String discount=(String)userJSON.get("discount");

				JSONArray list = (JSONArray) userJSON.get("Friends");
        		for (int j = 0; j < list.size(); j++) 
				{
         	 	JSONObject getFriends = (JSONObject) list.get(j);
         	 	UUID Friend_ID=(UUID)userJSON.get("id");
          		String Friend_FirstName=(String) userJSON.get("firstname");
				String Friend_LastName=(String)userJSON.get("lastname");
				String Friend_DateOfBirthday=(String)userJSON.get("d.o.b");
				String Friend_Discount=(String)userJSON.get("discount");

				JSONArray list_flight =(JSONArray)userJSON.get("flights");
				for(int k=0;k<list_flight.size();k++)
				{
					UUID Flight_ID=(UUID)userJSON.get("flightid");
					String Flight_Seat=(String) userJSON.get("seat");
					Flight friend_flight = new Flight();
					friend_flight.getFlightByUUID(Flight_ID);
					flights.add(friend_flight);
				}
				JSONArray list_hotel =(JSONArray)userJSON.get("hotels");
				for(int m=0;m<list_hotel.size();m++)
				{
					UUID Hotel_ID=(UUID)userJSON.get("roomid");
					String Hotel_Room_Check_IN_Day=(String) userJSON.get("check in day");
					Hotel new_Hotel = new Hotel();
					new_Hotel.getHotelByUUID(Hotel_ID);
					hotels.add(new_Hotel);
				}
				
          		Friend new_friend = new Friend(Friend_ID,Friend_FirstName,Friend_LastName,Friend_DateOfBirthday,Friend_Discount,flights,hotels);
				friends.add(new_friend);
				
        		}
				User user = new User(id, userID,password,firstName,lastName,dateOfBirthday,discount,friends);
				users.add(user);
			}
		}
		catch (Exception e) {
			System.out.println(e);     
		}
		return users;
	}
}
