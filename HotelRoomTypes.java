/**
 * Flight Application
 * @author JavaFine
 */
/**
 * This is the ennumeration that stores all of the different 
 * types of hotel rooms
 */
public enum HotelRoomTypes {
    SUITE("Suite"),
    STANDARD("Standard"),
    ROOM_ONLY("Room Only"),
    CONNECTING("Connecting"),
    MINIMALIST("Minimalist"),
    DELUXE("Deluxe"),
    STUDIO("Studio");

    private final String textForm;

/**
 * This method converts the values into strings
 * @param textForm
 */
    private HotelRoomTypes(String textForm) {
        this.textForm = textForm;
    }

    public String toString() {
        return textForm;
    }
}
