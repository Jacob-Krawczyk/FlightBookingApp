/**
 * List of Amenities
 * @author JavaFine
 */
/**
 * This is the ennumeration stores all of the
 * different ammenities a hotel can have
 */
public enum Amenities{
    POOL("Pool"),
    GYM("Gym"),
    TOILETRIES("Toiletries"),
    COFFEEKIT("Coffee Kit"),
    WIFI("Wifi"),
    PARKING("Parking"),
    SMOKE("Smoke"),
    MEAL("Meals");

    private final String textForm;
    
/**
 * This method converts the values into strings
 * @param textForm
 */
    private Amenities(String textForm) {
        this.textForm = textForm;
    }

    public String toString() {
        return textForm;
    }
}
