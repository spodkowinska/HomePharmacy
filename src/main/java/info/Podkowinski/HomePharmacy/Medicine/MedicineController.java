package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add")
    public ResponseEntity addMedicine(@RequestBody AddMedicineDTO addMedicineDTO) {
        Medicine medicine = new Medicine();
        return saveMedicine(addMedicineDTO, medicine);
    }

    @PatchMapping(value = "/edit")
    public ResponseEntity editMedicine(@RequestBody AddMedicineDTO addMedicineDTO) {
        Medicine medicine = medicineService.findById(addMedicineDTO.getId());
        return editMedicine(addMedicineDTO, medicine);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMedicine(@RequestBody Medicine medicine) {
        medicineService.deleteMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medicine>> listMedicines() {
        List<Medicine> foundMedicine = medicineService.findAllMedicines();
        if (foundMedicine == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMedicine);
        }
    }

    public ResponseEntity saveMedicine(AddMedicineDTO addMedicineDTO, Medicine medicine) {
        medicine.setName(addMedicineDTO.getName());
        medicine.setIsToBuy(addMedicineDTO.getIsToBuy());
        medicine.setIsPrescriptionNeeded(addMedicineDTO.getIsPrescriptionNeeded());
        medicine.setIsAntibiotic(addMedicineDTO.getIsAntibiotic());
        medicine.setDescription(addMedicineDTO.getDescription());
        medicine.setIsSteroid(addMedicineDTO.getIsSteroid());
        medicine.setIsVitamin(addMedicineDTO.getIsVitamin());
        medicine.setOfficialPrice(addMedicineDTO.getOfficialPrice());

        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity editMedicine(AddMedicineDTO addMedicineDTO, Medicine medicine) {
        if (addMedicineDTO.getName() != null) {
            if (!addMedicineDTO.getName().equals(medicine.getName())) {
                medicine.setName(addMedicineDTO.getName());
            }
        }
        if (addMedicineDTO.getIsToBuy() != medicine.getIsToBuy()) {
            medicine.setIsToBuy(addMedicineDTO.getIsToBuy());
        }
        if (addMedicineDTO.getIsPrescriptionNeeded() != medicine.getIsPrescriptionNeeded()) {
            medicine.setIsPrescriptionNeeded(addMedicineDTO.getIsPrescriptionNeeded());
        }
        if (addMedicineDTO.getIsAntibiotic() != medicine.getIsAntibiotic()) {
            medicine.setIsAntibiotic(addMedicineDTO.getIsSteroid());
        }
        if (addMedicineDTO.getDescription() != null) {
            if (!addMedicineDTO.getDescription().equals(medicine.getDescription())) {
                medicine.setDescription(addMedicineDTO.getDescription());
            }
        }
        if (addMedicineDTO.getIsSteroid() != medicine.getIsSteroid()) {
            medicine.setIsSteroid(addMedicineDTO.getIsSteroid());
        }
        if (addMedicineDTO.getIsVitamin() != medicine.getIsVitamin()) {
            medicine.setIsVitamin(addMedicineDTO.getIsVitamin());
        }
        if (addMedicineDTO.getOfficialPrice()!=null) {
            if (!addMedicineDTO.getOfficialPrice().equals(medicine.getOfficialPrice())) {
                medicine.setOfficialPrice(addMedicineDTO.getOfficialPrice());
            }
        }


        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //MedicineInstance mappings

    @PostMapping("/addInstance")
    public ResponseEntity addMedicineInstance(@RequestBody AddMedicineInstanceDTO addMedicineInstanceDTO) {
        MedicineInstance medicineInstance = new MedicineInstance();
        return saveMedicineInstance(addMedicineInstanceDTO, medicineInstance);
    }

    @PutMapping("/editInstance")
    public ResponseEntity editMedicineInstance(@RequestBody AddMedicineInstanceDTO addMedicineInstanceDTO) {
        MedicineInstance medicineInstance = medicineService.findMedicineInstanceById(addMedicineInstanceDTO.getId());
        return saveMedicineInstance(addMedicineInstanceDTO, medicineInstance);
    }

    @DeleteMapping("/deleteInstance")
    public ResponseEntity deleteMedicineInstance(@RequestBody MedicineInstance medicineInstance) {
        medicineService.deleteMedicineInstance(medicineInstance);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllInstances")
    public ResponseEntity deleteAllInstances(@RequestBody Medicine medicine) {
        medicineService.deleteAllMedicineInstances(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listInstances")
    public ResponseEntity<List<MedicineInstance>> listInstances() {
        List<MedicineInstance> foundMedicineInstances = medicineService.findAllMedicineInstances();
        if (foundMedicineInstances == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMedicineInstances);
        }
    }

    @PatchMapping("/setInstanceHidden")
    public ResponseEntity setInstanceHidden(@RequestBody MedicineInstance medicineInstance) {
        medicineService.setMedicineInstanceHidden(medicineInstance);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //lists last 15 Medicine Instances if quantityLeft < 10 or expiryDate < 7 days from now or earlier sorted by expiryDate
    @GetMapping("/listLastInstances")
    public ResponseEntity<List<MedicineInstance>> listLastInstances() {
        List<MedicineInstance> foundMedicineInstances = medicineService.findLastMedicineInstances();
        if (foundMedicineInstances == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMedicineInstances);
        }
    }

    public ResponseEntity saveMedicineInstance(AddMedicineInstanceDTO addMedicineInstanceDTO, MedicineInstance medicineInstance) {
        medicineInstance.setMedicine(addMedicineInstanceDTO.getMedicine());
        medicineInstance.setQuantityLeft(addMedicineInstanceDTO.getQuantityLeft());
        medicineInstance.setExpiryDate(addMedicineInstanceDTO.getExpiryDate());
        medicineInstance.setPrice(addMedicineInstanceDTO.getPrice());
        medicineInstance.setMedicine_id(addMedicineInstanceDTO.getMedicine_id());
        medicineInstance.setVisible(addMedicineInstanceDTO.isVisible());

        medicineService.saveMedicineInstance(medicineInstance);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //wishlist mapping

    @PatchMapping("/addToWishlist")
    public ResponseEntity addToWishList(@RequestBody Medicine medicine) {
        medicineService.addToWishList(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/showWishlist")
    public ResponseEntity<List<Medicine>> showWishlist() {
        List<Medicine> wishlist = medicineService.showWishList();
        if (wishlist == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(wishlist);
        }
    }

    @PatchMapping("/removeFromWishlist")
    public ResponseEntity removeFromWishlist(@RequestBody Medicine medicine) {
        medicineService.removeFromWishlist(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
