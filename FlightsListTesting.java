import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class FlightsListTesting {

	private FlightBooking flightBooking;
    private ArrayList<Seat> friend1Seat;
    private Date seats;
    private Flight flight;


    @Test
	void getAllFlights() {
        assertEquals(FlightsList.getInstance().getAllFlights().size(),4);
    }
	
	@Test
	void getFlightByUUID() {
		try {
			Flight flight = FlightsList.getInstance().getFlightByUUID(b4cc8d77-0b3f-4a69-bcaf-2e885e82cf9f);
            UUID uuid = new UUID(b4cc8d77-0b3f-4a69-bcaf-2e885e82cf9f);
            String name = "American Airlines";
            String depart = "Columbia";
            String destination = "Atlanta";
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date departDate = format.parse("08/12/2022");
            String departTime = "12:00 PM";
            String arrivalTime = "1:30 PM";
            ArrayList<Seat> seats = new ArrayList<Seat>();
            String seatName = "13A";
            boolean available = true;
            Seat seat1 = new Seat(seatName, available);
            Seat seat2 =  new Seat(seatName, available);
            seats.add(seat1);
            seats.add(seat2);
            Flight actual = Flight(uuid, name, depart, destination, seats);
            assertEquals(flight.getAirline(), actual.getAirline());
            assertEquals(flight.getDepartLocation());
            assertEquals(flight.getDestination());
            assertEquals(flight.getFlightSeats());
            
        } catch (Exception e) {
            e.printStackTrace();
			
		}
    }
        @Test
        void addTraveler_FriendExists() {
            try {
                UUID uuid = UUID.randomUUID();
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
    
                UUID friend1UUID = UUID.randomUUID();
                String friend1first = "First";
                String friend1last = "Last";
                Date friend1DOB = format.parse("12/25/1993");
                String friend1discount = "none";
                String friend1seat = "13A";
                ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
                Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1seat);
                friendList.add(friend1);
                RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);
    
                ArrayList<Profile> travelers = new ArrayList<Profile>();
                UUID huuid = UUID.randomUUID();
                FlightBooking flightBooking = new FlightBooking(travelers, friend1seat, friend1Flight);
    
                FlightsList.getInstance().addTraveler(currentUser, friend1first, friend1last, flightBooking);
                assertEquals(flightBooking.getTraveler().size(), 1);
    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            @Test 
             void addTraveler_FriendDoesNotExist() {
             try {
                UUID uuid = UUID.randomUUID();
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
                Flight flight = new Flight(huuid, "Test", "London", rooms);
                FlightBooking flightBooking = new FlightBooking(travelers, seat, flight);
    
                String friend1first = "First";
                String friend1last = "Last";
                FlightsList.getInstance().addTraveler(currentUser, friend1first, friend1last, flightBooking);
                assertEquals(flightBooking.getTraveler().size(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    @Test
    void addTraveler_UserNull() {
        try {
            RegisteredUser currentUser = null;
            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            UUID huuid = UUID.randomUUID();
            SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            rooms.add(new Room("Deluxe", 3, checkin1, checkout1, "10:30AM", "9:30PM", "$700"));
            rooms.add(new Room("Connecting", 4, checkin2, checkout2, "9:30AM", "10:30PM", "$100,000"));
            FlightBooking flightBooking = new FlightBooking(travelers, seat, flight);

            String friend1first = "First";
            String friend1last = "Last";
            FlightsList.getInstance().addTraveler(currentUser, friend1first, friend1last, flightBooking);
            assertEquals(flightBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void addTraveler_FriendNameNull() {
        try {
            UUID uuid = UUID.randomUUID();
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

            UUID friend1UUID = UUID.randomUUID();
            String friend1first = null;
            String friend1last = null;
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Seat> friend1seat = new ArrayList<Seat>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount,
                    friend1Flight, friend1Seat);
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
            Flight flight = new Flight(huuid, "Test", "London", seats);
            FlightBooking flightBooking = new FlightBooking(travelers, seats);

            String first = "First";
            String last = "Last";
            FlightsList.getInstance().addTraveler(currentUser, first, last, flightBooking);
            assertEquals(flightBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    void addTraveler_InputtedNameNull() {
        try {
            UUID uuid = UUID.randomUUID();
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
            
            UUID friend1UUID = UUID.randomUUID();
            String friend1first = "First";
            String friend1last = "Last";
            Date friend1DOB = format.parse("12/25/1993");
            String friend1discount = "none";
            ArrayList<Flight> friend1Flight = new ArrayList<Flight>();
            ArrayList<Seat> friend1Seat = new ArrayList<Seat>();
            Friend friend1 = new Friend(friend1UUID, friend1first, friend1last, friend1DOB, friend1discount, friend1Flight, friend1Seat);
            friendList.add(friend1);
            RegisteredUser currentUser = new RegisteredUser(uuid, friendList, profile, user, pass);

            ArrayList<Profile> travelers = new ArrayList<Profile>();
            ArrayList<Seat> rooms = new ArrayList<Seat>();
            UUID huuid = UUID.randomUUID();
            Date checkin1 = format.parse("11/28/1994");
            Date checkout1 = format.parse("12/03/1994");
            Date checkin2 = format.parse("11/28/2009");
            Date checkout2 = format.parse("12/03/2009");
            Flight flight = new Flight(huuid, "Test", "London", seat);
            FlightBooking flightBooking = new FlightBooking(travelers, seat, flight);

            String first = null;
            String last = null;
            FlightsList.getInstance().addTraveler(currentUser, first, last, flightBooking);
            assertEquals(flightBooking.getTraveler().size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	}

        
	
}

	
	

