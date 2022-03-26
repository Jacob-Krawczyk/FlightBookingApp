/**
 * Airline Companies
 * @author JavaFine
 */
/** 
 * This is the ennumeration is for all of the different airline companies
 */
public enum AirlineCompany {
    AMERICAN_AIRLINE("American Airline"),
    DELTA("Delta"),
    SOUTHWEST_AIRLINES("Southwest Airlines"),
    UNITED_AIRLINES("United Airlines");

    private final String textForm;
/**
 * This method converts the values into strings
 * @param textForm
 */
    private AirlineCompany(String textForm) {
        this.textForm = textForm;
    }

    public String toString() {
        return textForm;
    }
}
