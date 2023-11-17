package ca.reservationateliersartisanaux.web.reservationateliers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Artisan;
import ca.reservationateliersartisanaux.web.reservationateliers.repository.ArtisanRepository;



@Service
public class ArtisanService {

    private final ArtisanRepository artisanRepository;

    @Autowired
    public ArtisanService(ArtisanRepository artisanRepository) {
        this.artisanRepository = artisanRepository;
    }

    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    public Optional<Artisan> getArtisanById(Long id) {
        return artisanRepository.findById(id);
    }

    public Artisan saveArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }
}

