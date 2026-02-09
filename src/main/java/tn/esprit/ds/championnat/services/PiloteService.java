package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entites.Pilote;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

@Service
@AllArgsConstructor
public class PiloteService implements IPiloteService {

    private final PiloteRepository piloteRepository;

    @Override
    public String addPilote(Pilote p) {
        // On enregistre le pilote en base
        piloteRepository.save(p);
        return "Le pilote " + p.getLibelleP() + " a été ajouté avec succès !";
    }
}