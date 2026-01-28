package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@DiscriminatorValue("teacher")
public class Teacher extends Person{
    private String teacherCode;

    public Teacher(int id, String name, String surname, int phoneNumber, String teacherCode) {
        super(id, name, surname, phoneNumber);
        this.teacherCode = teacherCode;
    }
}
