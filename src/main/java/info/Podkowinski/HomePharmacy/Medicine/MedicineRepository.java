package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedicineRepository extends JpaRepository<Medicine, Long> {

List<Medicine> findAllByUserId(String userId);
}
