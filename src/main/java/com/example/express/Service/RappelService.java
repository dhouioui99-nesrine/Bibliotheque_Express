package com.example.express.Service;
import com.example.express.Entity.Emprunt;
import com.example.express.Entity.Rappel;

import java.util.List;

public interface RappelService {
    List<Rappel> getAllRappels();
    Rappel getRappelById(Long id);
    void genererRappelRetard(Emprunt emprunt);
}