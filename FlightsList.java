import java.util.ArrayList;
import java.util.EnumSet;
import java.util.UUID;

/**
 * A Singleton Listing of Flights
 * 
 * @author JavaFine
 */
public class FlightsList {
  private FlightDatabaseLoader flightLoader;
  private FlightDatabaseWriter flightWriter;
  private ArrayList<Flight> flights;
  private static FlightsList flightList;

  /**
   * Returns instance of flights list
   * 
   * @return flights list
   */
  public static FlightsList getInstance() {
    if (flightList == null) {
      flightList = new FlightsList();
    }
    return flightList;
  }

  /**
   * Returns a single flight by UUID
   * 
   * @param id
   * @return flight
   */
  public Flight getFlightByUUID(UUID id) {
    for (Flight flight : flights) {
      if (flight.getID().equals(id))
        return flight;
    }
    return null;
  }

  /**
   * Returns list of all flights
   * 
   * @return all flights
   */
  public ArrayList<Flight> getAllFlights() {
    flights = flightLoader.getFlight();
    return flights;
  }

  public String getFourMatches(String departLocation, String destination,
      ArrayList<String> airline) {
    Flight single = getOneSingleFlight(departLocation, destination, airline);
    ArrayList<ArrayList<Flight>> singleTransfers = new ArrayList<ArrayList<Flight>>();
    getTwoConnectingFlights(singleTransfers, departLocation, destination, airline);
    ArrayList<Flight> firstSingleTransfer = singleTransfers.get(0);
    ArrayList<Flight> secondSingleTransfer = singleTransfers.get(1);
    ArrayList<Flight> twoTransfer = getOneTwoTransfer(departLocation, destination, airline);
    return "Flight 1. " + single.toString() + "\nFlight 2. " + firstSingleTransfer.toString()
        + "\nFlight 3. " + secondSingleTransfer.toString() + "\nFlight 4. "
        + twoTransfer.toString();
  }

  public Flight getFirstMatch(String departLocation, String destination,
      ArrayList<String> airline) {
    return getOneSingleFlight(departLocation, destination, airline);
  }

  public ArrayList<Flight> getSecondMatch(String departLocation, String destination,
      ArrayList<String> airline) {
    ArrayList<ArrayList<Flight>> singleTransfers = new ArrayList<ArrayList<Flight>>();
    getTwoConnectingFlights(singleTransfers, departLocation, destination, airline);
    return singleTransfers.get(0);
  }

  public ArrayList<Flight> getThirdMatch(String departLocation, String destination,
      ArrayList<String> airline) {
    ArrayList<ArrayList<Flight>> singleTransfers = new ArrayList<ArrayList<Flight>>();
    getTwoConnectingFlights(singleTransfers, departLocation, destination, airline);
    return singleTransfers.get(1);
  }

  public ArrayList<Flight> getFourthMatch(String departLocation, String destination,
      ArrayList<String> airline) {
    return getOneTwoTransfer(departLocation, destination, airline);
  }

  private ArrayList<Flight> getOneTwoTransfer(String departLocation, String destination,
      ArrayList<String> airline) {
    ArrayList<ArrayList<Flight>> twoTransfers = new ArrayList<ArrayList<Flight>>();
    getThreeConnectingFlights(twoTransfers, departLocation, destination, airline);
    return twoTransfers.get(0);
  }

  private Flight getOneSingleFlight(String departLocation, String destination,
      ArrayList<String> airline) {
    for (Flight flight : flights) {
      if (flight.getDepartLocation().equals(departLocation)
          && flight.getDestination().equals(destination) && checkAirline(airline)) {
        return flight;
      }
    }
    return null;
  }

  private boolean checkAirline(ArrayList<String> airline) {
    EnumSet<AirlineCompany> airlineList = EnumSet.allOf(AirlineCompany.class);
    for (String air : airline) {
      for (AirlineCompany comp : airlineList) {
        if (comp.toString().equals(air)) {
          return true;
        }
      }
    }
    return false;
  }

  public ArrayList<Flight> getSingles(String departLocation, String destination,
      ArrayList<String> airline) {
    ArrayList<Flight> returnList = new ArrayList<Flight>();
    getFlightsGen(returnList, departLocation, destination);
    getFlightByAirline(returnList, airline);
    return returnList;
  }

  public ArrayList<ArrayList<Flight>> getConnectingFlights(String departLocation,
      String destination, ArrayList<String> airline) {
    ArrayList<ArrayList<Flight>> returnList = new ArrayList<ArrayList<Flight>>();
    getTwoConnectingFlights(returnList, departLocation, destination, airline);
    getThreeConnectingFlights(returnList, departLocation, destination, airline);
    return returnList;
  }

