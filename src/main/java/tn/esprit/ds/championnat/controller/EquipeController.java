package tn.esprit.ds.championnat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entites.Equipe;
import tn.esprit.ds.championnat.services.IEquipeService;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
@Tag(name = "Equipe Controller", description = "Gestion des équipes du championnat")
public class EquipeController {
    private final IEquipeService equipeService;

    @Operation(
            summary = "Ajouter une équipe",
            description = "Permet d'ajouter une nouvelle équipe dans le championnat"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Équipe ajoutée avec succès",
                    content = @Content(schema = @Schema(implementation = Equipe.class))),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })

    @PostMapping("/add")
    public Equipe ajouterEquipe(@RequestBody Equipe e) {
        return equipeService.ajouterEquipe(e);
    }

}