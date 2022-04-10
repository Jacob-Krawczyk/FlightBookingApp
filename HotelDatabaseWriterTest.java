import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HotelDatabaseWriterTest{
	
	private HotelsList hotels = HotelsList.getInstance();
	private ArrayList<Hotel> hotelList = hotels.getAllHotels();
	@BeforeEach
	public void setup()
	{
		HotelsList.getInstance().getAllHotels().clear();
		HotelDatabaseWriter.saveHotels();
	}
	
	@AfterEach
	public void tearDown()
	{
		HotelsList.getInstance().getAllHotels().clear();
		HotelDatabaseWriter.saveHotels();
	}
	
	@Test
	void testWritingZeroHotels()
	{
		hotelList = HotelDatabaseLoader.getHotel();
		assertEquals(0,hotelList.size());
	}
	
	@Test
	void testWritingOneHotel()
	{
		Date checkinday = null ;
		Date checkoutday = null;
		Room abc = new Room("big bed room",2,checkinday,checkoutday,
		    "12:00", "3:00","200$");
		ArrayList<Room> room = new ArrayList<Room>();
		room.add(abc);
		UUID id = UUID.randomUUID();
		hotelList.add(new Hotel(id, "Columbia", "No.1 hotel", room));
		HotelDatabaseWriter.saveHotels();
		
		assertEquals("No.1 hotel",HotelDatabaseLoader.getHotel().get(0).getHotelName());
	}
	
	@Test
	void testWrittingThreeHotel()
	{
		Date checkinday = null ;
		Date checkoutday = null;
		Room abc = new Room("big bed room",2,checkinday,checkoutday,
		    "12:00", "3:00","200$");
		ArrayList<Room> room = new ArrayList<Room>();
		room.add(abc);
		UUID id = UUID.randomUUID();
		hotelList.add(new Hotel(id, "Columbia", "No.1 hotel", room));
		
		Date checkinday1 = null ;
		Date checkoutday1 = null;
		Room abc1 = new Room("two bed room",2,checkinday1,checkoutday1,
		    "13:00", "4:00","500$");
		ArrayList<Room> room1 = new ArrayList<Room>();
		room1.add(abc1);
		UUID id1 = UUID.randomUUID();
		hotelList.add(new Hotel(id1, "LA", "No.2 hotel", room));
		
		Date checkinday2 = null ;
		Date checkoutday2 = null;
		Room abc2 = new Room("three bed room",3,checkinday2,checkoutday2,
		    "14:00", "5:00","700$");
		ArrayList<Room> room2 = new ArrayList<Room>();
		room2.add(abc2);
		UUID id2 = UUID.randomUUID();
		hotelList.add(new Hotel(id2, "New York", "No.3 hotel", room2));
		HotelDatabaseWriter.saveHotels();
		
		assertEquals("No.1 hotel",HotelDatabaseLoader.getHotel().get(0).getHotelName());
	}
	
}
