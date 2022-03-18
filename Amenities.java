/**
 * List of Amenities
 * @author JavaFine
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

    private Amenities(String textForm) {
        this.textForm = textForm;
    }

    public String toString() {
        return textForm;
    }
}
