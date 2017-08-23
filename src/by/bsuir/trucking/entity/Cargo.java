package by.bsuir.trucking.entity;

public class Cargo extends Entity {
    private int id;
    private float weight;
    private float price;
    private int userId;
    private int shipId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getShipId() { return shipId; }

    public void setShipId(int shipId) { this.shipId = shipId; }

}
