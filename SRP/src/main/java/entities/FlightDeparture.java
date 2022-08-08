package entities;

public class FlightDeparture {
    public String departureTime; // hh:mm
    public int price;

    public FlightDeparture(String departureTime, int price) {
        this.departureTime = departureTime;
        this.price = price;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
