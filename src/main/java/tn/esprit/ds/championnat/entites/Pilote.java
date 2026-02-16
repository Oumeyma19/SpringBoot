package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    private String libelleP;
    private Integer nbPointsTotal;
    private Integer classementGeneral;

    @Enumerated(EnumType.STRING) // Ajoute ceci pour la catégorie
    private Categorie categorie;

    @OneToMany(mappedBy = "pilote")
    private List<Position> positions;

    @ManyToOne
    private Equipe equipe;


}