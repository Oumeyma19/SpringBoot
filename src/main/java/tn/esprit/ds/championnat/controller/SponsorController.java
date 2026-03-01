package tn.esprit.ds.championnat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entites.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorService;

import java.util.List;

@Tag(name = "Gestion Sponsor", description = "API pour la gestion des sponsors du championnat")
@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController implements ISponsorService {

    private final ISponsorService sponsorService;

    @Operation(description = "Ajouter un nouveau sponsor (dateCreation auto, archived=false, bloquerContrat=false)")
    @ApiResponse(responseCode = "200", description = "Sponsor ajouté avec succès")
    @PostMapping("/add")
    public Sponsor ajouterSponsor(@RequestBody Sponsor s) {
        return sponsorService.ajouterSponsor(s);
    }

    @Operation(description = "Ajouter une liste de sponsors en une seule requête")
    @PostMapping("/add-multiple")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @Operation(description = "Modifier un sponsor existant (dateDerniereModification mise à jour automatiquement)")
    @PutMapping("/update")
    public Sponsor modifierSponsor(@RequestBody Sponsor s) {
        return sponsorService.modifierSponsor(s);
    }

    @Operation(description = "Récupérer la liste complète de tous les sponsors")
    @GetMapping("/get-all")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    @Operation(description = "Récupérer un sponsor par son ID")
    @GetMapping("/get/{id}")
    public Sponsor recupererSponsor(@PathVariable Long id) {
        return sponsorService.recupererSponsor(id);
    }

    @Operation(description = "Supprimer un sponsor par son ID")
    @DeleteMapping("/delete/{id}")
    public void supprimerSponsor(@PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }

    @Operation(description = "Archiver un sponsor (passe archived à true)")
    @PutMapping("/archive/{id}")
    public Boolean archiverSponsor(@PathVariable Long id) {
        return sponsorService.archiverSponsor(id);
    }
}