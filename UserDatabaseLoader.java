import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class UserDatabaseLoader{
	
	protected static final String User_FILE_NAME = "users.json";
	protected static final String User_FILE_Id = "id";
	protected static final String User_FILE_User_Id="user-id";
	protected static final String User_FILE_Password = "password";
	protected static final String HUser_FILE_First_Name = "firstname";
	protected static final String User_FILE_Last_Name="lastname";
	protected static final String User_FILE_Date_Of_Birthday="d.o.b";
	protected static final String User_FILE_Discount="discount";

	
	public static ArrayList<User> getUser()
	{
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Friend> friends = new ArrayList<Friend>();
		
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

				JSONArray list = (JSONArray) personJSON.get("Friends");
        		for (int j = 0; j < list.size(); j++) 
				{
         	 	JSONObject getFriends = (JSONObject) list.get(j);
         	 	UUID Friend_ID=(UUID)userJSON.get("id");
          		String Friend_FirstName=(String) userJSON.get("firstname");
				String Friend_LastName=(String)userJSON.get("lastname");
				String Friend_DateOfBirthday=(String)userJSON.get("d.o.b");
				String Friend_Discount=(String)userJSON.get("discount");

          		Friend new_friend = new Friend(Friend_ID,Friend_FirstName,Friend_LastName,Friend_DateOfBirthday,Friend_Discount);
				friends.add(new_friend);
        		}
				User user = new User(id, userID,password,firstName,lastName,dateOfBirthday,discount,friends);
				users.add(user);
			}
			
		}
		catch (Exception e) {
        
		}
	
		return users;
		
	}
	
}
