package com.twair;

import java.util.*;

public class DataSource {
    final private static DataSource dataSource = new DataSource();
    public static DataSource instance() {
        return dataSource;
    }

    public List<String> fetchLocations() {
        List<String> locations = new ArrayList<String>();
        locations.add("Hyderabad");
        locations.add("Bangalore");
        locations.add("Chennai");
        return locations;
    }

    public List<Plane> fetchPlanes() {
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane("Boeing777-200LR(77L)", 195));
        planes.add(new Plane("Airbus A321", 152));
        return planes;
    }

    public FlightSearch fetchFlights() throws Exception {
        Calendar cal = Calendar.getInstance();

        List<Flight> flightList = new ArrayList<>();
        List<Plane> planes = fetchPlanes();
        List<String> locations = fetchLocations();
        Flight flight1 = new Flight("F001", locations.get(0), locations.get(1), planes.get(0));
        cal.set(2016 , 4, 2);
        flight1.setStartDate(cal.getTime());
        flight1.setClasTypeInfo("Economy" , 20);
        flight1.setClasTypeInfo("Business" , 10);
        flight1.setClasTypeInfo("FirstClass" , 2);

        Flight flight2 = new Flight("F002", locations.get(0), locations.get(1), planes.get(1));
        cal.set(2016,04,02);
        flight2.setStartDate(cal.getTime());
        flight2.setClasTypeInfo("Economy" , 20);
        flight2.setClasTypeInfo("Business" , 10);
        flight2.setClasTypeInfo("FirstClass" , 2);

        Flight flight3 = new Flight("F003", locations.get(0), locations.get(1), planes.get(1));
        cal.set(2016,04,03);
        flight3.setStartDate(cal.getTime());
        flight3.setClasTypeInfo("Economy" , 20);
        flight3.setClasTypeInfo("Business" , 10);
        flight3.setClasTypeInfo("FirstClass" , 2);

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        FlightSearch allFlights = new FlightSearch(flightList);
        return allFlights;
    }

    public List<String> fetchClassTypes() {
        List<String> classTypes = new ArrayList<>();
        classTypes.add("Economy");
        classTypes.add("FirstClass");
        classTypes.add("Business");

        return classTypes;
    }
}
