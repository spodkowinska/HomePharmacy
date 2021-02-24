package info.Podkowinski.HomePharmacy.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiveMedicinesRepository extends JpaRepository<ActiveMedicines, Long> {

    List<ActiveMedicines> findByUserId(String user_id);
}
