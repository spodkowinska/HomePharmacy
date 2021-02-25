package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.User.User;

import java.util.List;

public class MedicineForDisplayDTO {

    public MedicineForDisplayDTO() {
    }

    private User user;

    private Long id;

    private String name;

    private String description;

    private boolean isPrescriptionNeeded;

    private boolean isSteroid;

    private boolean isAntibiotic;

    private boolean isVitamin;

    private boolean isToBuy;

    private Double officialPrice;

    private List<FamilyMember> familyMembers;

    private List<MedicineAlternative> alternatives;

    private List<MedicineInstance> medicineInstances;

    private String notes;

    public MedicineForDisplayDTO(Long id, User user, String name, String description, boolean isPrescriptionNeeded, boolean isSteroid, boolean isAntibiotic, boolean isVitamin, boolean isToBuy, Double officialPrice, List<FamilyMember> familyMembers, List<MedicineAlternative> alternatives, String notes, List<MedicineInstance> medicineInstances) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.description = description;
        this.isPrescriptionNeeded = isPrescriptionNeeded;
        this.isSteroid = isSteroid;
        this.isAntibiotic = isAntibiotic;
        this.isVitamin = isVitamin;
        this.isToBuy = isToBuy;
        this.officialPrice = officialPrice;
        this.familyMembers = familyMembers;
        this.alternatives = alternatives;
        this.notes = notes;
        this.medicineInstances = medicineInstances;
    }


//    getters and setters below

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isPrescriptionNeeded() {
        return isPrescriptionNeeded;
    }

    public void setPrescriptionNeeded(boolean prescriptionNeeded) {
        isPrescriptionNeeded = prescriptionNeeded;
    }

    public boolean isSteroid() {
        return isSteroid;
    }

    public void setSteroid(boolean steroid) {
        isSteroid = steroid;
    }

    public boolean isAntibiotic() {
        return isAntibiotic;
    }

    public void setAntibiotic(boolean antibiotic) {
        isAntibiotic = antibiotic;
    }

    public boolean isVitamin() {
        return isVitamin;
    }

    public void setVitamin(boolean vitamin) {
        isVitamin = vitamin;
    }

    public boolean getIsToBuy() {
        return isToBuy;
    }

    public void setIsToBuy(boolean isToBuy) {
        this.isToBuy = isToBuy;
    }

    public Double getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(Double officialPrice) {
        this.officialPrice = officialPrice;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<MedicineAlternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<MedicineAlternative> alternatives) {
        this.alternatives = alternatives;
    }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }

    public List<MedicineInstance> getMedicineInstances() { return medicineInstances; }

    public void setMedicineInstances(List<MedicineInstance> medicineInstances) { this.medicineInstances = medicineInstances; }
}
