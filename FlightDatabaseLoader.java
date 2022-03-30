import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Flight Database Loader
 * @author JavaFine
 */
public class FlightDatabaseLoader {
  protected static final String FLIGHT_FILE = "flight.json";
  protected static final String ID = "id";
  protected static final String Departs_FROM = "departs from";
  protected static final String DESTINATION = "destination";
  protected static final String DEPARTURE_DATE = "departure date";
  protected static final String DEPARTURE_TIME = "departure time";
  protected static final String ARRIVAL_TIME = "arrival time";
  protected static final String SEATS = "seats";
  protected static final String AIRLINE = "Airline";

  /**
   * Returns JSON file as list of flights
   * @return array list of flights 
   */
  public static ArrayList<Flight> getFlight() {
    ArrayList<Seat> seats = new ArrayList<Seat>();
    ArrayList<Flight> flights = new ArrayList<Flight>();
    try {
      // Read json file
      FileReader reader = new FileReader(FLIGHT_FILE);
      JSONParser parser = new JSONParser();
      JSONArray flightsJason = (JSONArray) new JSONParser().parse(reader);

      // Loop though the variable
      for (int i = 0; i < flightsJason.size(); i++) {
        JSONObject flightJSON = (JSONObject) flightsJason.get(i);

        UUID id = UUID.fromString((String) flightJSON.get("id"));
        String departs_from = (String) flightJSON.get("departs from");
        String destination = (String) flightJSON.get("destination");
        Date departure_date = parseDate((String)flightJSON.get("departure date"));
        String departure_time = (String) flightJSON.get("departure time");
        String arrival_time = (String) flightJSON.get("arrival time");
        String Airline = (String) flightJSON.get("Airline");

        // Find the seat and gointo the seat then loop it.
        JSONArray list = (JSONArray) flightJSON.get("seats");
        for (int j = 0; j < list.size(); j++) {
          JSONObject getSeats = (JSONObject) list.get(j);
          String S_name = (String) getSeats.get("name");
          Boolean availabe = (Boolean) getSeats.get("available");
          // Get the number and avaiblibility, put them into new seat, and add to the arraylist
          Seat new_seat = new Seat(availabe, S_name);
          seats.add(new_seat);
        }
        // Add the whole information into single flight.
        Flight flight = new Flight(id, departs_from, destination, departure_date, departure_time,
            arrival_time, seats, Airline);
        // Add the every single flight to arraylist of flights.
        flights.add(flight);
      }
    } catch (Exception e) {  
      System.out.println(e); 
    }
    return flights;
  }
  public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			System.out.println("Sorry " + date + " is not parsable");
			return null;
		}
	}
}
