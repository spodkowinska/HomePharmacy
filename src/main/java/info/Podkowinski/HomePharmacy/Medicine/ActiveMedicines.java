package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.User.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "active_medicines")
public class ActiveMedicines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "medicine_instance_id", referencedColumnName = "id")
    private MedicineInstance medicineInstance;

    @ManyToOne(cascade=CascadeType.ALL)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "family_member_id", referencedColumnName = "id")
    private FamilyMember familyMember;

    //    @ManyToOne(optional = false)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer quantityPerDay; //3  localhost..../pillTaken

    private LocalDate eatAtDate;

    private Integer howOften;

    private Integer alreadyTaken; //0

    private boolean hidden;

    private boolean allTakenOnTime;

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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

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
}
