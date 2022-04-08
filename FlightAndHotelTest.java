import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.jupiter.api.Test;

public class FlightAndHotelTest {
    @Test
    void testFlight_toString() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Seat> seat = new ArrayList<Seat>();
            seat.add(new Seat(true, "1A"));
            seat.add(new Seat(false, "2B"));
            seat.add(new Seat(false, "C18"));
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date flightDay = format.parse("2/25/1995");
            Flight flight = new Flight(uuid, "Columbia", "Chicago", flightDay, "10:30AM", "12:20PM", seat, "American Airlines");
            String flightString = flight.toString();
            String actual = "Departure Location: Columbia Destination: Chicago\nDepature Date: 1995 Departure Time: 10:30AM Arrival Time: 12:20PM";
            assertEquals(flightString, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_addAmenities_ShouldPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Amenities amenity = Amenities.GYM;
            hotel.addAmenities(amenity);
            assertEquals(hotel.getAmenities().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //amenity is not valid
    @Test
    void testHotel_addAmenities_ShouldNotPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Amenities amenity = null;
            hotel.addAmenities(amenity);
            assertEquals(hotel.getAmenities().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_removeAmenity_ShouldPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Amenities amenity = Amenities.GYM;
            hotel.addAmenities(amenity);
            Amenities amenity2 = Amenities.COFFEEKIT;
            hotel.addAmenities(amenity2);
            hotel.removeAmenity(amenity);
            assertEquals(hotel.getAmenities().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_removeAmenity_ShouldNotPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Amenities amenity = null;
            hotel.addAmenities(amenity);
            Amenities amenity2 = Amenities.COFFEEKIT;
            hotel.addAmenities(amenity2);
            hotel.removeAmenity(amenity);
            assertEquals(hotel.getAmenities().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_addAccessibility_ShouldPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Accessibility accessibility = Accessibility.ALTERNATIVE_TEXT_PLACARD;
            hotel.addAccessibility(accessibility);
            assertEquals(hotel.getAccessibility().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_addAccessibility_ShouldNotPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Accessibility accessibility = null;
            hotel.addAccessibility(accessibility);
            assertEquals(hotel.getAccessibility().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_removeAccessibility_ShouldPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Accessibility accessibility = Accessibility.ALTERNATIVE_TEXT_PLACARD;
            hotel.addAccessibility(accessibility);
            Accessibility accessibility2 = Accessibility.HEARING_ACCESSABILITY_KIT;
            hotel.addAccessibility(accessibility2);
            hotel.removeAccessibility(accessibility);
            assertEquals(hotel.getAccessibility().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_removeAccessibility_ShouldNotPass() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            Accessibility accessibility = null;
            hotel.addAccessibility(accessibility);
            Accessibility accessibility2 = Accessibility.HEARING_ACCESSABILITY_KIT;
            hotel.addAccessibility(accessibility2);
            hotel.removeAccessibility(accessibility);
            assertEquals(hotel.getAccessibility().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHotel_toString() {
        try {
            UUID uuid = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            String hotelString = hotel.toString();
            String actual = "Name: Test Rating: null Check in day: 1994 Check out day: 1994";
            assertEquals(hotelString, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
