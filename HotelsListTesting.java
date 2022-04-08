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
            assertEquals(hotel.getHotelName(), actual.getHotelName());
            assertEquals(hotel.getLocation(), actual.getLocation());
            assertEquals(hotel.getHotelRooms(), actual.getHotelRooms());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addTraveler_FriendExists() {
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

            UUID friend1UUID = new UUID.randomUUID();
            String friend1first = "First";
            String friend1last = "Last";
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend1Hotel = new ArrayList<Hotel>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1Hotel);
            friendList.add(friend1);
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID huuid = UUID.randomUUID();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(huuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

            HotelsList.getInstance().addTraveler(currentUser, friend1first, friend1last, hotelBooking);
            assertEquals(hotelBooking.getTraveler().size(), 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void addTraveler_FriendDoesNotExist() {
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

            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID huuid = UUID.randomUUID();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(huuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

            String friend1first = "First";
            String friend1last = "Last";
            HotelsList.getInstance().addTraveler(currentUser, friend1first, friend1last, hotelBooking);
            assertEquals(hotelBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addTraveler_UserNull() {
        RegisteredUser currentUser = null;
        ArrayList<Profile> travelers = new ArrayList<Profile>();
        ArrayList<Room> rooms = new ArrayList<Room>();
        UUID huuid = UUID.randomUUID();
        Date checkin1 = format.parse("11/28/1994");
        Date checkout1 = format.parse("12/03/1994");
        Date checkin2 = format.parse("11/28/2009");
        Date checkout2 = format.parse("12/03/2009");
        rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
        rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
        Hotel hotel = new Hotel(huuid, "Test", "London", rooms);
        HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

        String friend1first = "First";
        String friend1last = "Last";
        HotelsList.getInstance().addTraveler(currentUser, friend1first, friend1last, hotelBooking);
        assertEquals(hotelBooking.getTraveler().size(), 1);
    }

    @Test 
    void addTraveler_FriendNameNull() {
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
            Profile profile = new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress,
                    phoneNumber, visa, disability, occupation, discount);
            String user = "Username";
            String pass = "Password";

            UUID friend1UUID = new UUID.randomUUID();
            String friend1first = null;
            String friend1last = null;
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend1Hotel = new ArrayList<Hotel>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount,
                    friend1Flight, friend1Hotel);
            friendList.add(friend1);
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID huuid = UUID.randomUUID();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(huuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

            String first = "First";
            String last = "Last";
            HotelsList.getInstance().addTraveler(currentUser, first, last, hotelBooking);
            assertEquals(hotelBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void addTraveler_InputtedNameNull() {
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
            
            UUID friend1UUID = new UUID.randomUUID();
            String friend1first = "First";
            String friend1last = "Last";
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend1Hotel = new ArrayList<Hotel>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1Hotel);
            friendList.add(friend1);
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID huuid = UUID.randomUUID();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            Hotel hotel = new Hotel(huuid, "Test", "London", rooms);
            HotelBooking hotelBooking = new HotelBooking(travelers, rooms, hotel);

            String first = null;
            String last = null;
            HotelsList.getInstance().addTraveler(currentUser, first, last, hotelBooking);
            assertEquals(hotelBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void addTravler_HotelBookingNull() {
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

            UUID friend1UUID = new UUID.randomUUID();
            String friend1first = "First";
            String friend1last = "Last";
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Hotel> friend1Hotel = new ArrayList<Hotel>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1Hotel);
            friendList.add(friend1);
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            HotelBooking hotelBooking = null;
            String first = "First";
            String last = "Last";
            HotelsList.getInstance().addTraveler(currentUser, first, last, hotelBooking);
            assertEquals(hotelBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
