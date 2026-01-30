package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@DiscriminatorValue("teacher")
public class Teacher extends Person{
    @Column(name = "teacherCode")
    private String teacherCode;

    public Teacher() {
    }

    public Teacher(int id, String name, String surname, int phoneNumber, String teacherCode) {
        super(id, name, surname, phoneNumber);
        this.teacherCode = teacherCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }
}
