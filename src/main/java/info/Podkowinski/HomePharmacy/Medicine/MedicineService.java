package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private MedicineInstanceRepository medicineInstanceRepository;
    @Autowired
    private MedicineAlternativeRepository medicineAlternativeRepository;

    public void saveMedicine(Medicine medicine){
        medicineRepository.save(medicine);
    }

    public List<Medicine> findAllMedicinesByUserId(String userId){
        return medicineRepository.findAllByUserId(userId);
    }
    public List<MedicineAlternative> findAlternativesByMedicine(Long medicineId){
        return medicineRepository.findById(medicineId).get().getAlternatives();
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

    public List<MedicineInstance> getInstancesByMedicine(Long medicineId){
        return medicineInstanceRepository.findAllByMedicine(medicineId);
    }

    public List<MedicineInstance> findAllMedicineInstances(){
        return medicineInstanceRepository.findAll();
    }

    public List<MedicineInstance> findLastMedicineInstances(){
        List<MedicineInstance> allMedicineInstances = findAllMedicineInstances();
        List<MedicineInstance> lastMedicineInstances = new ArrayList<>();
        Date now = Date.valueOf(LocalDate.now());
        Date future = Date.valueOf(LocalDate.now().plusDays(7));
        for (MedicineInstance medicineInstance : allMedicineInstances) {
            if (medicineInstance.getExpiryDate() != null && medicineInstance.getQuantityLeft() != null) {
                if (medicineInstance.getQuantityLeft() < 10 || medicineInstance.getExpiryDate().before(now) || medicineInstance.getExpiryDate().compareTo(future) == 1) {
                    lastMedicineInstances.add(medicineInstance);
                }
            }
        }
        List<MedicineInstance> sortedList = new ArrayList<>(lastMedicineInstances);
        sortedList.sort(Comparator.comparing(MedicineInstance::getExpiryDate));
        if (sortedList.size() > 16) {
            return sortedList.subList(sortedList.size() -16, sortedList.size());
        } else {
            return sortedList;
        }
    }

    public MedicineInstance findMedicineInstanceById(int id){
        return medicineInstanceRepository.getOne((long) id);
    }

    public void deleteMedicineInstance(Long id) {
        medicineInstanceRepository.delete(findMedicineInstanceById(Math.toIntExact(id)));}

    public void deleteAllMedicineInstances(Medicine medicine) {
        List<MedicineInstance> allInstances = medicineInstanceRepository.findAll();
        for (MedicineInstance instance : allInstances) {
            if (instance.getMedicine().getId().equals(medicine.getId())) {
                medicineInstanceRepository.deleteById(instance.getId());
            }
        }
    }

    public void setMedicineInstanceHidden(MedicineInstance medicineInstance) {
        MedicineInstance medicineInstanceToHide = medicineInstanceRepository.findById(medicineInstance.getId()).orElse(null);
        if (medicineInstanceToHide.getId()!=null) {
            medicineInstanceToHide.setVisible(false);
            medicineInstanceRepository.save(medicineInstanceToHide);
        }
    }


    // Wishlist service

    public List<Medicine> showWishList() {
        List<Medicine> allMedicine = medicineRepository.findAll();
        List<Medicine> wishlist = new ArrayList<>();
        for ( Medicine medicine : allMedicine) {
            if (medicine.getIsToBuy()) {
                 wishlist.add(medicine);
            }
        }
            return wishlist;
    }

    public void addToWishList(Medicine medicine) {
        Medicine medicineToChange = medicineRepository.findById(medicine.getId()).orElse(null);
        if (medicineToChange.getId()!=null) {
            medicineToChange.setIsToBuy(true);
            medicineRepository.save(medicineToChange);
        }
    }

    public void removeFromWishlist(Medicine medicine) {
        Medicine medicineToChange = medicineRepository.findById(medicine.getId()).orElse(null);
        if (medicineToChange.getId()!=null) {
            medicineToChange.setIsToBuy(false);
            medicineRepository.save(medicineToChange);
        }
    }

  //Family Member service
    public List<Medicine> familyMemberMedicinesList(List<Integer> medicineIds) {
        List<Medicine> medicineList = new ArrayList<Medicine>();

        for (int i = 0; i < medicineIds.size(); i++) {
            medicineList.add(findById(medicineIds.get(i)));
        }

        return medicineList;
    }

}
