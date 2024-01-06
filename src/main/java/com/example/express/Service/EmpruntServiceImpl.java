package com.example.express.Service;


import com.example.express.Entity.Emprunt;
import com.example.express.Entity.Livre;
import com.example.express.Entity.User;
import com.example.express.Repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;


    @Override
    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    @Override
    public Emprunt getEmpruntById(Long id) {
        return empruntRepository.findById(id).orElse(null);
    }

    @Override
    public Emprunt emprunterLivre(User user, Livre livre) {
        Emprunt emprunt = new Emprunt();
        emprunt.setUser(user);
        emprunt.setLivre(livre);
        emprunt.setDateDebut(LocalDate.now());
        emprunt.setDateFin(LocalDate.now().plusDays(14));
        emprunt.setRenouvele(false);
        return empruntRepository.save(emprunt);
    }

    @Override
    public void retournerLivre(Long empruntId) {
        Emprunt emprunt = empruntRepository.findById(empruntId).orElse(null);
        if (emprunt != null) {
            empruntRepository.delete(emprunt);
        }
    }

    @Override
    public void renouvelerEmprunt(Long empruntId) {
        Emprunt emprunt = empruntRepository.findById(empruntId).orElse(null);
        if (emprunt != null && !emprunt.isRenouvele()) {
            emprunt.setDateFin(emprunt.getDateFin().plusDays(14)); // Exemple : renouvellement de 14 jours
            emprunt.setRenouvele(true);
            empruntRepository.save(emprunt);
        }
    }
}
