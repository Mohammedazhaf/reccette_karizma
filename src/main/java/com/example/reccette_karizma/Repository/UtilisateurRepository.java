package com.example.reccette_karizma.Repository;

import com.example.reccette_karizma.Entity.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<utilisateur, Long> {
    Optional<utilisateur> findById(Long id);
}

