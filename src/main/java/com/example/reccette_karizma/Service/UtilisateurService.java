package com.example.reccette_karizma.Service;

import com.example.reccette_karizma.Entity.utilisateur;
import com.example.reccette_karizma.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UtilisateurService   {

    private UtilisateurRepository userRepository;

    @Autowired
    public void UserService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UtilisateurService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<utilisateur> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<Object> getUtilisateurById(Long utilisateurId) {


        return null;
    }


}

