package info.Podkowinski.HomePharmacy.Medicine;

public class AddMedicineDTO {
    private int id;

    private String name;

    private String description;

    private boolean isPrescriptionNeeded;

    private boolean isSteroid;

    private boolean isAntibiotic;

    private boolean isVitamin;

    private boolean isToBuy;

    private Double officialPrice;

    private String userId;

    private String notes;

    public AddMedicineDTO(int id, String name, String userId, String description, boolean isPrescriptionNeeded, boolean isSteroid, boolean isAntibiotic, boolean isVitamin, boolean isToBuy, Double officialPrice, String notes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isPrescriptionNeeded = isPrescriptionNeeded;
        this.isSteroid = isSteroid;
        this.isAntibiotic = isAntibiotic;
        this.isVitamin = isVitamin;
        this.isToBuy = isToBuy;
        this.officialPrice = officialPrice;
        this.userId = userId;
        this.notes = notes;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = userId;
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

    public void setIsSteroid(boolean isSteroid) {
        this.isSteroid = isSteroid;
    }

    public boolean getIsAntibiotic() {
        return isAntibiotic;
    }

    public void setAntibiotic(boolean antibiotic) {
        isAntibiotic = antibiotic;
    }

    public boolean getIsVitamin() {
        return isVitamin;
    }

    public void setIsVitamin(boolean isVitamin) {
        this.isVitamin = isVitamin;
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

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
