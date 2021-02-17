package info.Podkowinski.HomePharmacy.Family;

import java.util.List;

public class CreatingFamilyMemberDTO {
    private String name;
    private String surname;
    private int age;
    private List<Integer> medicineIds;


    public CreatingFamilyMemberDTO(String name, String surname, int age, List<Integer> medicineIds) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.medicineIds = medicineIds;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMedicineIds(List<Integer> medicineIds) {
        this.medicineIds = medicineIds;
    }
}
