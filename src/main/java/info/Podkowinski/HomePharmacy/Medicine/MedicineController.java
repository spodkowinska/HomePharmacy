package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/addMedicine")
    public String addMedicine(Model model){
        model.addAttribute("medicine", new Medicine());
        return "Medicine/medicine-edit";
    }
    @GetMapping("/edit/{id}")
    public String editMedicine(@PathVariable int id, Model model){
        Medicine medicineToEdit = medicineService.findById(id);
        model.addAttribute("medicine", medicineToEdit);
        return "Medicine/medicine-edit";
    }
    @PostMapping("/editMedicine")
    public String editMedicinePost(@ModelAttribute Medicine medicine, Model model){
        medicineService.saveMedicine(medicine);
        model.addAttribute("medicines", medicineService.findAll());
        return "redirect:/medicine-list";
    }
    @GetMapping("/medicine-list")
    public String medicineList(Model model){
        model.addAttribute("medicines", medicineService.findAll());
        return "Medicine/medicine-list";
    }
    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable int id, Model model){
        medicineService.deleteById(id);
        model.addAttribute("medicines", medicineService.findAll());
        return "redirect:/medicine-list";
    }

}
