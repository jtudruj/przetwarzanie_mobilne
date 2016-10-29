package eu.jakubtudruj.secondapp;

/**
 * Created by kuba on 23/10/2016.
 */

public class ListItemEntity {
    String place;
    String date;
    String temperature;

    public ListItemEntity(String place, String date, String temperature) {
        this.place = place;
        this.date = date;
        this.temperature = temperature;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
