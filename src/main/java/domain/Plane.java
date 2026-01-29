package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "plane")
public class Plane extends Vehicle{
    @Column(name = "tailNumber")
    private int tailNumber;
    @Column(name = "autopilot")
    private boolean autopilot;

    public Plane() {
    }

    public Plane(String brand, int year, float price, int tailNumber, boolean autopilot) {
        super(brand, year, price);
        this.tailNumber = tailNumber;
        this.autopilot = autopilot;
    }

    public int getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(int tailNumber) {
        this.tailNumber = tailNumber;
    }

    public boolean isAutopilot() {
        return autopilot;
    }

    public void setAutopilot(boolean autopilot) {
        this.autopilot = autopilot;
    }
}
