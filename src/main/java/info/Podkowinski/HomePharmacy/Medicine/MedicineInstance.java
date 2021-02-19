package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.sql.Date;


@Entity
@Table (name = "medicine_instances")
public class MedicineInstance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    private Integer quantityLeft;

    @ManyToOne
    private FamilyMember whomWasItPrescribed;

    private Date expiryDate;

    private Double price;

    @Column(name = "is_visible", columnDefinition = "boolean default true")
    private boolean visible;

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Integer getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(Integer quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public FamilyMember getWhomWasItPrescribed() {
        return whomWasItPrescribed;
    }

    public void setWhomWasItPrescribed(FamilyMember whomWasItPrescribed) { this.whomWasItPrescribed = whomWasItPrescribed; }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
