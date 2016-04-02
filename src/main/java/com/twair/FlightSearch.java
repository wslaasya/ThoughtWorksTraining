package com.twair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearch {

    private List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public FlightSearch byLocation(String source, String destination) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }

    public FlightSearch byAvailability(int numberOfSeats) {
        if(numberOfSeats < 0) {
            throw new IllegalArgumentException("Availability should be mentioned");
        }

        List<Flight> matchingFlights = new ArrayList<Flight>();
        for(Flight flight : flightList) {
            if(flight.getNumberOfSeatsInPlane() >= numberOfSeats) {
                matchingFlights.add(flight);
            }
        }

        return new FlightSearch(matchingFlights);
    }

    public FlightSearch byDepartureDate(Date date) {
        if(date == null) {
            return new FlightSearch(flightList);
        }

        List<Flight> matchingFlights = new ArrayList<Flight>();
        for(Flight flight : flightList) {
            if(date.compareTo(flight.getStartDate()) == 0) {
                matchingFlights.add(flight);
            }
        }

        return new FlightSearch(matchingFlights);
    }

    public FlightSearch byClassTypeSeatsAvailability(String classType, int seatsRequired) {
        if (classType == null || classType.isEmpty()) {
            throw new IllegalArgumentException("Class type should be mentioned");
        }

        List<Flight> matchingFlights = new ArrayList<Flight>();
        for(Flight flight : flightList) {
            if(flight.getNumberOfSeatsPerClass(classType) >= seatsRequired) {
                matchingFlights.add(flight);
            }
        }

        return new FlightSearch(matchingFlights);
    }
}
