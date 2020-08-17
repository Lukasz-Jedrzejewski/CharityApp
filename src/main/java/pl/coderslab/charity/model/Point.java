package pl.coderslab.charity.model;

public class Point {

    private double lat;
    private double lon;
    private String message;

    public Point() {
    }

    public Point(double lat, double lon, String message) {
        this.lat = lat;
        this.lon = lon;
        this.message = message;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
