import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Testing All Enum ToStrings
 * @author JavaFine
 */

public class EnumTest {
    @Test
    void testAccessibility_ToString() {
        String accessibility = Accessibility.values().toString();
        String actual = "Service Animal, Hearing Accessibility Kit, Visual Fire Smoke Detector, Grab Bars in Bathroom, Lever Lock System, Alternative Text Placard, Shower Seats";
        assertEquals(accessibility, actual);
    }

    @Test 
    void testAirlineCompany_ToString() {
        String comp = AirlineCompany.values().toString();
        String actual = "American Airline, Delta, Southwest Airlines, United Airlines";
        assertEquals(comp, actual);
    }

    @Test 
    void testAmenities_ToString() {
        String amenities = Amenities.values().toString();
        String actual = "Pool, Gym, Toiletries, Coffee Kit, Wifi, Parking, Smoke, Meals";
        assertEquals(amenities, actual);
    }

    @Test
    void testFlightClass_ToString() {
        String classes = FlightClass.values().toString();
        String actual = "Economy, Premium Economy, First Class, Business";
        assertEquals(classes, actual);
    }

    @Test
    void testHotelRoomTypes_ToString() {
        String roomType = HotelRoomTypes.values().toString();
        String actual = "Suite, Standard, Room Only, Connecting, Minimalist, Deluxe, Studio";
        assertEquals(roomType, actual);
    }
}
