package com.example.express.Service;


import com.example.express.Entity.Emprunt;
import com.example.express.Entity.Livre;
import com.example.express.Entity.User;

import java.util.List;

public interface EmpruntService {
    List<Emprunt> getAllEmprunts();
    Emprunt getEmpruntById(Long id);
    Emprunt emprunterLivre(User user, Livre livre);
    void retournerLivre(Long empruntId);
    void renouvelerEmprunt(Long empruntId);

}
