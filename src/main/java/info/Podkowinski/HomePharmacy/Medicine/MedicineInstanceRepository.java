package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineInstanceRepository extends JpaRepository <MedicineInstance, Long> {

    List<MedicineInstance> findAllByMedicineId(Long medicineId);
}
