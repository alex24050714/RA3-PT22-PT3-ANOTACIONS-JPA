package domain;

import javax.persistence.*;

@Entity
@Table(name = "professor")
public class Person {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

}
