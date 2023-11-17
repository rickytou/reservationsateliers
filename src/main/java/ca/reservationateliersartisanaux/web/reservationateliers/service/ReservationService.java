package ca.reservationateliersartisanaux.web.reservationateliers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Atelier;
import ca.reservationateliersartisanaux.web.reservationateliers.models.Reservation;
import ca.reservationateliersartisanaux.web.reservationateliers.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByAtelier(Atelier atelier) {
        return reservationRepository.findByAtelier(atelier);
    }

}

