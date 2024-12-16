package org.sid.bouanan_aymen_controle_2.service;


import org.sid.bouanan_aymen_controle_2.entities.Livre;
import org.sid.bouanan_aymen_controle_2.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public Livre addLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre updateLivre(Long id, Livre livreDetails) {
        return livreRepository.findById(id).map(livre -> {
            livre.setTitre(livreDetails.getTitre());
            livre.setPrix(livreDetails.getPrix());
            livre.setAuteur(livreDetails.getAuteur());
            return livreRepository.save(livre);
        }).orElse(null);
    }

    public boolean deleteLivre(Long id) {
        if (livreRepository.existsById(id)) {
            livreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
