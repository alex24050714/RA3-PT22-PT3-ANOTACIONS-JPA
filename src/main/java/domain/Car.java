package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends Vehicle{
    @Column(name = "door")
    private int door;
    @Column(name = "seats")
    private int seats;

    public Car() {
    }

    public Car(String brand, int year, float price, int door, int seats) {
        super(brand, year, price);
        this.door = door;
        this.seats = seats;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
