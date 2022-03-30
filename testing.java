import java.util.ArrayList;

public class testing {
    private static FlightsList flightList;
    private HotelsList hotelList;
    private UserList userList;
   
    public testing() {
        this.flightList = flightList.getInstance();
    }
    public static void main(String[] args) {
        ArrayList<Flight> test = flightList.getAllFlights();
        System.out.println(test.size());
        /*
        String departLocation = "Columbia";
        String destination = "Seattle";
        ArrayList<String> airline = new ArrayList<String>();
        airline.add("American Airlines");
        airline.add("Delta");
        ArrayList<Flight> fourthMatch = flightList.getFourthMatch(departLocation, destination, airline);
        System.out.println(fourthMatch.size());
        */
    }
}
