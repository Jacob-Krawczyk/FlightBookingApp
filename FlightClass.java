/**
 * Flight Application
 * @author JavaFine
 */
public enum FlightClass {
   ECONOMY("Economy"),
   PREMIUM_ECONOMY("Premium Economy"),
   FIRST_CLASS("First Class"),
   BUSINESS("Business");
   
   private final String textForm;

   private FlightClass(String textForm) {
        this.textForm = textForm;
    }

   public String toString() {
      return textForm;
   }
}
