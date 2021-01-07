package info.Podkowinski.HomePharmacy.Sickness;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "illnesses")
public class Sickness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date startingDate;

    private int duration;

    private String doctor;

    private String description;
}
