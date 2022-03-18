/**
 * Airline Companies
 * @author JavaFine
 */
public enum AirlineCompany {
    AMERICAN_AIRLINE("American Airline"),
    DELTA("Delta"),
    SOUTHWEST_AIRLINES("Southwest Airlines"),
    UNITED_AIRLINES("United Airlines");

    private final String textForm;

    private AirlineCompany(String textForm) {
        this.textForm = textForm;
    }

    public String toString() {
        return textForm;
    }
}
