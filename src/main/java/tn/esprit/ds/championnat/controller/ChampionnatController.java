package tn.esprit.ds.championnat.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entites.Championnat;
import tn.esprit.ds.championnat.repositories.ChampRepository;

@RestController
@AllArgsConstructor
@RequestMapping("/championnat")

public class ChampionnatController {
    private ChampRepository ChampRep;
    public Championnat addCampAndAssociatedCourses(Championnat c){
        return ChampRep.save(c);
    }
}

