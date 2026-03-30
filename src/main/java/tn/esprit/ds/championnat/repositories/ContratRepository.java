package tn.esprit.ds.championnat.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ds.championnat.entites.Contrat;

public interface ContratRepository extends CrudRepository<Contrat,Long> {
}