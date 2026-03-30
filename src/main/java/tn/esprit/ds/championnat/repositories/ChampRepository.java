package tn.esprit.ds.championnat.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ds.championnat.entites.Championnat;
import tn.esprit.ds.championnat.entites.Equipe;

public interface ChampRepository extends CrudRepository<Championnat,Long> {
}
