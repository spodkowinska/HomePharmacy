package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

    @PostMapping(value="/edit")
    public ResponseEntity editMedicinePost(@RequestBody Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteMedicine(@RequestBody Medicine medicine) {
        medicineService.deleteMedicine(medicine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/buy/{id}")
    public String buyMedicine(@PathVariable int id, Model model) {
        Medicine medicineToBuy = medicineService.findById(id);
        medicineToBuy.setIsToBuy(true);
        medicineService.saveMedicine(medicineToBuy);
        model.addAttribute("medicines", medicineService.findAll());
        return "redirect:/medicine/list";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medicine>> read() {
        List<Medicine> foundMedicine = medicineService.findAll();
        if (foundMedicine == null) {
            return ResponseEntity.notFound().build();
        } else {
                return ResponseEntity.ok(foundMedicine);
            }
    }

}
