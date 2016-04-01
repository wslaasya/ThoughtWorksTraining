package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FlightSearchTests {
    private String source;
    private String destination;
    private FlightSearch allFlights;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        Plane plane1 = new Plane("type1", 10);
        Flight flight1 = new Flight("F001", source, destination, plane1);
        Flight flight2 = new Flight("F002", "TestSource1", destination, plane1);
        Flight flight3 = new Flight("F003", source, destination, plane1);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        allFlights = new FlightSearch(flightList);
    }

    @Test
    public void shouldReturnListOfFlightsForMatchingSourceDestination() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource() throws Exception {
        allFlights.byLocation(null, destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty() throws Exception {
        allFlights.byLocation("", destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination() throws Exception {
        allFlights.byLocation(source, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty() throws Exception {
        allFlights.byLocation(source, "");
    }

    @Test
    public void testNumberOfPassengers() {
        FlightSearch dearch = allFlights.byAvailability(source,destination,5);
        List<Flight> flights = dearch.getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test
    public void testNumberOfPassengers_WhenNumberOfSeatsNotSpecified() {
        FlightSearch dearch = allFlights.byAvailability(source,destination,0);
        List<Flight> flights = dearch.getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test
    public void testNumberOfPassengers_WhenMoreSeatsThanAvailabilityAreRequested() {
        FlightSearch dearch = allFlights.byAvailability(source,destination,15);
        List<Flight> flights = dearch.getFlightList();
        Assert.assertEquals(0, flights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource_SearchByAvailability() throws Exception {
        allFlights.byAvailability(null, destination,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty_SearchByAvailability() throws Exception {
        allFlights.byAvailability("", destination,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination_SearchByAvailability() throws Exception {
        allFlights.byAvailability(source, null,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty_SearchByAvailability() throws Exception {
        allFlights.byAvailability(source, "",1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void availabilityShouldNotBeNegative_SearchByAvailability() throws Exception {
        allFlights.byAvailability(source, destination,-100);
    }
}
