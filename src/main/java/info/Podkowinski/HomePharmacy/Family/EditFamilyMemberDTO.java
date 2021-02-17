package info.Podkowinski.HomePharmacy.Family;

import java.util.List;

public class EditFamilyMemberDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    private List<Integer> medicineIds;

    public EditFamilyMemberDTO(int id, String name, String surname, int age, List<Integer> medicineIds) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.medicineIds = medicineIds;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getMedicineIds() {
        return medicineIds;
    }

    public void setMedicineIds(List<Integer> medicineIds) {
        this.medicineIds = medicineIds;
    }
}
