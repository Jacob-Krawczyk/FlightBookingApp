import org.junit.jupiter.api.Test;


/**
 * testing All Enum ToStrings
 * @author JavaFine
 */

 public class EnumTest {
     @Test
     void testAccesibilityToString() {
         String accessibility = Accessibility.values().toString();
         System.out.println(accessibility);
     }
     @Test
     void testAirlineCompanyToString() {
        String comp = AirlineCompany.values().toString();
        System.out.println(comp);
     }
     @Test
     void testAmenitiesToString() {
        String amenities = Amenities.values().toString();
        System.out.println(amenities);
     }
     @Test
     void testFlightClassToString() {
        String classes = FlightClass.values().toString();
        System.out.println(classes);  
     }
     @Test
     void testHotelRoomToString() {
        String roomType = HotelRoomTypes.values().toString();
        System.out.println(roomType);
     }
 }
