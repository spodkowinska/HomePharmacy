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

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "medicine_id")
    private List<Medicine> medicines;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

}
