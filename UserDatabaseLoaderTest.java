import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDatabaseLoaderTest {

	private UserList users = UserList.getInstance();
	private ArrayList<RegisteredUser> userList = users.getAllUsers();
	
	@BeforeEach
	public void setup()
	{
		userList.clear();
		Date checkinday = null ;
		Date checkoutday = null;
		Room abc = new Room("big bed room",2,checkinday,checkoutday,
		    "12:00", "3:00","300$");
		ArrayList<Room> room = new ArrayList<Room>();
		room.add(abc);
		UUID id = UUID.randomUUID();
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		UUID id2 = UUID.randomUUID();
		
		
		ArrayList<Flight> friend_flight = new ArrayList<Flight>();
		ArrayList<Hotel> new_Hotel = new ArrayList<Hotel>();
		Friend abc123 = new Friend(id2,"Ren","xing Cheng",checkoutday," ",friend_flight,new_Hotel);
		friendList.add(abc123);
		String password =" ";
		Profile profile = new Profile(password , password, password, password, password, password, checkoutday, password, password, password, null, password, password);
		
		userList.add(new RegisteredUser(id,  friendList, profile, "Sen Zhang","password123"));
	
		UserDatabaseWriter.saveUsers();
	}
	
	@Test
	void testGetUserSizeZero()
	{
		UserList.getInstance().getAllUsers().clear();
		UserDatabaseWriter.saveUsers();
		assertEquals(0,userList.size());
	}
	@Test
	void testGetUsersSize()
	{
		UserDatabaseWriter.saveUsers();
		assertEquals(1,userList.size());
	}
	@Test
	void testGetUserName() {
		
		assertEquals("Sen Zhang",userList.get(0).getUsername());
	}
	@Test
	void testGetUserPassword()
	{
		assertEquals("password123",userList.get(0).getPassword());
	}
	@Test
	void testFriendList()
	{
		assertEquals("Ren",userList.get(0).getFriends().get(0).getFirstName());
	}
	
	
}
