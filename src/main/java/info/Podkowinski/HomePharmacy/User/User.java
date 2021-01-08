package info.Podkowinski.HomePharmacy.User;

import info.Podkowinski.HomePharmacy.Medicine.Medicine;
import info.Podkowinski.HomePharmacy.Sickness.Sickness;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JoinColumn(name = "sickness_id")
    private List<Sickness> sicknesses;

    @ManyToMany
    @JoinColumn(name = "medicine_id")
    private List<Medicine> medicines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sickness> getSicknesses() {
        return sicknesses;
    }

    public void setSicknesses(List<Sickness> sicknesses) {
        this.sicknesses = sicknesses;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
