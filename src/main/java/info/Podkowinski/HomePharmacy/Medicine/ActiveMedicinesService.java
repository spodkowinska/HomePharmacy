package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.Family.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveMedicinesService {
//    @Autowired
//    private MedicineInstanceRepository medicineInstanceRepository;
//
    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private MedicineInstanceRepository medicineInstanceRepository;



    @Autowired
    private ActiveMedicinesRepository activeMedicinesRepository;

    public void addActiveMedicine(ActiveMedicines activeMedicines) {
        activeMedicinesRepository.save(activeMedicines);
    }

    public FamilyMember findById(Long id) {
        return familyRepository.findById(id).orElse(null);
    }

    public MedicineInstance findMedicineInstanceById(Long id) {
        return medicineInstanceRepository.findById(id).orElse(null);
    }
}
