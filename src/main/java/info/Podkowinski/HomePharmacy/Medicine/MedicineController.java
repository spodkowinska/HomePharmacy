package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/add")
    public String addMedicine(Model model){
        model.addAttribute("medicine", new Medicine());
        return "Medicine/medicine-edit";
    }
    @GetMapping("/edit/{id}")
    public String editMedicine(@PathVariable int id, Model model){
//        List<MedicineInstance> quantitiesWithDates = new ArrayList<>();
        Medicine medicineToEdit = medicineService.findById(id);
//        quantitiesWithDates.addAll(medicineToEdit.getQuantityWithExpiryDate());
        model.addAttribute("medicine", medicineToEdit);
//        model.addAttribute("quantities", quantitiesWithDates);
        return "Medicine/medicine-edit";
    }
    @PostMapping("/edit")
    public String editMedicinePost(@ModelAttribute Medicine medicine, Model model){
        medicineService.saveMedicine(medicine);
        model.addAttribute("medicines", medicineService.findAll());
        return "redirect:/medicine/list";
    }
    @GetMapping("/list")
    public String medicineList(Model model){
        model.addAttribute("medicines", medicineService.findAll());
        return "Medicine/medicine-list";
    }
    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable int id, Model model){
        medicineService.deleteById(id);
        model.addAttribute("medicines", medicineService.findAll());
        return "redirect:/medicine/list";
    }
    @GetMapping("/buy/{id}")
    public String buyMedicine(@PathVariable int id, Model model){
        Medicine medicineToBuy = medicineService.findById(id);
        medicineToBuy.setIsToBuy(true);
        medicineService.saveMedicine(medicineToBuy);
        model.addAttribute("medicines", medicineService.findAll());
        return "redirect:/medicine/list";
    }

}
