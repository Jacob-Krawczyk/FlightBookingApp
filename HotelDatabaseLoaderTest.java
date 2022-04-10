import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotelDatabaseLoaderTest {

	private HotelsList hotels = HotelsList.getInstance();
	private ArrayList<Hotel> hotelList = hotels.getAllHotels();
	@BeforeEach
	public void setup()
	{
		hotelList.clear();
		Date checkinday = null ;
		Date checkoutday = null;
		Room abc = new Room("big bed room",2,checkinday,checkoutday,
		    "12:00", "3:00","300$");
		ArrayList<Room> room = new ArrayList<Room>();
		room.add(abc);
		UUID id = UUID.randomUUID();
		hotelList.add(new Hotel(id, "Columbia", "No.1 hotel", room));
		HotelDatabaseWriter.saveHotels();
	}
	

	
	@Test
	void testGetHotelsSizeZero()
	{
		HotelsList.getInstance().getAllHotels().clear();
		HotelDatabaseWriter.saveHotels();
		assertEquals(0,hotelList.size());
	}
	@Test
	void testGetHotelsSize()
	{
		HotelDatabaseWriter.saveHotels();
		assertEquals(1,hotelList.size());
	}
	@Test
	void testGetHotelName() {
		
		assertEquals("No.1 hotel", hotelList.get(0).getHotelName());
	}
	@Test
	void testGetHotelCity()
	{
		assertEquals("columbia",  hotelList.get(0).getLocation());
	}
	@Test
	void testRoomType()
	{
		assertEquals("big bed room",   hotelList.get(0).getHotelRooms().get(0).getRoomType());
	}
	@Test
	void testRoomBedsOfNumber()
	{
		
		assertEquals(2, hotelList.get(0).getHotelRooms().get(0).getRoomNumberOfBeds());
	}
	@Test
	void testRoomCheckInDay()
	{
		
		assertEquals(null, hotelList.get(0).getHotelRooms().get(0).getRoomCheckInDate());
	}
	@Test
	void testRoomCheckOutDay()
	{
		
		assertEquals(null, hotelList.get(0).getHotelRooms().get(0).getRoomCheckOutDate());
	}
	@Test
	void testRoomCheckInTime()
	{
		
		assertEquals("12:00",hotelList.get(0).getHotelRooms().get(0).getRoomCheckInTime());
	}
	@Test
	void testRoomCheckOutTime()
	{
		assertEquals("3:00", hotelList.get(0).getHotelRooms().get(0).getRoomCheckOutTime());
	}
}
