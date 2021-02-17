package info.Podkowinski.HomePharmacy.Family;

import info.Podkowinski.HomePharmacy.Medicine.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public void saveFamilyMember(FamilyMember familyMember) {
        familyRepository.save(familyMember);
    }

    public List<FamilyMember> findAll() { return familyRepository.findAll(); }

    public FamilyMember findById(long id) { return familyRepository.getOne(id); }

    public void deleteById(long id) { familyRepository.deleteById(id); }
}
