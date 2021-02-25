package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.Family.FamilyRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActiveMedicinesService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private MedicineInstanceRepository medicineInstanceRepository;

    @Autowired
    private ActiveMedicinesRepository activeMedicinesRepository;

    public void addActiveMedicine(ActiveMedicines activeMedicines) {
        activeMedicinesRepository.save(activeMedicines);
    }

    public void updateActiveMedicine(ActiveMedicines updatedMedicine) { activeMedicinesRepository.save(updatedMedicine); }

    public ActiveMedicines findActiveMedicine(Long id) { return activeMedicinesRepository.findById(id).orElse(null); }

    public FamilyMember findById(Long id) {
        return familyRepository.findById(id).orElse(null);
    }

    public MedicineInstance findMedicineInstanceById(Long id) {
        return medicineInstanceRepository.findById(id).orElse(null);
    }

    public List<ActiveMedicines> getTodaysMedicines(String userId) {

        List<ActiveMedicines> activeMedicines = activeMedicinesRepository.findByUserId(userId);
        List<ActiveMedicines> todaysMedicines = new ArrayList<ActiveMedicines>();

        LocalDate now = LocalDate.now(); // yyyy-mm-dd

        for (int i = 0; i < activeMedicines.size(); i++) {

            ActiveMedicines currentMedicine = activeMedicines.get(i);

            if (currentMedicine.isHidden()) {
                if (now.isAfter(currentMedicine.getEatAtDate())) {
                    currentMedicine.setAlreadyTaken(0);
                    currentMedicine.setHidden(false);
                    currentMedicine.setEatAtDate(now);
                    updateActiveMedicine(currentMedicine);
                }
            }

            if (!currentMedicine.isHidden()) {
                if (currentMedicine.getAlreadyTaken() < currentMedicine.getQuantityPerDay()) {
                     if (now.isAfter(currentMedicine.getEatAtDate())) {
                        currentMedicine.setAlreadyTaken(0);
                        currentMedicine.setHidden(false);
                        currentMedicine.setEatAtDate(now);
                        updateActiveMedicine(currentMedicine);
                    }
                    if (now.equals(currentMedicine.getEatAtDate())) {
                        todaysMedicines.add(currentMedicine);
                    }
                } else {
                    currentMedicine.setHidden(true);
                    updateActiveMedicine(currentMedicine);
                }
            }
        }
        return todaysMedicines;
    }
}
