package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@DiscriminatorValue("student")
public class Student extends Person{
    @Column(name = "studentCode")
    private String studentCode;

    public Student() {
    }

    public Student(int id, String name, String surname, int phoneNumber, String studentCode) {
        super(id, name, surname, phoneNumber);
        this.studentCode = studentCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}
