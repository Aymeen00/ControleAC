package org.sid.bouanan_aymen_controle_2.web;

import org.sid.bouanan_aymen_controle_2.entities.Auteur;
import org.sid.bouanan_aymen_controle_2.entities.Livre;
import org.sid.bouanan_aymen_controle_2.service.AuteurService;
import org.sid.bouanan_aymen_controle_2.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private AuteurService auteurService;

    @QueryMapping
    public List<Livre> getLivres() {
        return livreService.getAllLivres();
    }

    @QueryMapping
    public Optional<Livre> getLivre(Long id) {
        return livreService.getLivreById(id);
    }

    @QueryMapping
    public List<Auteur> getAuteurs() {
        return auteurService.getAllAuteurs();
    }

    @MutationMapping
    public Livre ajouterLivre(String titre, Double prix, Long auteurId) {
        return livreService.addLivre(new Livre(titre, prix, auteurService.getAuteurById(auteurId)));
    }

    @MutationMapping
    public Livre mettreAJourLivre(Long id, String titre, Double prix, Long auteurId) {
        Livre livreDetails = new Livre();
        livreDetails.setTitre(titre);
        livreDetails.setPrix(prix);
        if (auteurId != null) {
            livreDetails.setAuteur(auteurService.getAuteurById(auteurId).orElse(null));
        }
        return livreService.updateLivre(id, livreDetails);
    }

    @MutationMapping
    public boolean supprimerLivre(Long id) {
        return livreService.deleteLivre(id);
    }
}
