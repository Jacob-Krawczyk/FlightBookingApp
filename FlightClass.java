/**
 * Flight Application
 * @author JavaFine
 */
/**
 * This is the ennumeration that stores all of the different classes
 * you can sit in for flight
 */
public enum FlightClass {
   ECONOMY("Economy"),
   PREMIUM_ECONOMY("Premium Economy"),
   FIRST_CLASS("First Class"),
   BUSINESS("Business");
   
   private final String textForm;

/**
 * This method converts the values into strings
 * @param textForm
 */
   private FlightClass(String textForm) {
        this.textForm = textForm;
    }

   public String toString() {
      return textForm;
   }
}
