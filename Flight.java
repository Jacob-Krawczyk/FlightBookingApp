/**
 * Written by JavaFIne
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


    public Flight(UUID id, String departLocation, String destination, String departDate, String departTime,
            String arrivalTime, ArrayList<Seat> flightSeats, String airline) {
        this.id = id;
        this.departLocation = departLocation;
        this.destination = destination;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.flightSeats = flightSeats;
        this.airline = airline;
    }
 }
