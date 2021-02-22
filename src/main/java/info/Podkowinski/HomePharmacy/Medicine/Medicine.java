package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.User.User;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.util.List;


@Entity

public class Medicine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 5000)
    private String description;

    private boolean isPrescriptionNeeded;

    private boolean isSteroid;

    private boolean isAntibiotic;

    private boolean isVitamin;

    private boolean isToBuy;

    private Double officialPrice;

    @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private List <MedicineAlternative> alternatives;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean getIsPrescriptionNeeded() {
        return isPrescriptionNeeded;
    }

    public void setIsPrescriptionNeeded(boolean prescriptionNeeded) {
        isPrescriptionNeeded = prescriptionNeeded;
    }

    public boolean getIsSteroid() {
        return isSteroid;
    }

    public void setIsSteroid(boolean steroid) {
        isSteroid = steroid;
    }

    public boolean getIsAntibiotic() {
        return isAntibiotic;
    }

    public void setIsAntibiotic(boolean antibiotic) {
        isAntibiotic = antibiotic;
    }


    public boolean getIsToBuy() {
        return isToBuy;
    }

    public void setIsToBuy(boolean toBuy) {
        isToBuy = toBuy;
    }

    public boolean getIsVitamin() {
        return isVitamin;
    }

    public void setIsVitamin(boolean vitamin) {
        isVitamin = vitamin;
    }

    public Double getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(Double officialPrice) {
        this.officialPrice = officialPrice;
    }

    public List<MedicineAlternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<MedicineAlternative> alternatives) {
        this.alternatives = alternatives;
    }
}
