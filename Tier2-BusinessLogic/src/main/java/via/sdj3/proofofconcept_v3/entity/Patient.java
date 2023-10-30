package via.sdj3.proofofconcept_v3.entity;

import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    public Patient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patient() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
