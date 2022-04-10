import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightDatabaseLoaderTest{

  private FlightsList flights = FlightsList.getInstance();
  private ArrayList<Flight> flightList = flights.getAllFlights();

  @BeforeEach
  public void setup() {
    flightList.clear();
    Date dp_date = null;
    Seat abc = new Seat(true, "12A");
    ArrayList<Seat> seats = new ArrayList<Seat>();
    seats.add(abc);
    UUID id = UUID.randomUUID();
    flightList.add(new Flight(id, "Columbia", "Atl", dp_date, "12", "14", seats, "AA"));
    FlightDatabaseWriter.saveFlights();
  }

  

  @Test
  void testGetFlightsSizeZero() {
	  	FlightsList.getInstance().getAllFlights().clear();
		FlightDatabaseWriter.saveFlights();
		assertEquals(0, flightList.size());
  }

  @Test
  void testGetFlightsSize() {
	
	    assertEquals(1, flightList.size());
  }

  @Test
  void testFlightLocation() {
 
   
    assertEquals("Columbia", flightList.get(0).getDepartLocation());
  }
  @Test
  void testFlightdestination() {
 
   
    assertEquals("Atl", flightList.get(0).getDestination());
  }
  @Test
  void testFlightdepartDate() {
 
    assertEquals(null, flightList.get(0).getDepartDate());
  }
  @Test
  void testFlightdepartTime() {
    assertEquals("12", flightList.get(0).getDepartTime());
  }
  @Test
  void testFlightarrivalTime() {
    assertEquals("14", flightList.get(0).getArrivalTime());
  }
  @Test
  void testFlightarrile() {
    assertEquals("AA", flightList.get(0).getAirline());
  }
  @Test
  void testSeatNumber() {
	  
    assertEquals("12A", flightList.get(0).getFlightSeats().get(0).getSeatNumber());
  }
  @Test
  void testName() {
    assertEquals("Columbia", flightList.get(0).getDepartLocation());
  }


}