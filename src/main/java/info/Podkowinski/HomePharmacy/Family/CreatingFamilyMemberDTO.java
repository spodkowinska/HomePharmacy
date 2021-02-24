package info.Podkowinski.HomePharmacy.Family;

import java.util.List;

public class CreatingFamilyMemberDTO {
    private String name;
    private String notes;
    private int age;
    private List<Integer> medicineIds;


    public CreatingFamilyMemberDTO(String name, String notes, int age, List<Integer> medicineIds) {
        this.name = name;
        this.notes = notes;
        this.age = age;
        this.medicineIds = medicineIds;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getMedicineIds() {
        return medicineIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMedicineIds(List<Integer> medicineIds) {
        this.medicineIds = medicineIds;
    }
}
