import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.jupiter.api.Test;

public class HotelsListTesting {
    
    // All private classes are not tested 

    @Test 
    void getAllHotels() {
        assertEquals(HotelsList.getInstance().getAllHotels().size(),4);
    }

    @Test
    void getHotelByUUID() {
        try {
            Hotel hotel = HotelsList.getInstance().getHotelByUUID(2ead4186-a210-406d-a130-ba2c51b4ff78);
            UUID uuid = new UUID(2ead4186-a210-406d-a130-ba2c51b4ff78);
            String name = "Marriott of Seattle";
            String city = "Seattle";
            ArrayList<Room> rooms = new ArrayList<Room>();
            int numOfBed = 2;
            String roomType = "Deluxe";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkInDay = format.parse("08/12/2022");
            Date checkOutDay = format.parse("08/14/2022");
            String checkInTime = "3:30 PM";
            String checkOuttime = "12:00 PM";
            String price = "$100";
            Room room1 = new Room(roomType, numOfBed, checkInDay, checkOutDay, checkInTime, checkOutTime, price);
            Room room2 = new Room(roomType, numOfBed, checkInDay, checkOutDay, checkInTime, checkOutTime, price);
            rooms.add(room1);
            rooms.add(room2);
            Hotel actual = Hotel(uuid, name, city, rooms);
            assertEquals(hotel, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addTraveler() {

    }

    @Test
    void addRoom() {

    }

    @Test
    void getSearch() {

    }

    @Test
    void getFourMatchesByLocation() {

    }

    @Test
    void checkValidityOfAccessibility() {

    }

    @Test
    void checkValidityOfAmenity() {

    }

    @Test
    void getHotelByRoomTypes() {

    }

    @Test 
    void getHotelByNumberOfBeds() {

    }

    @Test
    void printRoomByDateAndTime() {

    }

    @Test
    void cancelHotel() {

    }

    @Test
    void saveHotel() {

    }
}
