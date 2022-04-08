import org.junit.Test;
import org.junit.Test.assertEquals;
import java.text.SimpleDateFormat;
import java.util.*;

public class RegisteredUserAndFriendTesting {
    @Test
    void RegisteredUser_ToString() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
            String userString = currentUser.toString();
            String actual = "Username: Username";
            assertEquals(userString, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_GetFriendByFirstAndLast_TwoFriendsHaveSameFirstAndLast() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            UUID friend1UUID = new UUID.randomUUID();
            String friend1first = "First";
            String friend1last = "Last";
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend1Hotel = new ArrayList<Hotel>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1Hotel);
            friendList.add(friend1);

            UUID friend2UUID = new UUID.randomUUID();
            String friend2first = "First";
            String friend2last = "Last";
            Date friend2DOB = format.parse("04/01/1993");
            String friend2discount = "none";
            ArrayList<Flight> friend2flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend2hotel = new ArrayList<Hotel>();
            Friend friend2 = new Friend(friend2UUID, friend2first, friend2last, friend2DOB, friend2discount, friend2flight, friend2hotel);
            friendList.add(friend2);

            String friendFirst = "First";
            String friendLast = "Last";
            Friend test = currentUser.getFriendByFristAndLast(friendFirst, friendLast);
            assertEquals(test, friend1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_GetFriendByFirstAndLast_AllDifferentNames() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            UUID friend1UUID = new UUID.randomUUID();
            String friend1first = "First";
            String friend1last = "Last";
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend1Hotel = new ArrayList<Hotel>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1Hotel);
            friendList.add(friend1);

            UUID friend2UUID = new UUID.randomUUID();
            String friend2first = "John";
            String friend2last = "Smith";
            Date friend2DOB = format.parse("04/01/1993");
            String friend2discount = "none";
            ArrayList<Flight> friend2flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend2hotel = new ArrayList<Hotel>();
            Friend friend2 = new Friend(friend2UUID, friend2first, friend2last, friend2DOB, friend2discount, friend2flight, friend2hotel);
            friendList.add(friend2);

