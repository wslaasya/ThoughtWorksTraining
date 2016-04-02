package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FlightSearchTests {
    private String source;
    private String destination;
    private FlightSearch allFlights;

    private final Date date1 = Calendar.getInstance().getTime();

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        Plane plane1 = new Plane("type1", 10);
        Flight flight1 = new Flight("F001", source, destination, plane1);
        flight1.setStartDate(date1);
        Flight flight2 = new Flight("F002", "TestSource1", destination, plane1);
        flight2.setStartDate(date1);
        Flight flight3 = new Flight("F003", source, destination, plane1);
        flight3.setStartDate(date1);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        allFlights = new FlightSearch(flightList);
    }

    @Test
    public void shouldReturnListOfFlightsForMatchingSourceDestination() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());Assert.assertEquals(destination, flights.get(0).getDestination());
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
        FlightSearch dearch = allFlights.byAvailability(5);
        List<Flight> flights = dearch.getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals("TestSource1", flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(source, flights.get(2).getSource());
        Assert.assertEquals(destination, flights.get(2).getDestination());
        Assert.assertEquals(3, flights.size());
    }

    @Test
    public void testNumberOfPassengers_WhenNumberOfSeatsNotSpecified() {
        FlightSearch dearch = allFlights.byAvailability(0);
        List<Flight> flights = dearch.getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals("TestSource1", flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(source, flights.get(2).getSource());
        Assert.assertEquals(destination, flights.get(2).getDestination());
        Assert.assertEquals(3, flights.size());
    }

    @Test
    public void testNumberOfPassengers_WhenMoreSeatsThanAvailabilityAreRequested() {
        FlightSearch dearch = allFlights.byAvailability(15);
        List<Flight> flights = dearch.getFlightList();
        Assert.assertEquals(0, flights.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void availabilityShouldNotBeNegative_SearchByAvailability() throws Exception {
        allFlights.byAvailability(-100);
    }

    @Test
    public void fetchFlightsBasedOnDepartureDate() {
        List<Flight> flightsList = allFlights.byDepartureDate(date1).getFlightList();
        Assert.assertEquals(3,flightsList.size());
    }

    @Test
    public void nullDepartureDateShouldReturnAllFlights() {
        List<Flight> flightsList = allFlights.byDepartureDate(null).getFlightList();
        Assert.assertEquals(3,flightsList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void classTypeShouldBeSpecified() {
        String classType = null;
        int seatsRequired = 10;
        allFlights.byClassTypeSeatsAvailability(classType , seatsRequired);
    }

    @Test
    public void fetchFlightsBasedOnClassTypeSeatsAvailability() {
        String classTypeName = "Economy";
        int seatsRequired = 10;

        allFlights.getFlightList().get(0).setClasTypeInfo("Economy" , 30);
        allFlights.getFlightList().get(1).setClasTypeInfo("Economy" , 3);
        allFlights.getFlightList().get(2).setClasTypeInfo("Economy" , 32);

        List<Flight> flightsList = allFlights.byClassTypeSeatsAvailability(classTypeName , seatsRequired).getFlightList();
        Assert.assertEquals(2,flightsList.size());
    }
}
