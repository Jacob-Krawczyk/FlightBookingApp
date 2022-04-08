import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.jupiter.api.Test;

public class BookingsTest {
    @Test
    void FlightBooking_AddTraveler_ShouldPass() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Seat> seats = new ArrayList<Seat>();
            ArrayList<Flight> flights = new ArrayList<Flight>();
            FlightBooking flightBooking = new FlightBooking(travelers, seats, flights);
            String firstName = "First";
            String lastName = "Last";
            String address = "1234 Random St";
            String city = "RanCity";
            String state = "NO";
            String zip = "12345";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date dateOfBirthday = format.parse("11/28/1992");
            String emailAddress = "randomuser@email.com";
            String phoneNumber = "123-123-1234";
            String visa = "Visa";
            Boolean disability = false;
            String occupation = "Speech Pathologist";
            String discount = "none";
            Profile profile = new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress, phoneNumber, visa, disability, occupation, discount);
            flightBooking.addTraveler(profile);
            assertEquals(flightBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void FlightBooking_AddTraveler_ShouldNotPass() {
        ArrayList<Profile> travelers = new ArrayList<Profile>();
        ArrayList<Seat> seatsList = new ArrayList<Seat>();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        FlightBooking flightBooking = new FlightBooking(travelers, seatsList, flights);
        Profile profile = null;
        flightBooking.addTraveler(profile);
        assertEquals(flightBooking.getTraveler().size(), 1);
    }

    @Test
    void FlightBooking_AddSeat_ShouldNotPass() {
        ArrayList<Profile> travelers = new ArrayList<Profile>();
        ArrayList<Seat> seatsList = new ArrayList<Seat>();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        FlightBooking flightBooking = new FlightBooking(travelers, seatsList, flights);
        Seat seats = null;
        flightBooking.addSeat(seats);
        assertEquals(flightBooking.getSeat().size(), 1);
    }

    @Test
    void FlightBooking_AddSeat_ShouldPass() {
        ArrayList<Profile> travelers = new ArrayList<Profile>();
        ArrayList<Seat> seatsList = new ArrayList<Seat>();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        FlightBooking flightBooking = new FlightBooking(travelers, seatsList, flights);
        Seat seats = new Seat(true, "1A");
        flightBooking.addSeat(seats);
        assertEquals(flightBooking.getSeat().size(), 1);
    }

    @Test 
    void FlightBooking_ToString() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Seat> seats = new ArrayList<Seat>();
            ArrayList<Flight> flights = new ArrayList<Flight>();
            FlightBooking flightBooking = new FlightBooking(travelers, seats, flights);
            UUID flight1uuid = UUID.randomUUID();
            ArrayList<Seat> seat = new ArrayList<Seat>();
            seat.add(new Seat(true, "1A"));
            seat.add(new Seat(false, "2B"));
            seat.add(new Seat(false, "C18"));
            seats.add(new Seat(true, "1A"));
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date flight1Day = format.parse("2/25/1995");
            Flight flight1 = new Flight(flight1uuid, "Columbia", "Chicago", flight1Day, "10:30AM", "12:20PM", seat, "American Airlines");
            flights.add(flight1);
            String firstName = "First";
            String lastName = "Last";
            String address = "1234 Random St";
            String city = "RanCity";
            String state = "NO";
            String zip = "12345";
            Date dateOfBirthday = format.parse("11/28/1992");
            String emailAddress = "randomuser@email.com";
            String phoneNumber = "123-123-1234";
            String visa = "Visa";
            Boolean disability = false;
            String occupation = "Speech Pathologist";
            String discount = "none";
            Profile profile = new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress, phoneNumber, visa, disability, occupation, discount);
            travelers.add(profile);
            String flightBookingString = flightBooking.toString();
            String actual = "Travelers: Profile Seats: Seats Flights: Departure Location: Columbia Destination: Chicago\nDepature Date: 1995 Departure Time: 10:30AM Arrival Time: 12:20PM";
            assertEquals(flightBookingString, actual);
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    @Test
    void HotelBooking_AddTraveler_ShouldNotPass() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);
            Profile profile = null;
            hotelBooking.addTraveler(profile);
            assertEquals(hotelBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test    
    void HotelBooking_AddTraveler_ShouldPass() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

            String firstName = "First";
            String lastName = "Last";
            String address = "1234 Random St";
            String city = "RanCity";
            String state = "NO";
            String zip = "12345";
            Date dateOfBirthday = format.parse("11/28/1992");
            String emailAddress = "randomuser@email.com";
            String phoneNumber = "123-123-1234";
            String visa = "Visa";
            Boolean disability = false;
            String occupation = "Speech Pathologist";
            String discount = "none";
            Profile profile = new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress, phoneNumber, visa, disability, occupation, discount);

            hotelBooking.addTraveler(profile);
            assertEquals(hotelBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void HotelBooking_AddRoom_ShouldNotPass() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);
            Room room = null;
            hotelBooking.addRoom(room);
            assertEquals(hotelBooking.getRooms().size(), 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void HotelBooking_AddRoom_ShouldPass() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

            String roomType = "Standard";
            int numOfBed = 2;
            Date checkinDate = format.parse("11/28/2008");
            Date checkoutDate = format.parse("12/03/2008");
            String checkinTime = "10:10AM";
            String checkoutTime = "10:10AM";
            String price = "$140";
            Room room = new Room(roomType, numOfBed, checkinDate, checkoutDate, checkinTime, checkoutTime, price);
            hotelBooking.addRoom(room);
            assertEquals(hotelBooking.getRooms().size(), 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void HotelBooking_ToString() {
        try {
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            Hotel hotel = new Hotel(uuid, "Test", "London", rooms);
            
            String firstName = "First";
            String lastName = "Last";
            String address = "1234 Random St";
            String city = "RanCity";
            String state = "NO";
            String zip = "12345";
            Date dateOfBirthday = format.parse("11/28/1992");
            String emailAddress = "randomuser@email.com";
            String phoneNumber = "123-123-1234";
            String visa = "Visa";
            Boolean disability = false;
            String occupation = "Speech Pathologist";
            String discount = "none";
            Profile profile = new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress, phoneNumber, visa, disability, occupation, discount);
            
            travelers.add(profile);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);
            String hotelbookingString = hotelBooking.toString();
            String actual = "Guests: Profile\nRooms: Room\nHotel: Name: Test Rating: null Check in day: 1994 Check out day: 1994";
            assertEquals(hotelbookingString, actual);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
