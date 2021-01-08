package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.User.User;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date expiryDate;

    private Double price;

    private int quantityLeft;

    private String description;

    @ManyToMany
    private List<User> whomWasItPrescribed;

    @ColumnDefault(value = "false")
    private boolean isPrescriptionNeeded;

    @ColumnDefault(value = "false")
    private boolean isSteroid;

    @ColumnDefault(value = "false")
    private boolean isAntibiotic;

    @OneToMany
    private List<Medicine> alternatives;

    private boolean isToBuy;




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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getWhomWasItPrescribed() {
        return whomWasItPrescribed;
    }

    public void setWhomWasItPrescribed(List<User> whomWasItPrescribed) {
        this.whomWasItPrescribed = whomWasItPrescribed;
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

    public List<Medicine> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Medicine> alternatives) {
        this.alternatives = alternatives;
    }

    public boolean getIsToBuy() {
        return isToBuy;
    }

    public void setIsToBuy(boolean toBuy) {
        isToBuy = toBuy;
    }
}
