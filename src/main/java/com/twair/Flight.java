package com.twair;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private Date startDate;
    private Map<String , FlightClassType> classTypes;

    public Flight(String number, String source, String destination, Plane plane) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.classTypes = new HashMap();
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberOfSeatsInPlane() { return plane.getNumberOfSeats(); }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfSeatsPerClass(String classType) {
        return this.classTypes.get(classType).getSeatsAvailable();
    }

    public void setClasTypeInfo(String classType , int seatsAvaiable) {
        FlightClassType classTypeInfo = new FlightClassType(classType , seatsAvaiable);
        this.classTypes.put(classType , classTypeInfo);
    }
}
