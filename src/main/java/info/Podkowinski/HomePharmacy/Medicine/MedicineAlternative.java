package info.Podkowinski.HomePharmacy.Medicine;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "medicine_alternatives")
public class MedicineAlternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String urlLink;

    @Column(length = 5000)
    private String description;

    private boolean isAntibiotic;

    private boolean isSteroid;

    private boolean isPrescriptionNeeded;


// getters and setters

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

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String link) {
        this.urlLink = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsAntibiotic() {
        return isAntibiotic;
    }

    public void setIsAntibiotic(boolean antibiotic) {
        isAntibiotic = antibiotic;
    }

    public boolean getIsSteroid() {
        return isSteroid;
    }

    public void setIsSteroid(boolean steroid) {
        isSteroid = steroid;
    }

    public boolean getIsPrescriptionNeeded() {
        return isPrescriptionNeeded;
    }

    public void setIsPrescriptionNeeded(boolean prescriptionNeeded) {
        isPrescriptionNeeded = prescriptionNeeded;
    }
}

