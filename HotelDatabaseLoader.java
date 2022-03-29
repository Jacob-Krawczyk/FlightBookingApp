import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class HotelDatabaseLoader{
	protected static final String HOTEL_FILE_NAME = "src/hotels.json";
	protected static final String HOTEL_FILE_ID = "id";
	protected static final String HOTEL_FILE_CITY = "city";
	protected static final String HOTEL_FILE_CHECK_IN_DATE = "check in date";
	protected static final String HOTEL_FILE_CHECK_OUT_DATE="check out date";
	protected static final String HOTEL_FILE_CHECK_IN_TIME="check in time";
	protected static final String HOTEL_FILE_CHECK_OUT_TIME="check out time";
	protected static final String HOTEL_NAME="hotel name";
	protected static final String HOTEL_ROOM_TYPE="room type";
	protected static final String HOTEL_NUMBER_OF_BEDS="number of beds";
	protected static final String HOTEL_AMENITIES="Amenities";
	protected static final String HOTEL_Price_Per_Night="Price per night";
	protected static final String HOTEL_Rating="Rating";
	
	public static ArrayList<Hotel> getHotel() {
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			//read json file
			FileReader reader = new FileReader(HOTEL_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray hotelJason = (JSONArray) new JSONParser().parse(reader);
			
			for(int i =0;i<hotelJason.size();i++)
			{
				JSONObject hotelJSON =(JSONObject) hotelJason.get(i);
				UUID id =(UUID) hotelJSON.get("id");
				String city = (String) hotelJSON.get("city");
				
				String hotel_name=(String)hotelJSON.get("hotel name");
				
				
				JSONArray list = (JSONArray) hotelJSON.get("rooms");
        	for (int j = 0; j < list.size(); j++) {
         	 	JSONObject getRooms = (JSONObject) list.get(j);
         	 	String room_type=(String)hotelJSON.get("room type");
          		String number_of_beds=(String)hotelJSON.get("number of beds");
				Date check_in_date =(Date) hotelJSON.get("check in date");
				Date check_out_date =(Date) hotelJSON.get("check out date");
				String check_in_time=(String) hotelJSON.get("check in time");
				String check_out_time=(String) hotelJSON.get("check out time");
				/*
				String Amenities=(String) hotelJSON.get("Amenities");
				String Price_Per_Night=(String) hotelJSON.get("Price per night");
				String Rating=(String) hotelJSON.get("Rating");
				Room new_room = new Room(room_type, number_of_beds,check_in_date,check_out_date,
				  check_in_time,check_out_time);
 				rooms.add(new_room);
				*/

          		Room new_room = new Room(room_type, number_of_beds,check_in_date,check_out_date,
				  check_in_time,check_out_time);
 				rooms.add(new_room);
        		}
				Hotel hotel = new Hotel(id, city,hotel_name,rooms);
				hotels.add(hotel);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return hotels;
	}
}