            String friendFirst = "John";
            String friendLast = "Smith";
            Friend test = currentUser.getFriendByFristAndLast(friendFirst, friendLast);
            assertEquals(test, friend2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_BookFlight_ShouldPass() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            ArrayList<Flight> flights = new ArrayList<Flight>();
            UUID flight1uuid = UUID.randomUUID();
            ArrayList<Seat> seat = new ArrayList<Seat>();
            seat.add(new Seat(true, "1A"));
            seat.add(new Seat(false, "2B"));
            seat.add(new Seat(false, "C18"));
            Date flightDay = format.parse("2/25/1995");
            Flight flight = new Flight(uuid, "Columbia", "Chicago", flightDay, "10:30AM", "12:20PM", seat, "American Airlines");
            flights.add(flight);

            ArrayList<Profile> travelers = new ArrayList<Profile>();
            String travelerFirst = "First";
            String travelerLast = "Last";
            String travelerAddress = "1234 Random St";
            String travelerCity = "RanCity";
            String travelerState = "NO";
            String travelerZip = "12345";
            Date travelerDOB = format.parse("11/28/1992");
            String travelerEmailAddress = "randomuser@email.com";
            String travelerPhoneNumber = "123-123-1234";
            String travelerVisa = "Visa";
            Boolean travelerDisability = false;
            String travelerOccupation = "Speech Pathologist";
            String travelerDiscount = "none";
            Profile travelerProfile = new Profile(travelerFirst, travelerLast, travelerAddress, travelerCity, travelerState, travelerZip, travelerDOB, travelerEmailAddress, travelerPhoneNumber, travelerVisa, travelerDisability, travelerOccupation, travelerDiscount);
            travelers.add(travelerProfile);

            ArrayList<Seat> seatsList = new ArrayList<Seat>();
            Seat seats = new Seat(false, "2A");
            seatsList.add(seats);

            FlightBooking flightBooking = new FlightBooking(travelers, seatsList, flights);

            currentUser.bookFlight(flightBooking);
            assertEquals(currentUser.getFlight().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_BookFlight_ShouldNotPass() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            FlightBooking flightBooking = null;
            currentUser.bookFlight(flightBooking);
            assertEquals(currentUser.getFlight().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_CancelFlight() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_BookHotel() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_ CancelHotel() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void RegisteredUser_AddFriend() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void RegisteredUser_AddNonUserFriend() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void RegisteredUser_AddNonUserFriendRemoveFriend() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void RegisteredUser_AccessItinerary() {
        try {
            UUID uuid = new UUID.randomUUID();
            ArrayList<Friend> friendList = new ArrayList<Friend>();
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
            String user = "Username";
            String pass = "Password";
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void Friend_ToString_NoFlightOrHotel() {
        try {
            UUID uuid = new UUID.randomUUID();
            String first = "First";
            String last = "Last";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date dob = format.parse("11/28/1993");
            String discount = "none";
            ArrayList<Flight> flight = new ArrayList<Flight>();
            ArrayList<Hotel> hotel = new ArrayList<Hotel>();
            Friend friend = new Friend(uuid, first, last, dob, discount, flight, hotel);
            String friendString = friend.toString();
            String actual = "First Name: First Last Name: Last Date of Birth: 1993, Discount: none Flights: null Hotels: null";
            assertEquals(friendString,actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void Friend_toString_FlightOnly() {
        try {
            UUID uuid = new UUID.randomUUID();
            String first = "First";
            String last = "Last";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date dob = format.parse("11/28/1993");
            String discount = "none";
            ArrayList<Flight> flightList = new ArrayList<Flight>();
            UUID flightUUID = UUID.randomUUID();
            ArrayList<Seat> seat = new ArrayList<Seat>();
            seat.add(new Seat(true, "1A"));
            seat.add(new Seat(false, "2B"));
            seat.add(new Seat(false, "C18"));
            Date flightDay = format.parse("2/25/1995");
            Flight flight = new Flight(flightUUID, "Columbia", "Chicago", flightDay, "10:30AM", "12:20PM", seat, "American Airlines");
            flightList.add(flight);
            ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
            Friend friend = new Friend(uuid, first, last, dob, discount, flightList, hotelList);
            String friendString = friend.toString();
            String actual = "First Name: First Last Name: Last Date of Birth: 1993, Discount: none Flights: Departure Location: Columbia Destination: Chicago\nDepature Date: 1995 Departure Time: 10:30AM Arrival Time: 12:20PM Hotels: null";
            assertEquals(friendString,actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void Friend_toString_HotelOnly() {
        try {
            UUID uuid = new UUID.randomUUID();
            String first = "First";
            String last = "Last";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date dob = format.parse("11/28/1993");
            String discount = "none";
            ArrayList<Flight> flightList = new ArrayList<Flight>();
            ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
            UUID hotelUUID = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            Hotel hotel = new Hotel(hotelUUID, "Test", "London", rooms);
            hotelList.add(hotel);
            Friend friend = new Friend(uuid, first, last, dob, discount, flightList, hotelList);
            String friendString = friend.toString();
            String actual = "First Name: First Last Name: Last Date of Birth: 1993, Discount: none Flights: null Hotels: Name: Test Rating: null Check in day: 1994 Check out day: 1994";
            assertEquals(friendString,actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void Friend_ToString_FlightAndHotel() {
        try {
            UUID uuid = new UUID.randomUUID();
            String first = "First";
            String last = "Last";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date dob = format.parse("11/28/1993");
            String discount = "none";
            ArrayList<Flight> flightList = new ArrayList<Flight>();
            UUID flightUUID = UUID.randomUUID();
            ArrayList<Seat> seat = new ArrayList<Seat>();
            seat.add(new Seat(true, "1A"));
            seat.add(new Seat(false, "2B"));
            seat.add(new Seat(false, "C18"));
            Date flightDay = format.parse("2/25/1995");
            Flight flight = new Flight(flightUUID, "Columbia", "Chicago", flightDay, "10:30AM", "12:20PM", seat, "American Airlines");
            flightList.add(flight);
            ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
            UUID hotelUUID = UUID.randomUUID();
            ArrayList<Room> rooms = new ArrayList<Room>();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            Hotel hotel = new Hotel(hotelUUID, "Test", "London", rooms);
            hotelList.add(hotel);
            Friend friend = new Friend(uuid, first, last, dob, discount, flightList, hotelList);
            String friendString = friend.toString();
            String actual = "First Name: First Last Name: Last Date of Birth: 1993, Discount: none Flights: Departure Location: Columbia Destination: Chicago\nDepature Date: 1995 Departure Time: 10:30AM Arrival Time: 12:20PM Hotels: Name: Test Rating: null Check in day: 1994 Check out day: 1994";
            assertEquals(friendString,actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
