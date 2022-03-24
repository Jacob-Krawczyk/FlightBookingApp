/**
 * Flight Application
 * @author JavaFine
 */

import java.util.ArrayList;
import java.util.UUID;

public class Flight {
  private UUID id;
  private String departLocation;
  private String destination;
  private String departDate;
  private String departTime;
  private String arrivalTime;
  private ArrayList<Seat> flightSeats;
  private String airline;


  public Flight(UUID id, String departLocation, String destination, String departDate,
      String departTime, String arrivalTime, ArrayList<Seat> flightSeats, String airline) {
    this.id = id;
    this.departLocation = departLocation;
    this.destination = destination;
    this.departDate = departDate;
    this.departTime = departTime;
    this.arrivalTime = arrivalTime;
    this.flightSeats = flightSeats;
    this.airline = airline;
  }

  public UUID getID() {
    return this.id;
  }

  public String getDepart() {
    return this.departLocation;
  }

  public String getDestination() {
    return this.destination;
  }

  public String getDepartDate() {
    return this.departDate;
  }

  public String getDepartTime() {
    return this.departTime;
  }

  public String getArrivalTime() {
    return this.getArrivalTime();
  }

  public ArrayList<Seat> getFlightSeats() {
    return this.getFlightSeats();
  }

  public String getAirline() {
    return this.airline;
  }


}