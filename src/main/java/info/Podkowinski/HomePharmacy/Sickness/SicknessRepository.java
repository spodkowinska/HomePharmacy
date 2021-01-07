package info.Podkowinski.HomePharmacy.Sickness;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SicknessRepository extends JpaRepository<Sickness, Long> {
}
