/**
 * Flight Application
 * @author JavaFine
 */

 public class Seat {
    private boolean occupied;
    private String seatNumber;

    public Seat(boolean occupied, String seatNumber) {
        this.setOccupied(occupied);
        this.setSeatNumber(seatNumber);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
 } 