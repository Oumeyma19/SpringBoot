package tn.esprit.ds.championnat.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ds.championnat.entites.DetailChampionnat;

public interface DeatailCampionnatRepository extends CrudRepository<DetailChampionnat,String> {
}
