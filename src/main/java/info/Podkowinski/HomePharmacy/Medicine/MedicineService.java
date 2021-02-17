package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private MedicineInstanceRepository medicineInstanceRepository;

    public void saveMedicine(Medicine medicine){
        medicineRepository.save(medicine);
    }

    public List<Medicine> findAll(){
        return medicineRepository.findAll();
    }

    public Medicine findById(int id){
        return medicineRepository.getOne(Long.valueOf(id));
    }

    public void deleteById(int id){
        medicineRepository.deleteById(Long.valueOf(id));
    }

    public List<Medicine> familyMemberMedicinesList(List<Integer> medicineIds) {
        List<Medicine> medicineList = new ArrayList<Medicine>();

        for (int i = 0; i < medicineIds.size(); i++) {
            medicineList.add(findById(medicineIds.get(i)));
        }

        return medicineList;
    }
}
