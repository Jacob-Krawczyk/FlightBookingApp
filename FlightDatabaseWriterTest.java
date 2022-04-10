import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightDatabaseWriterTest {

	private FlightsList flights = FlightsList.getInstance();
	  private ArrayList<Flight> flightList = flights.getAllFlights();
	 @BeforeEach
	  public void setup() {
	    FlightsList.getInstance().getAllFlights().clear();
	    FlightDatabaseWriter.saveFlights();
	 }
	 
	@Test
	void testWritingOneFlight()
	{
		 Date dp_date = null;
		    Seat abc = new Seat(true, "12A");
		    ArrayList<Seat> seats = new ArrayList<Seat>();
		    seats.add(abc);
		    UUID id = UUID.randomUUID();
		    flightList.add(new Flight(id, "Columbial", "Atl123", dp_date, "12", "14", seats, "AA"));
		    FlightDatabaseWriter.saveFlights();
		    

			assertEquals("Columbial",FlightDatabaseLoader.getFlight().get(0).getDepartLocation());
	}
	

}
