package entities;

import java.util.HashMap;

public class Flights {

    private String departure; //FlightDeparture airport
    private String arrival; // arrival airport
    private String date; // yyyy-mm
    private HashMap<String, Integer> departures;

    public Flights(String departure, String arrival, String date, HashMap<String, Integer> departures) {
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.departures = departures;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<String, Integer> getDepartures() {
        return departures;
    }

    public void setDepartures(HashMap<String, Integer> departures) {
        this.departures = departures;
    }
}
