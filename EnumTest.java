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
        System.out.println(accessibility);
    }

    @Test 
    void testAirlineCompany_ToString() {
        String comp = AirlineCompany.values().toString();
        System.out.println(comp);
    }

    @Test 
    void testAmenities_ToString() {
        String amenities = Amenities.values().toString();
        System.out.println(amenities);
    }

    @Test
    void testFlightClass_ToString() {
        String classes = FlightClass.values().toString();
        System.out.println(classes);
    }

    @Test
    void testHotelRoomTypes_ToString() {
        String roomType = HotelRoomTypes.values().toString();
        System.out.println(roomType);
    }
}
