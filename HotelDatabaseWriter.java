
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HotelDatabaseWriter {
  protected static final String Hotel_FILE = "src/hotels.json";
  protected static final String ID = "id";
  protected static final String Hotel_CITY= "city";
  protected static final String Hotel_Name = "hotel name";
  protected static final String Rooms = "rooms";
  protected static final String Rooms_room_type = "room type";
  protected static final String Roomes_number_of_beds = "number of beds";
  protected static final String Roomes_check_in_date = "check in date";
  protected static final String Roomes_check_out_date = "check out date";
  protected static final String Roomes_check_in_time = "check in time";
  protected static final String Roomes_check_out_time = "check out time";

  public static void saveHotels() {
    HotelsList hotels = HotelsList.getInstance();
    ArrayList<Hotel> currentHotels = hotels.getAllHotels();
    JSONArray jasonHotels = new JSONArray();

    for (int i = 0; i < currentHotels.size(); i++) {
      // give a array in the begining
      jasonHotels.add(getHotelsJSON(currentHotels.get(i)));
    }
    try (FileWriter file = new FileWriter(Hotel_FILE)) {
      file.write(jasonHotels.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }



  }

  public static JSONObject getHotelsJSON(Hotel hotel) {
    // creat a object of jason
    JSONObject jsonoF = new JSONObject();

    String StringUUID = hotel.getID().toString();
    jsonoF.put(ID, StringUUID);
    jsonoF.put(Hotel_CITY, hotel.getLocation());
    jsonoF.put(Hotel_Name,hotel.getHotelName());

    JSONArray jasonRooms = new JSONArray();
    jsonoF.put(Rooms, jasonRooms);
    ArrayList<Room> currentRooms = hotel.getHotelRooms();

    for (int j = 0; j < currentRooms.size(); j++) {
      jasonRooms.add(getRoomsJSON(currentRooms.get(j)));
    }

    return jsonoF;
  }

  public static JSONObject getRoomsJSON(Room room) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Rooms_room_type, room.getRoomType());
	jsonoS.put(Roomes_number_of_beds,room.getRoomNumberOfBeds());
    jsonoS.put(Roomes_check_in_date,room.getRoomCheckInDate());
	jsonoS.put(Roomes_check_out_date,room.getRoomCheckOutDate());
	jsonoS.put(Roomes_check_in_time,room.getRoomCheckInTime());
	jsonoS.put(Roomes_check_out_time,room.getRoomCheckOutTime());

    return jsonoS;
  }
}