package tn.esprit.ds.championnat.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entites.Pilote;
import tn.esprit.ds.championnat.services.IPiloteService;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {
    private final IPiloteService piloteService;

    @PostMapping("/add")
    public String addPilote(@RequestBody Pilote p) {
        return piloteService.addPilote(p);
    }
}