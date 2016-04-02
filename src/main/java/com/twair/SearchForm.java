package com.twair;

import java.util.Date;

public class SearchForm {
    private String from;
    private String to;
    private String number;
    private int passengers;
    private Date departureDate;
    private String classType;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
