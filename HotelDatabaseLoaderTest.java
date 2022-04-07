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
		    "12:00", "3:00","200$");
		ArrayList<Room> room = new ArrayList<Room>();
		room.add(abc);
		UUID id = UUID.randomUUID();
		hotelList.add(new Hotel(id, "Columbia", "No.1 hotel", room));
		HotelDatabaseWriter.saveHotels();
	}
	
	@AfterEach
	void tearDown()
	{
		hotels.getInstance().getAllHotels().clear();
		HotelDatabaseWriter.saveHotels();
	}
	
	@Test
	void testGetHotelsSizeZero()
	{
		hotels.getInstance().getAllHotels().clear();
		HotelDatabaseWriter.saveHotels();
		assertEquals(0,hotelList.size());
	}
	@Test
	void testGetHotelName() {
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals("No.1 hotel", hotels.getAllHotels().get(0).getHotelName());
	}
	@Test
	void testGetHotelCity()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals("Columbia", hotels.getAllHotels().get(0).getLocation());
	}
	@Test
	void testRoomType()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals("big bed room", hotels.getAllHotels().get(0).getHotelRooms().get(0).getRoomType());
	}
	@Test
	void testRoomBedsOfNumber()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals(2, hotels.getAllHotels().get(0).getHotelRooms().get(0).getRoomNumberOfBeds());
	}
	@Test
	void testRoomCheckInDay()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals(null, hotels.getAllHotels().get(0).getHotelRooms().get(0).getRoomCheckInDate());
	}
	@Test
	void testRoomCheckOutDay()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals(null, hotels.getAllHotels().get(0).getHotelRooms().get(0).getRoomCheckOutDate());
	}
	@Test
	void testRoomCheckInTime()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals("12:00", hotels.getAllHotels().get(0).getHotelRooms().get(0).getRoomCheckInTime());
	}
	@Test
	void testRoomCheckOutTime()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals("3:00", hotels.getAllHotels().get(0).getHotelRooms().get(0).getRoomCheckOutTime());
	}
}
