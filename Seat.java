/**
 * Flight Application
 * @author JavaFine
 */

 public class Seat {
    private boolean occupied;
    private String seatNumber;
/**
 * The following methods are how we go about getting whether 
 * or not the seat is occupied and the seats number
 * @param occupied
 * @param seatNumber
 */
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