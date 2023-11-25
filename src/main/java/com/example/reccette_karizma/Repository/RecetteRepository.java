package com.example.reccette_karizma.Repository;

import com.example.reccette_karizma.Entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> findByNomAndUtilisateurId(String nom, Long utilisateurId);
    List<Recette> findByUtilisateurId(Long utilisateurId);
}
