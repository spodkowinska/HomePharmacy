package info.Podkowinski.HomePharmacy.Medicine;

import info.Podkowinski.HomePharmacy.Family.FamilyMember;
import info.Podkowinski.HomePharmacy.Family.FamilyService;
import info.Podkowinski.HomePharmacy.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private ActiveMedicinesService activeMedicinesService;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity addMedicine(@RequestBody AddMedicineDTO addMedicineDTO, @RequestHeader String userId) {
        Medicine medicine = new Medicine();

        medicine.setUser(userService.findById(userId));
        medicine.setName(addMedicineDTO.getName());
//        medicine.setIsToBuy(addMedicineDTO.getIsToBuy());  should it be here?
        medicine.setIsPrescriptionNeeded(addMedicineDTO.getIsPrescriptionNeeded());
        medicine.setIsAntibiotic(addMedicineDTO.getIsAntibiotic());
//        medicine.setDescription(addMedicineDTO.getDescription()); so finally description should be found by
        medicine.setNotes(addMedicineDTO.getNotes());
        medicine.setIsSteroid(addMedicineDTO.getIsSteroid());
        medicine.setIsVitamin(addMedicineDTO.getIsVitamin());
//        medicine.setOfficialPrice(addMedicineDTO.getOfficialPrice()); do we need it?

        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok("New medicine has been added successfully!");
    }

    @PatchMapping(value = "/edit")
    public ResponseEntity editMedicine(@RequestBody AddMedicineDTO addMedicineDTO, @RequestHeader HttpHeaders header) {
        Medicine medicine = medicineService.findById(addMedicineDTO.getId());

        if (medicine.getUser().getId().equals(header.getFirst("userId"))) {

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

            if (addMedicineDTO.getNotes() != medicine.getNotes()) {
                medicine.setNotes(addMedicineDTO.getNotes());
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
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMedicine(@RequestBody Medicine medicine, @RequestHeader HttpHeaders header) {
        String userId = header.getFirst("userId");
        if (medicine.getUser().getId().equals(userId)) {
            medicineService.deleteMedicine(medicine);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/list")
    public ResponseEntity<List<MedicineForDisplayDTO>> listMedicines(@RequestHeader HttpHeaders header) {

        List<MedicineForDisplayDTO> fullMedicine = new ArrayList<>();
        List<Medicine> foundMedicine = medicineService.findAllMedicinesByUserId(header.getFirst("userId"));

        for (Medicine medicine : foundMedicine){
            System.out.println(medicine.getIsToBuy());
            MedicineForDisplayDTO newDTO = new MedicineForDisplayDTO();

            newDTO.setId(medicine.getId());
            newDTO.setDescription(medicine.getDescription());
            newDTO.setName(medicine.getName());
            newDTO.setAntibiotic(medicine.getIsAntibiotic());
            newDTO.setSteroid(medicine.getIsSteroid());
            newDTO.setPrescriptionNeeded(medicine.getIsPrescriptionNeeded());
            newDTO.setVitamin(medicine.getIsVitamin());
            newDTO.setIsToBuy(medicine.getIsToBuy());
            newDTO.setNotes(medicine.getNotes());

            List<FamilyMember>familyMembers = new ArrayList<>();

            if (medicineService.checkIfExistsById(medicine.getId())) {
                medicineService.getInstancesByMedicine(medicine.getId()).forEach(p->familyMembers.add(p.getWhomWasItPrescribed()));
                newDTO.setFamilyMembers(familyMembers);
            }

            List<MedicineAlternative> alternatives = new ArrayList<>();

            if (medicineService.findAlternativesByMedicine(medicine.getId()).size() > 0) {
                alternatives.addAll(medicineService.findAlternativesByMedicine(medicine.getId()));
                newDTO.setAlternatives(alternatives);
            }

            fullMedicine.add(newDTO);
        }

        if (fullMedicine == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(fullMedicine);
        }
    }

    //MedicineInstance mappings

    @PostMapping("/addInstance")
    public ResponseEntity addMedicineInstance(@RequestBody AddMedicineInstanceDTO addMedicineInstanceDTO, @RequestHeader HttpHeaders header) {
        if (addMedicineInstanceDTO.getUserId().equals(header.getFirst("userId"))) {
            MedicineInstance medicineInstance = new MedicineInstance();
            return saveMedicineInstance(addMedicineInstanceDTO, medicineInstance);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/editInstance")
    public ResponseEntity editMedicineInstance(@RequestBody AddMedicineInstanceDTO addMedicineInstanceDTO, @RequestHeader String userId) {
        if (addMedicineInstanceDTO.getUserId().equals(userId)) {
            MedicineInstance medicineInstance = medicineService.findMedicineInstanceById(addMedicineInstanceDTO.getId());
            return editMedicineInstance(addMedicineInstanceDTO, medicineInstance);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/deleteInstance")
    public ResponseEntity deleteMedicineInstance(@RequestBody MedicineInstance medicineInstance, @RequestHeader HttpHeaders header) {

        if (medicineInstance.getMedicine().getUser().getId().equals(header.getFirst("userId"))) {
            medicineService.deleteMedicineInstance(medicineInstance.getId());
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteAllInstances")
    public ResponseEntity deleteAllInstances(@RequestBody Medicine medicine, @RequestHeader HttpHeaders header) {

        if (medicine.getUser().getId().equals(header.getFirst("userId"))) {
            medicineService.deleteAllMedicineInstances(medicine);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listInstances")
    public ResponseEntity<List<MedicineInstance>> listInstances(@RequestHeader String userId) {
        List<MedicineInstance> foundMedicineInstances = medicineService.findAllMedicineInstancesByUser(userId);
        if (foundMedicineInstances == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMedicineInstances);
        }
    }

    @PatchMapping("/setInstanceHidden")
    public ResponseEntity setInstanceHidden(@RequestBody MedicineInstance medicineInstance, @RequestHeader String userId) {
        if(medicineInstance.getMedicine().getUser().getId().equals(userId)) {
            medicineService.setMedicineInstanceHidden(medicineInstance);
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //lists last 15 Medicine Instances if quantityLeft < 10 or expiryDate < 7 days from now or earlier sorted by expiryDate
    @GetMapping("/listLastInstances")
    public ResponseEntity<List<MedicineInstance>> listLastInstances(@RequestHeader String userId) {
        List<MedicineInstance> foundMedicineInstances = medicineService.findLastMedicineInstances(userId);
        if (foundMedicineInstances == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMedicineInstances);
        }
    }

    public ResponseEntity saveMedicineInstance(AddMedicineInstanceDTO addMedicineInstanceDTO, MedicineInstance medicineInstance) {
        medicineInstance.setMedicine(medicineService.findById(Math.toIntExact(addMedicineInstanceDTO.getMedicine_id())));
        medicineInstance.setQuantityLeft(addMedicineInstanceDTO.getQuantityLeft());
        medicineInstance.setExpiryDate(addMedicineInstanceDTO.getExpiryDate());
        medicineInstance.setPrice(addMedicineInstanceDTO.getPrice());
        medicineInstance.setVisible(addMedicineInstanceDTO.getVisible());

        medicineService.saveMedicineInstance(medicineInstance);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity editMedicineInstance(AddMedicineInstanceDTO addMedicineInstanceDTO, MedicineInstance medicineInstance) {
        if (addMedicineInstanceDTO.getMedicine_id()!=null) {
            medicineInstance.setMedicine(medicineService.findById(Math.toIntExact(addMedicineInstanceDTO.getMedicine_id())));
        }
        if (addMedicineInstanceDTO.getQuantityLeft()!=null){
            medicineInstance.setQuantityLeft(addMedicineInstanceDTO.getQuantityLeft());
        }
        if (addMedicineInstanceDTO.getExpiryDate()!=null){
            medicineInstance.setExpiryDate(addMedicineInstanceDTO.getExpiryDate());
        }
        if (addMedicineInstanceDTO.getPrice()!=null) {
            medicineInstance.setPrice(addMedicineInstanceDTO.getPrice());
        }
        if (addMedicineInstanceDTO.getVisible() != medicineInstance.getVisible()) {
            medicineInstance.setVisible(addMedicineInstanceDTO.getVisible());
        }

        medicineService.saveMedicineInstance(medicineInstance);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //wishlist mapping

    @PatchMapping("/addToWishlist")
    public ResponseEntity addToWishList(@RequestBody Medicine medicine, @RequestHeader String userId) {
        medicineService.addToWishList(medicine, userId);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/showWishlist")
    public ResponseEntity<List<Medicine>> showWishlist(@RequestHeader String userId) {

        List<Medicine> wishlist = medicineService.showWishList(userId);

        if (wishlist == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(wishlist);
        }
    }

    @PatchMapping("/removeFromWishlist")
    public ResponseEntity removeFromWishlist(@RequestBody Medicine medicine, @RequestHeader String userId) {
        medicineService.removeFromWishlist(medicine, userId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // family members medicines

    // adding active medicine - information about data that should be passed by json is below
    @PostMapping("/addActiveMedicine")
    public ResponseEntity addActiveMedicine(@RequestBody AddActiveMedicineDTO addActiveMedicineDTO, @RequestHeader String userId) {
        ActiveMedicines activeMedicine = new ActiveMedicines();

        if(addActiveMedicineDTO.getUserId().equals(userId)) {
            activeMedicine.setFamilyMember(activeMedicinesService.findById(addActiveMedicineDTO.getFamilyMemberId())); // family member that should be connected to active medicine
            activeMedicine.setMedicineInstance(activeMedicinesService.findMedicineInstanceById(addActiveMedicineDTO.getMedicineInstanceId())); // json medicine instance that should be connected to active medicine
            activeMedicine.setEatAtDate(addActiveMedicineDTO.getEatAtDate()); // start eating pill from date - format yyyy-mm-dd
            activeMedicine.setQuantityPerDay(addActiveMedicineDTO.getQuantityPerDay()); // how many pills should be eaten per day
            activeMedicine.setHowOften(addActiveMedicineDTO.getHowOften()); // information in days

            if (addActiveMedicineDTO.getAlreadyTaken() == null) {
                activeMedicine.setAlreadyTaken(0);
            } else {
                activeMedicine.setAlreadyTaken(addActiveMedicineDTO.getAlreadyTaken()); // json default value is 0 but user can choose if he/she already ate some pills
            }

            activeMedicine.setHidden(addActiveMedicineDTO.isHidden()); // default value should be false - hidden true is after each pill has been eaten at actual day
            activeMedicine.setAllTakenOnTime(addActiveMedicineDTO.isAllTakenOnTime()); // default value should be true and then if user didn't took all pills on time it will be changed to false
            activeMedicinesService.addActiveMedicine(activeMedicine);
            return ResponseEntity.ok("New active medicine saved successfully!");
        }
        return ResponseEntity.notFound().build();
    }

    // returns list of todays medicines for each family member depends of user id
    @GetMapping("/showTodaysMedicines")
    public ResponseEntity<List<ActiveMedicines>> showTodaysMedicines(@RequestHeader String userId) {

        return ResponseEntity.ok(activeMedicinesService.getTodaysMedicines(userId)); // by user id
    }

    // update medicine instance and active medicine - needs "medicineInstanceId" in json body
    // to set medicine instance quantity left -1 and active medicine already taken + 1
    // works for each request
    @PatchMapping("/updateActiveMedicineInstance")
    public ResponseEntity updateActiveMedicineInstance(@RequestBody AddActiveMedicineDTO updateMedicineInstance, @RequestHeader String userId) {

        MedicineInstance medicineInstanceToUpdate = medicineService.findMedicineInstanceById(Math.toIntExact(updateMedicineInstance.getMedicineInstance().getId()));
        System.out.println(medicineInstanceToUpdate.getId());
        ActiveMedicines updatedActiveMedicine = activeMedicinesService.findActiveMedicine(Long.valueOf(updateMedicineInstance.getId()));
        if (medicineInstanceToUpdate.getMedicine().getUser().getId().equals(userId)) {
            medicineInstanceToUpdate.setQuantityLeft(medicineInstanceToUpdate.getQuantityLeft() - 1);
            updatedActiveMedicine.setAlreadyTaken(updatedActiveMedicine.getAlreadyTaken() + 1);

            if (updatedActiveMedicine.getAlreadyTaken() == updatedActiveMedicine.getQuantityPerDay()) {
                updatedActiveMedicine.setHidden(true);
            }

            medicineService.saveMedicineInstance(medicineInstanceToUpdate);
            activeMedicinesService.updateActiveMedicine(updatedActiveMedicine);

            return ResponseEntity.ok("Active medicine updated successfully!");
        }
        return ResponseEntity.notFound().build();
    }
}
