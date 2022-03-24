
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FlightDatabaseWriter {
  protected static final String FLIGHT_FILE = "src/flight.json";
  protected static final String ID = "id";
  protected static final String Departs_FROM = "departs from";
  protected static final String DESTINATION = "destination";
  protected static final String DEPARTURE_DATE = "departure date";
  protected static final String DEPARTURE_TIME = "departure time";
  protected static final String ARRIVAL_TIME = "arrival time";
  protected static final String SEATS = "seats";
  protected static final String AIRLINE = "Airline";
  protected static final String SEAT_NAME = "name";
  protected static final String SEAT_AVAILABLE = "available";

  public static void saveFlights() {
    FlightsList flights = FlightsList.getInstance();
    ArrayList<Flight> currentFlights = flights.getAllFlights();
    JSONArray jasonFlights = new JSONArray();

    for (int i = 0; i < currentFlights.size(); i++) {
      // give a array in the begining
      jasonFlights.add(getFlightsJSON(currentFlights.get(i)));
    }
    try (FileWriter file = new FileWriter(FLIGHT_FILE)) {
      file.write(jasonFlights.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }



  }

  public static JSONObject getFlightsJSON(Flight flight) {
    // creat a object of jason
    JSONObject jsonoF = new JSONObject();
    String StringUUID = flight.getID().toString();
    jsonoF.put(ID, StringUUID);
    jsonoF.put(Departs_FROM, flight.getDepart());
    jsonoF.put(DESTINATION, flight.getDestination());
    jsonoF.put(DEPARTURE_DATE, flight.getDepartDate());
    jsonoF.put(DEPARTURE_TIME, flight.getDepartTime());
    jsonoF.put(ARRIVAL_TIME, flight.getArrivalTime());
    jsonoF.put(AIRLINE, flight.getAirline());

    JSONArray jasonseats = new JSONArray();
    jsonoF.put(SEATS, jasonseats);
    ArrayList<Seat> currentSeats = flight.getFlightSeats();

    for (int j = 0; j < currentSeats.size(); j++) {
      jasonseats.add(getSeatsJSON(currentSeats.get(j)));
    }

    return jsonoF;
  }

  public static JSONObject getSeatsJSON(Seat seat) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(SEAT_NAME, seat.getSeatNumber());
    boolean ava = seat.isOccupied();
    if (ava) {
      jsonoS.put(SEAT_AVAILABLE, "true");
    } else {
      jsonoS.put(SEAT_AVAILABLE, "false");
    }
    return jsonoS;
  }
}