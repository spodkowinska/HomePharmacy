package info.Podkowinski.HomePharmacy.Family;

import info.Podkowinski.HomePharmacy.Medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyRepository extends JpaRepository<FamilyMember, Long> {

    List<FamilyMember> findAllByUserId(String userId);
}
