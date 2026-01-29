package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle{
    @Column(name = "hasSidecar")
    private boolean hasSidecar;

    public Motorcycle() {
    }

    public Motorcycle(String brand, int year, float price, boolean hasSidecar) {
        super(brand, year, price);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
