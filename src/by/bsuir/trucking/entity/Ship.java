package by.bsuir.trucking.entity;

import java.util.Date;

/**
 * Created by ASUS on 02.04.2017.
 */
public class Ship extends Entity {
    private int id;
    private float maxWeight;
    private Date departureDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
