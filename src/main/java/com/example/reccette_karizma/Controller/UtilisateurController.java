package com.example.reccette_karizma.Controller;

import com.example.reccette_karizma.Entity.utilisateur;
import com.example.reccette_karizma.Service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UtilisateurController {

    private UtilisateurService userService;



    @GetMapping("/{id}")
    public ResponseEntity<utilisateur> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return "Backend is working!";
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody utilisateur loginRequest) {
        if ("utilisateur".equals(loginRequest.getUsername()) && "motdepasse".equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Connexion réussie !");
        } else {
            return ResponseEntity.status(401).body("Nom d'utilisateur ou mot de passe incorrect");
        }
    }

}
