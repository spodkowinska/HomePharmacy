package info.Podkowinski.HomePharmacy.Family;



import info.Podkowinski.HomePharmacy.Medicine.Medicine;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "family_members")
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int age;

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    private long medicine_id;

    @ManyToMany
    @JoinTable(
            name = "family_member_medicines",
            joinColumns = @JoinColumn(name = "family_member_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private List<Medicine> medicine;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

}
