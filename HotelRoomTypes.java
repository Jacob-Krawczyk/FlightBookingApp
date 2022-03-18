/**
 * Flight Application
 * @author JavaFine
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

    private HotelRoomTypes(String textForm) {
        this.textForm = textForm;
    }

    public String toString() {
        return textForm;
    }
}
