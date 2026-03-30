package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.championnat.entites.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote , Long> {
    Pilote finfBylibPi(String Libelle);


}
