package com.example.express.Service;
import com.example.express.Entity.Emprunt;
import com.example.express.Entity.Rappel;
import com.example.express.Repository.RappelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RappelServiceImpl implements RappelService {
    @Autowired
    private RappelRepository rappelRepository;

    @Override
    public List<Rappel> getAllRappels() {
        return rappelRepository.findAll();
    }

    @Override
    public Rappel getRappelById(Long id) {
        return rappelRepository.findById(id).orElse(null);
    }

    @Override
    public void genererRappelRetard(Emprunt emprunt) {
        if (emprunt.getDateFin().isBefore(LocalDate.now())) {
            Rappel rappel = new Rappel();
            rappel.setEmprunt(emprunt);
            rappel.setDateRappel(LocalDate.now());
            rappelRepository.save(rappel);

        }
    }
}