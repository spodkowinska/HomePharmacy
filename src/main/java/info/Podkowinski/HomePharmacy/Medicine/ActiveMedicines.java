package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;

import javax.persistence.*;

@Entity
@Table(name = "active_medicines")
public class ActiveMedicines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicine_instance_id", insertable = false, updatable = false)
    private MedicineInstance medicineInstance;

//    private Long medicine_instance_id;

    @ManyToOne
    @JoinColumn(name = "family_member_id", insertable = false, updatable = false)
    private FamilyMember familyMember;

//    private Long family_member_id;

    private boolean isActive;

    private Integer quantityPerDay;

    private Integer howOften;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineInstance getMedicineInstance() {
        return medicineInstance;
    }

    public void setMedicineInstance(MedicineInstance medicineInstance) {
        this.medicineInstance = medicineInstance;
    }

    public FamilyMember getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(FamilyMember familyMember) {
        this.familyMember = familyMember;
    }

//    public Long getMedicine_instance_id() {
//        return medicine_instance_id;
//    }
//
//    public void setMedicine_instance_id(Long medicine_instance_id) {
//        this.medicine_instance_id = medicine_instance_id;
//    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(Integer quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }

    public Integer getHowOften() {
        return howOften;
    }

    public void setHowOften(Integer howOften) {
        this.howOften = howOften;
    }
}
