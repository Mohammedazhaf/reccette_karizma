package com.example.reccette_karizma.Controller;

import com.example.reccette_karizma.Entity.Recette;
import com.example.reccette_karizma.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    private final RecetteService recetteService;

    @Autowired
    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("/{utilisateurId}")
    public ResponseEntity<List<Recette>> getRecettesByUtilisateur(@PathVariable Long utilisateurId) {
        List<Recette> recettes = recetteService.getAllRecettesByUtilisateur(utilisateurId);
        return ResponseEntity.ok(recettes);
    }

    @GetMapping("/{utilisateurId}/{recetteId}")
    public ResponseEntity<Recette> getRecetteById(@PathVariable Long recetteId) {
        return recetteService.getRecetteById(recetteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("update/{recetteId}")
    public ResponseEntity<Recette> updateRecette(@PathVariable Long recetteId, @RequestBody Recette updatedRecette) {
        Recette updated = recetteService.updateRecette(recetteId, updatedRecette);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{recetteId}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Long recetteId) {
        recetteService.deleteRecette(recetteId);
        return ResponseEntity.noContent().build();
    }
}
