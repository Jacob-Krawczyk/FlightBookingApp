import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDatebaseWriterTest {


	private UserList users = UserList.getInstance();
	private ArrayList<RegisteredUser> userList = users.getAllUsers();
	
	@BeforeEach
	public void setup()
	{
		UserList.getInstance().getAllUsers().clear();
		UserDatabaseWriter.saveUsers();
	}
	@AfterEach
	public void tearDown()
	{
		UserList.getInstance().getAllUsers().clear();
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
	void testWriteOneUser()
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
		
		userList.add(new RegisteredUser(id,  friendList, profile, "Sen Zhang 1234","password123abcd"));
		UserDatabaseWriter.saveUsers();
		System.out.println(UserDatabaseLoader.getUser().get(0).getUsername());
		assertEquals("Sen Zhang 1234",UserDatabaseLoader.getUser().get(0).getUsername());
		
	}
}
