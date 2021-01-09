package info.Podkowinski.HomePharmacy.Medicine;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class MedicineInstance {
    @Id
    private Long id;

    private Integer quantity;

    private Date expiryDate;


    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
