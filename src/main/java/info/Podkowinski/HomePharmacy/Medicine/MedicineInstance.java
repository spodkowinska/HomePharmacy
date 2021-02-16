package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.User.User;

import javax.persistence.*;
import java.sql.Date;



@Entity
@Table (name = "medicine_instances")
public class MedicineInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicine_id", insertable = false, updatable = false)
    private Medicine medicine;

    private Long medicine_id;

    private Integer quantityLeft;

    private Integer quantityPerPackage;

    private Date dateOfPurchase;

    @ManyToOne
    private User whomWasItPrescribed;

    private Date expiryDate;

    private Double price;

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

    public Integer getQuantityPerPackage() {
        return quantityPerPackage;
    }

    public void setQuantityPerPackage(Integer quantityPerPackage) {
        this.quantityPerPackage = quantityPerPackage;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public User getWhomWasItPrescribed() {
        return whomWasItPrescribed;
    }

    public void setWhomWasItPrescribed(User whomWasItPrescribed) {
        this.whomWasItPrescribed = whomWasItPrescribed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id2(Long medicine_id2) {
        this.medicine_id = medicine_id;
    }
}
