package info.Podkowinski.HomePharmacy.Family;

import info.Podkowinski.HomePharmacy.Medicine.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/family")
    public List<FamilyMember> familyHomePage(){
        return familyService.findAll();
    }

    @PostMapping(value = "/family/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addFamilyMember(@RequestBody CreatingFamilyMemberDTO creatingFamilyMemberDTO) {

        FamilyMember newFamilyMember = new FamilyMember();

        newFamilyMember.setName(creatingFamilyMemberDTO.getName());
        newFamilyMember.setSurname(creatingFamilyMemberDTO.getSurname());
        newFamilyMember.setAge(creatingFamilyMemberDTO.getAge());

        List<Integer> medicineIds = creatingFamilyMemberDTO.getMedicineIds();
        newFamilyMember.setMedicines(medicineService.familyMemberMedicinesList(medicineIds));

        familyService.saveFamilyMember(newFamilyMember);
        return "redirect:/family";
    }

    @PutMapping(value = "/family/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editFamilyMember(@RequestBody EditFamilyMemberDTO editFamilyMemberDTO) {

        int familyMemberId = editFamilyMemberDTO.getId();

        FamilyMember editedFamilyMember = familyService.findById(familyMemberId);

        editedFamilyMember.setName(editFamilyMemberDTO.getName());
        editedFamilyMember.setSurname(editFamilyMemberDTO.getSurname());
        editedFamilyMember.setAge(editFamilyMemberDTO.getAge());

        List<Integer> medicineIds = editFamilyMemberDTO.getMedicineIds();

        editedFamilyMember.setMedicines(medicineService.familyMemberMedicinesList(medicineIds));


        familyService.saveFamilyMember(editedFamilyMember);
        return "redirect:/family";
    }

    @DeleteMapping(value = "/family/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteFamilyMember(@RequestBody EditFamilyMemberDTO editFamilyMemberDTO) {

        familyService.deleteById(editFamilyMemberDTO.getId());
        return "redirect:/family";
    }
}
