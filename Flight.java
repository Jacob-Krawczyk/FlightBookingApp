/**
 * Written by JavaFIne
 */

import java.util.ArrayList;

 public class Flight {
    private ArrayList <String> list_ofregisteredPlane;
    private int numofpassengers;
    private String departLocation;
    private String arrivalLocation;
    private int numofTicketsAvailable;
    private int totalTravelTime;
    private String airlineCompany;
    private String flightNumber;
    private String flightClass;
    private ArrayList<Seat> flightSeats;
    private boolean lapChild;
    private boolean pets;
    protected String arrivalTime;
    protected String departureTime;

    public Flight(numofpassenger, departureTime, arrivalTime, airlineCompany, flightNumber){
        numofpassengers = this.numofpassengers;
        departureTime = this.departureTime;
        arrivalTime = this.arrivalTime;
        airlineCompany = this.flightNumber;
    }
 }
