package info.Podkowinski.HomePharmacy.Sickness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SicknessController {

    @Autowired
    private SicknessService sicknessService;

    @GetMapping("/addSickness")
    public String addSickness(Model model){
        model.addAttribute("sickness", new Sickness());
        return "Sickness/sickness-edit";
    }
    @GetMapping("/edit/{id}")
    public String editSickness(@PathVariable int id, Model model){
        Sickness sicknessToEdit = sicknessService.findById(id);
        model.addAttribute("sickness", sicknessToEdit);
        return "Sickness/sickness-edit";
    }
    @PostMapping("/edit/sickness")
    public String editSicknessPost(@ModelAttribute Sickness sickness, Model model){
        sicknessService.save(sickness);
        model.addAttribute("sickness", sicknessService.findAll());
        return "redirect:/sickness-list";
    }
    @GetMapping("/sickness-list")
    public String sicknessList(Model model){
        model.addAttribute("sicknesses", sicknessService.findAll());
        return "Sickness/sickness-list";
    }
    @GetMapping("/delete/{id}")
    public String deleteSickness(@PathVariable int id, Model model){
        sicknessService.deleteById(id);
        model.addAttribute("sicknesses", sicknessService.findAll());
        return "redirect:/sickness-list";
    }
}
