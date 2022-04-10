

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import FlightBookingApp.FlightList;

class UserListTest {

	@Test
	void UserListShouldReturnNull() {
	   var userList = new UserList();
	   assertEquals(,userList.getInstance());//EXPEXTED OUTPUT,ACTUAL OUTPUT have to give in those curly breses
	}
	
	@Test
	void RegisteredUserShouldReturnUserID() {
		var userID = new UserID();
		assertEquals(,userID.getUserByUUID());
	}
	
	@Test
	void CurrentUserItinerary() {
		var currentUser = new CurrentUser();
		assertEquals(,currentUser.printItinerary());
	}
	
	@Test
	void CurrentUserAndTitle() {
		var flightList = new FlightList();
		assertEquals(,flghtList.writeItineraryToFile());
		var hotelList = new HotelList();
		assertEquals(,hotelList.writeItineraryToFile());
		
	}
	
	@Test
	void testValidityOfUsername() {
		var getUsername = new GetUsername();
		assertTrue(getUsername.checkValidityOfUsername());//write here user name exitst if any other name is given not present in data then it returns error
	}
	
	@Test
	void friendsList() {
		var friend =new Friend();
		assertEquals(,friend.getFriendsList());
	}
	
	/*@Test
	void addingNonUser() {
		var currentUserName = new CurrentUserName();
		assertEquals(currentUserName.addNonUserFriend());
		var firstName = new FistName();
		assertEquals(firstName.addNonUserName());
		var lastName = new LastName();
		assertEquals(lastName.addNonUserFriend());
		var dateOfBirth =new DateOfBirth();
		assertEquals(dateOfBirth());
		var discountForUser = new DiscountForUser();
		assertEquals(discountEquals());
	}*/
	
	/*@Test
	void bookingHotel() {
		
	}*/
	
	@Test
	void RegisterUser()
	{
		var userRegister = new UserRegister();
		assertEquals(,userRegister.getUserByUsername());
	}
	
	@Test
	void removingUser()
	{
		var removesUser = new RemovesUser();
		assertEquals(,removesUser.removeUser());
	}
	
	@Test
	void GettingUser()
	{
		var getUsers =new GetUsers();
		assertEquals(,getUsers.getUser());
	}
}
