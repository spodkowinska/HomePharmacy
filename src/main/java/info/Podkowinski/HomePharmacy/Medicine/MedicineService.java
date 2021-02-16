package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Medicine> findAllMedicines(){
        return medicineRepository.findAll();
    }

    public Medicine findById(int id){
        return medicineRepository.getOne(Long.valueOf(id));
    }

    public void deleteById(int id){
        medicineRepository.deleteById(Long.valueOf(id));
    }

    public void deleteMedicine(Medicine medicine) { medicineRepository.delete(medicine);}


    //MedicineInstance service

    public void saveMedicineInstance(MedicineInstance medicineInstance){
        medicineInstanceRepository.save(medicineInstance);
    }

    public List<MedicineInstance> findAllMedicineInstances(){
        return medicineInstanceRepository.findAll();
    }

    public MedicineInstance findMedicineInstanceById(int id){
        return medicineInstanceRepository.getOne(Long.valueOf(id));
    }

    public void deleteMedicineInstanceById(int id){
        medicineInstanceRepository.deleteById(Long.valueOf(id));
    }

    public void deleteMedicineInstance(MedicineInstance medicineInstance) {
        medicineInstanceRepository.delete(medicineInstance);}


}
