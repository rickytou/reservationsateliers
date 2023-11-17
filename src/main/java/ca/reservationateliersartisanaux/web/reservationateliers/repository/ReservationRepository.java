package ca.reservationateliersartisanaux.web.reservationateliers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Atelier;
import ca.reservationateliersartisanaux.web.reservationateliers.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByAtelier(Atelier atelier);
}

