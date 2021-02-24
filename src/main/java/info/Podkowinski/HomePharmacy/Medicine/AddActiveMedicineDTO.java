package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

public class AddActiveMedicineDTO {

    private Integer id;

    private Long medicineInstanceId;

    private Long familyMemberId;

    private Integer quantityPerDay;

    private LocalDate eatAtDate;

    private Integer howOften;

    private Integer alreadyTaken;

    private boolean hidden;

    private boolean allTakenOnTime;

    private String userId;


    public AddActiveMedicineDTO(Integer id, Long medicineInstanceId,
                                Long familyMemberId, LocalDate eatAtDate,
                                Integer quantityPerDay, Integer howOften, Integer alreadyTaken,
                                boolean hidden, boolean allTakenOnTime, String userId) {
        this.id = id;
        this.medicineInstanceId = medicineInstanceId;
        this.familyMemberId = familyMemberId;
        this.eatAtDate = eatAtDate;
        this.quantityPerDay = quantityPerDay;
        this.howOften = howOften;
        this.alreadyTaken = alreadyTaken;
        this.hidden = hidden;
        this.allTakenOnTime = allTakenOnTime;
        this.userId = userId;
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

    public LocalDate getEatAtDate() { return eatAtDate; }

    public void setEatAtDate(LocalDate eatAtDate) { this.eatAtDate = eatAtDate; }

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

    public Integer getAlreadyTaken() { return alreadyTaken; }

    public void setAlreadyTaken(Integer alreadyTaken) { this.alreadyTaken = alreadyTaken; }

    public boolean isHidden() { return hidden; }

    public void setHidden(boolean hidden) { this.hidden = hidden; }

    public boolean isAllTakenOnTime() { return allTakenOnTime; }

    public void setAllTakenOnTime(boolean allTakenOnTime) { this.allTakenOnTime = allTakenOnTime; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
