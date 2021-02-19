package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;

public class AddActiveMedicineDTO {

    private Integer id;

    private Long medicineInstanceId;

    private Long familyMemberId;

    private boolean isActive;

    private Integer quantityPerDay;

    private Integer howOften;


    public AddActiveMedicineDTO(Integer id, Long medicineInstanceId,
                                Long familyMemberId, boolean isActive,
                                Integer quantityPerDay, Integer howOften) {
        this.id = id;
        this.medicineInstanceId = medicineInstanceId;
        this.familyMemberId = familyMemberId;
        this.isActive = isActive;
        this.quantityPerDay = quantityPerDay;
        this.howOften = howOften;
    }

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Long getMedicineInstanceId() {
        return medicineInstanceId;
    }

    public void setMedicineInstanceId(Long medicineInstanceId) {
        this.medicineInstanceId = medicineInstanceId;
    }

    public Long getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(Long familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

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
