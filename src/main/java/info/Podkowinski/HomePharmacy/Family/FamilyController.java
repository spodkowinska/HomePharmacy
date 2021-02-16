package info.Podkowinski.HomePharmacy.Family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/family")
    public List<FamilyMember> familyHomePage(){
        return familyService.findAll();
    }

    @PostMapping(value = "/family/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addFamilyMember(@RequestBody FamilyMember familyMember) {

        familyService.saveFamilyMember(familyMember);
        return "redirect:/family";
    }

    @PutMapping(value = "/family/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editFamilyMember(@RequestBody FamilyMember familyMember) {
        familyService.saveFamilyMember(familyMember);
        return "redirect:/family";
    }

    @DeleteMapping(value = "/family/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteFamilyMember(@RequestBody FamilyMember familyMember) {
        familyService.deleteById(familyMember.getId());
        return "redirect:/family";
    }
}
