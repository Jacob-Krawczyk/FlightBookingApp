import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

public class FlightAndHotelTest {
    @Test
    void testFlight_toString() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Seat> seat = new ArrayList<Seat>();
        seat.add(new Seat(true, "1A"));
        seat.add(new Seat(false, "2B"));
        seat.add(new Seat(false, "C18"));
        Date flightDay = new Date(1995, 10, 20);
        Flight flight = new Flight(uuid, "Columbia", "Chicago", flightDay, "10:30AM", "12:20PM", seat, "American Airlines");
        String flightString = flight.toString();
        String actual = "Departure Location: Columbia Destination: Chicago\nDepature Date: 10/20/1995 Departure Time: 10:30AM Arrival Time: 12:20PM";
        assertEquals(flightString, actual);
    }

    @Test
    void testHotel_addAmenities_ShouldPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Amenities amenity = Amenities.GYM;
        hotel.addAmenities(amenity);
        assertEqauls(hotel.getAmenities().size(), 1);
    }

    //amenity is not valid
    @Test
    void testHotel_addAmenities_ShouldNotPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Amenities amenity = null;
        hotel.addAmenities(amenity);
        assertEquals(hotel.getAmenities().size(), 1);
    }

    @Test
    void testHotel_removeAmenity_ShouldPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Amenities amenity = Amenities.GYM;
        hotel.addAmenities(amenity);
        Amenities amenity2 = Amenities.COFFEEKIT;
        hotel.addAmenities(amenity2);
        hotel.removeAmenity(amenity);
        assertEquals(hotel.getAmenities().size(), 1);
    }

    @Test
    void testHotel_removeAmenity_ShouldNotPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Amenities amenity = null;
        hotel.addAmenities(amenity);
        Amenities amenity2 = Amenities.COFFEEKIT;
        hotel.addAmenities(amenity2);
        hotel.removeAmenity(amenity);
        assertEquals(hotel.getAmenities().size(), 1);
    }

    @Test
    void testHotel_addAccessibility_ShouldPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Accessibility accessibility = Accessibility.ALTERNATIVE_TEXT_PLACARD;
        hotel.addAccessibility(accessibility);
        assertEquals(hotel.getAccessibility().size(), 1);
    }

    @Test
    void testHotel_addAccessibility_ShouldNotPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Accessibility accessibility = null;
        hotel.addAccessibility(accessibility);
        assertEquals(hotel.getAccessibility().size(), 1);
    }

    @Test
    void testHotel_removeAccessibility_ShouldPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Accessibility accessibility = Accessibility.ALTERNATIVE_TEXT_PLACARD;
        hotel.addAccessibility(accessibility);
        Accessibility accessibility2 = Accessibility.HEARING_ACCESSABILITY_KIT;
        hotel.addAccessibility(accessibility2);
        hotel.removeAccessibility(accessibility);
        assertEquals(hotel.getAccessibility().size(), 1);
    }

    @Test
    void testHotel_removeAccessibility_ShouldNotPass() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        Accessibility accessibility = null;
        hotel.addAccessibility(accessibility);
        Accessibility accessibility2 = Accessibility.HEARING_ACCESSABILITY_KIT;
        hotel.addAccessibility(accessibility2);
        hotel.removeAccessibility(accessibility);
        assertEquals(hotel.getAccessibility().size(), 1);
    }

    @Test
    void testHotel_toString() {
        UUID uuid = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        Date checkin1 = new Date(1994, 10, 20);
        Date checkout1 = new Date(1994, 11, 4);
        Date checkin2 = new Date(2009, 12, 4);
        Date checkout2 = new Date(2009, 12, 30);
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
        String hotelString = hotel.toString();
        String actual = "Name: Test Rating: null Check in day: 10/20/1994 Check out day: 11/4/1994";
        assertEquals(hotelString, actual);
    }
}
