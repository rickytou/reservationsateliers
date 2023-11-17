package ca.reservationateliersartisanaux.web.reservationateliers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Atelier;
import ca.reservationateliersartisanaux.web.reservationateliers.repository.AtelierRepository;



@Service
public class AtelierService {

    private final AtelierRepository atelierRepository;

    @Autowired
    public AtelierService(AtelierRepository atelierRepository) {
        this.atelierRepository = atelierRepository;
    }

    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }

    public Optional<Atelier> getAtelierById(Long id) {
        return atelierRepository.findById(id);
    }

    public Atelier saveAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    public void deleteAtelier(Long id) {
        atelierRepository.deleteById(id);
    }
}

