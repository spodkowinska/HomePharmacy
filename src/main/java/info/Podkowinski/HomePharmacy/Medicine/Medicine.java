package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.User.User;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean isPrescriptionNeeded;

    private boolean isSteroid;

    private boolean isAntibiotic;

    private boolean isVitamin;

    private boolean isToBuy;

    private Double officialPrice;

    @ManyToOne
    private User user;

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

//    public List<Medicine> getAlternatives() {
//        return alternatives;
//    }
//
//    public void setAlternatives(List<Medicine> alternatives) {
//        this.alternatives = alternatives;
//    }

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
}
