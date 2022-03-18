/**
 * Flight Application
 * @author JavaFine
 */

public enum Accessibility {
    SERVICE_ANIMAL("Service Animal"),
    HEARING_ACCESSABILITY_KIT("Hearing Accessibility Kit"),
    VISUAL_ACCESSABILITY_KIT("Visual Accessibility Kit"),
    VISUAL_FIRE_SMOKE_DETECTOR("Visual Fire Smoke Detector"),
    GRAB_BARS_IN_BATHROOM("Grab Bars in Bathroom"),
    LEVER_LOCK_SYSTEM("Lever Lock System"),
    ALTERNATIVE_TEXT_PLACARD("Alternative Text Placard"),
    SHOWER_SEATS("Shower Seats");

    private final String textForm;

    private Accessibility(String textForm) {
        this.textForm = textForm;
    }

    public String toSring() {
        return textForm;
    }
}