  public void getThreeConnectingFlights(ArrayList<ArrayList<Flight>> returnList,
      String departLocation, String destination, ArrayList<String> airline) {
    ArrayList<Flight> init = getFlightByDepartLocation(airline, departLocation);
    ArrayList<Flight> fin = getFlightByDestination(airline, destination);
    ArrayList<Flight> between = new ArrayList<Flight>();
    getFlightsGen(between, departLocation, destination);
    for (Flight i : init) {
      for (Flight bet : between) {
        if (i.getDestination().equals(bet.getDepartLocation())) {
          for (Flight f : fin) {
            if (bet.getDestination().equals(f.getDepartLocation())) {
              ArrayList<Flight> threeFlights = new ArrayList<Flight>();
              threeFlights.add(i);
              threeFlights.add(bet);
              threeFlights.add(f);
              returnList.add(threeFlights);
            }
          }
        }
      }
    }
  }

  public void getTwoConnectingFlights(ArrayList<ArrayList<Flight>> returnList,
      String departLocation, String destination, ArrayList<String> airline) {
    ArrayList<Flight> initial = getFlightByDestination(airline, destination);
    ArrayList<Flight> check = getFlightByDepartLocation(airline, departLocation);
    for (Flight init : initial) {
      for (Flight ch : check) {
        ArrayList<Flight> twoFlights = new ArrayList<Flight>();
        if (init.getDepartLocation().equals(ch.getDestination())) {
          twoFlights.add(init);
          twoFlights.add(ch);
          returnList.add(twoFlights);
        }
      }
    }
  }

  /**
   * Removes flights based on airline
   * 
   * @param filterList
   * @param airline
   */
  public void getFlightByAirline(ArrayList<Flight> filterList, ArrayList<String> airline) {
    EnumSet<AirlineCompany> airlineList = EnumSet.allOf(AirlineCompany.class);
    ArrayList<String> removeList = new ArrayList<String>();
    for (AirlineCompany comp : airlineList) {
      removeList.add(comp.toString());
    }
    removeList.removeAll(airline);
    for (Flight flight : flights) {
      for (String rem : removeList) {
        if (flight.getAirline().equals(rem)) {
          filterList.remove(flight);
        }
      }
    }
  }

  /**
   * Returns list of flights filtered by destination and airline
   * 
   * @param airline
   * @param destination
   * @return array list of flights
   */
  public ArrayList<Flight> getFlightByDestination(ArrayList<String> airline, String destination) {
    ArrayList<Flight> flightByDest = new ArrayList<Flight>();
    for (Flight flight : flights) {
      if (flight.getDestination().equals(destination)) {
        flightByDest.add(flight);
      }
    }
    getFlightByAirline(flightByDest, airline);
    return flightByDest;
  }

  /**
   * Returns list of flights filtered by departure location and airline
   * 
   * @param airline
   * @param departLocation
   * @return array list of flights
   */
  public ArrayList<Flight> getFlightByDepartLocation(ArrayList<String> airline,
      String departLocation) {
    ArrayList<Flight> flightByDepart = new ArrayList<Flight>();
    for (Flight flight : flights) {
      if (flight.getDepartLocation().equals(departLocation)) {
        flightByDepart.add(flight);
      }
    }
    getFlightByAirline(flightByDepart, airline);
    return flightByDepart;
  }

  /**
   * Adds flights based on departure location and destination
   */
  public void getFlightsGen(ArrayList<Flight> returnList, String departLocation,
      String destination) {
    for (Flight flight : flights) {
      if (flight.getDepartLocation().equals(departLocation)
          && flight.getDestination().equals(destination)) {
        returnList.add(flight);
      }
    }
  }

  /**
   * Returns list of available seats on flight
   * 
   * @param flight
   * @return
   */
  public void getAvailableSeats(Flight flight) {
    ArrayList<Seat> flightSeats = flights.get(0).getFlightSeats();
    for (Seat seat : flightSeats) {
      if (!seat.isOccupied()) {
        System.out.println(seat.toString());
      }
    }
  }

  /**
   * Returns seat based on seat number
   * 
   * @param flight
   * @param seatNum
   * @return
   */
  public Seat getSeatBySeatNumber(Flight flight, String seatNum) {
    ArrayList<Seat> seats = flight.getFlightSeats();
    for (Seat seat : seats) {
      if (seat.getSeatNumber().equals(seatNum)) {
        return seat;
      }
    }
    return null;
  }

  public void cancelFlight(UUID UUID) {
    for (Flight flight : flights) {
      if (flight.getID().equals(UUID)) {
        int pos = this.flights.indexOf(flight);
        flights.remove(pos);
      }
    }
  }

  public void bookFlight(Flight flight) {
    this.flights.add(flight);
  }

}
