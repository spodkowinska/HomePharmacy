package info.Podkowinski.HomePharmacy.Family;

import info.Podkowinski.HomePharmacy.Medicine.MedicineService;
import info.Podkowinski.HomePharmacy.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UserService userService;

    @GetMapping("/family")
    public List<FamilyMember> familyHomePage(@RequestHeader HttpHeaders header){

        List<FamilyMember> foundFamilyMembers = familyService.findAllFamilyMembersByUserId(header.getFirst("userId"));

        return foundFamilyMembers;
    }

    @PostMapping(value = "/family/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addFamilyMember(@RequestBody CreatingFamilyMemberDTO creatingFamilyMemberDTO, @RequestHeader String userId) {

        FamilyMember newFamilyMember = new FamilyMember();

        newFamilyMember.setUser(userService.findById(userId));
        newFamilyMember.setName(creatingFamilyMemberDTO.getName());
        newFamilyMember.setNotes(creatingFamilyMemberDTO.getNotes());
        newFamilyMember.setAge(creatingFamilyMemberDTO.getAge());

        if (creatingFamilyMemberDTO.getMedicineIds() != null) {
            List<Integer> medicineIds = creatingFamilyMemberDTO.getMedicineIds();
            newFamilyMember.setMedicines(medicineService.familyMemberMedicinesList(medicineIds));
        }

        familyService.saveFamilyMember(newFamilyMember);
        return "redirect:/family";
    }

    @PatchMapping(value = "/family/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editFamilyMember(@RequestBody EditFamilyMemberDTO editFamilyMemberDTO, @RequestHeader String userId) {

        int familyMemberId = editFamilyMemberDTO.getId();

        FamilyMember editedFamilyMember = familyService.findById(familyMemberId);

        if (editedFamilyMember.getUser().getId().equals(userId)) {
            if (editFamilyMemberDTO.getName() != null) {
                editedFamilyMember.setName(editFamilyMemberDTO.getName());
            }
            if (editFamilyMemberDTO.getNotes() != null) {
                editedFamilyMember.setNotes(editFamilyMemberDTO.getNotes());
            }
            if (editFamilyMemberDTO.getAge() != 0) {
                editedFamilyMember.setAge(editFamilyMemberDTO.getAge());
            }

            //todo - if user is conected with medicine and you add the same medicine it will add new row in table

            if (editFamilyMemberDTO.getMedicineIds() != null) {
                List<Integer> medicineIds = editFamilyMemberDTO.getMedicineIds();
                editedFamilyMember.getMedicines().forEach(medicine -> medicineIds.add(Math.toIntExact(medicine.getId())));
                editedFamilyMember.setMedicines(medicineService.familyMemberMedicinesList(medicineIds));
            }

            familyService.saveFamilyMember(editedFamilyMember);

            return ResponseEntity.ok("Connected family member with medicine!");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(value = "/family/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteFamilyMember(@RequestBody EditFamilyMemberDTO editFamilyMemberDTO) {

        familyService.deleteById(editFamilyMemberDTO.getId());
        return "redirect:/family";
    }
}
