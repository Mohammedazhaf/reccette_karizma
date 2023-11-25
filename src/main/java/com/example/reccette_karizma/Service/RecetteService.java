package com.example.reccette_karizma.Service;

// RecetteService.java
import com.example.reccette_karizma.Entity.Recette;
import com.example.reccette_karizma.Entity.utilisateur;
import com.example.reccette_karizma.Exception.RecetteNotFoundException;
import com.example.reccette_karizma.Exception.UtilisateurNotFoundException;
import com.example.reccette_karizma.Repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteService {

    private final RecetteRepository recetteRepository;
    private final UtilisateurService utilisateurService;

    @Autowired
    public RecetteService(RecetteRepository recetteRepository, UtilisateurService utilisateurService) {
        this.recetteRepository = recetteRepository;
        this.utilisateurService = utilisateurService;
    }

    public List<Recette> getAllRecettesByUtilisateur(Long utilisateurId) {
        return recetteRepository.findByUtilisateurId(utilisateurId);
    }

    public Optional<Recette> getRecetteById(Long recetteId) {
        return recetteRepository.findById(recetteId);
    }



    public Recette updateRecette(Long recetteId, Recette updatedRecette) {
        Recette existingRecette = recetteRepository.findById(recetteId)
                .orElseThrow(() -> new RecetteNotFoundException("Recette non trouvée avec l'ID : " + recetteId));

        existingRecette.setNom(updatedRecette.getNom());
        existingRecette.setIngredients(updatedRecette.getIngredients());
        existingRecette.setEtapesPreparation(updatedRecette.getEtapesPreparation());
        existingRecette.setDureePreparation(updatedRecette.getDureePreparation());
        existingRecette.setPhoto(updatedRecette.getPhoto());

        return recetteRepository.save(existingRecette);
    }

    public void deleteRecette(Long recetteId) {
        recetteRepository.deleteById(recetteId);
    }
}
