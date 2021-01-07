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
    private Long id;

    private String name;

    @ManyToMany
    @JoinColumn(name = "sickness_id")
    private List<Sickness> sicknesses;

    @ManyToMany
    @JoinColumn(name = "medicine_id")
    private List<Medicine> medicines;
}
