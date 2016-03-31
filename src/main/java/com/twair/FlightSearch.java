package com.twair;

import java.util.ArrayList;
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

    public FlightSearch byAvailability(String source, String dstination , int numberOfSeats) {
        if(numberOfSeats == 0) {
            numberOfSeats = 1;
        }

        List<Flight> flightLists = byLocation(source , dstination).getFlightList();

        List<Flight> matchingFlights = new ArrayList<Flight>();
        for(Flight flight : flightLists) {
            if(Integer.parseInt(flight.getNumber()) >= numberOfSeats) {
                matchingFlights.add(flight);
            }
        }

        return new FlightSearch(matchingFlights);
    }
}
