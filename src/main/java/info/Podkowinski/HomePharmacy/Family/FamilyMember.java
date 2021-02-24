package info.Podkowinski.HomePharmacy.Family;



import info.Podkowinski.HomePharmacy.Medicine.Medicine;
import info.Podkowinski.HomePharmacy.User.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "family_members")
public class FamilyMember {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String notes;
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

    @ManyToOne
    private User user;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNotes() { return notes; }

    public void setNotes(String surname) { this.notes = notes; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

}
