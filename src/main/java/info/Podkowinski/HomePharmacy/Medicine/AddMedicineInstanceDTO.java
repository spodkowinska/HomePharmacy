package info.Podkowinski.HomePharmacy.Medicine;

import java.sql.Date;


public class AddMedicineInstanceDTO {

    private int id;

    private Long medicine_id;

    private Integer quantityLeft;

    private Date expiryDate;

    private Double price;

    private boolean visible = true;

    private String userId;


    public AddMedicineInstanceDTO(int id, Long medicine_id, Integer quantityLeft, Date expiryDate, Double price, boolean visible) {
        this.id = id;
        this.medicine_id = medicine_id;
        this.quantityLeft = quantityLeft;
        this.expiryDate = expiryDate;
        this.price = price;
        this.visible = visible;
    }

    public AddMedicineInstanceDTO() {
    }

    //getters and setters

    public String getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(Integer quantityLeft) {
        this.quantityLeft = quantityLeft;
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

    public void setMedicine_id(Long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
