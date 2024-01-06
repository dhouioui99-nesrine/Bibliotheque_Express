package com.example.express.Controller;

import com.example.express.Entity.Emprunt;
import com.example.express.Service.EmpruntService;
import com.example.express.Service.LivreService;
import com.example.express.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private UserService userService;

    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Emprunt> getAllEmprunts() {
        return empruntService.getAllEmprunts();
    }

    @GetMapping("/{id}")
    public Emprunt getEmpruntById(@PathVariable Long id) {
        return empruntService.getEmpruntById(id);
    }




    @PostMapping("/retourner/{empruntId}")
    public void retournerLivre(@PathVariable Long empruntId) {
        empruntService.retournerLivre(empruntId);
    }

    @PostMapping("/renouveler/{empruntId}")
    public void renouvelerEmprunt(@PathVariable Long empruntId) {
        empruntService.renouvelerEmprunt(empruntId);
    }
}