package tn.esprit.ds.championnat.controller;

import tn.esprit.ds.championnat.entites.Championnat;
import tn.esprit.ds.championnat.entites.DetailChampionnat;
import tn.esprit.ds.championnat.repositories.ChampRepository;
import tn.esprit.ds.championnat.repositories.DeatailCampionnatRepository;

public class DetailChampionnatController {
    ChampRepository champRep;
    DeatailCampionnatRepository detchampRep;
    DetailChampionnat ajouterEtAffecterDetailChampionnatAchampionnat(DetailChampionnat dt, long idc){
        Championnat c=champRep.findById(idc).get();
        DetailChampionnat dt1=detchampRep.save(dt);
        c.setC(dt1);
        champRep.save(c);
        return dt1;
    }

}
