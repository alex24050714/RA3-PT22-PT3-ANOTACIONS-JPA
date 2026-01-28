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

    public Car(int id, String brand, int year, float price, int door, int seats) {
        super(id, brand, year, price);
        this.door = door;
        this.seats = seats;
    }

}
