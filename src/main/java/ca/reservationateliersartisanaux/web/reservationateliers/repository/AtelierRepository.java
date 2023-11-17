package ca.reservationateliersartisanaux.web.reservationateliers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Atelier;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {
   
}

