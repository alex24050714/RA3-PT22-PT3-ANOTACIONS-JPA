package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@DiscriminatorValue("student")
public class Student extends Person{
    private String studentCode;

    public Student(int id, String name, String surname, int phoneNumber, String studentCode) {
        super(id, name, surname, phoneNumber);
        this.studentCode = studentCode;
    }
}
