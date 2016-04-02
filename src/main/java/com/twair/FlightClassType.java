package com.twair;

/**
 * Created by wunul on 01-04-2016.
 */
public class FlightClassType {

    private String classType;
    private int seatsAvailable;

    public FlightClassType(String classType , int seatsAvailable) {
        this.classType = classType;
        this.seatsAvailable = seatsAvailable;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
