package tn.esprit.ds.championnat.controller;

import tn.esprit.ds.championnat.entites.Contrat;
import tn.esprit.ds.championnat.entites.Equipe;
import tn.esprit.ds.championnat.entites.Sponsor;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

public class ContratController {
    EquipeRepository EqRep;
    SponsorRepository SpRep;
    ContratRepository ContratRep;
    Contrat ajouterContratEtAffecterAsponsorEtEquipe(Contrat c, String libEq, String nomSponsor, String pays){
        Equipe e= EqRep.finfBylibEq(libEq);
        Sponsor s=SpRep.findByName(nomSponsor);
        c.setEquipes(e);
        c.setSponsors(s);
        return ContratRep.save(c);


    }
}
