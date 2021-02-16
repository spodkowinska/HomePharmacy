package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add")
    public ResponseEntity addMedicine(@RequestBody Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(value="/edit")
    public ResponseEntity editMedicine(@RequestBody Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
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

    //MedicineInstance mappings

    @PostMapping("/addInstance")
    public ResponseEntity addMedicineInstance(@RequestBody MedicineInstance medicineInstance) {
        medicineService.saveMedicineInstance(medicineInstance);
        return ResponseEntity.ok(medicineInstance);
    }

    @PutMapping("/editInstance")
    public ResponseEntity editMedicineInstance(@RequestBody MedicineInstance medicineInstance) {
        medicineService.saveMedicineInstance(medicineInstance);
        return ResponseEntity.ok(medicineInstance);
    }

    @DeleteMapping("/deleteInstance")
    public ResponseEntity deleteMedicineInstance(@RequestBody MedicineInstance medicineInstance) {
        medicineService.deleteMedicineInstance(medicineInstance);
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
