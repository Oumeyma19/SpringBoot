package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    private String libelleP;
    private Integer nbPointsTotal;
    private Integer classementGeneral;

    @Enumerated(EnumType.STRING) // Ajoute ceci pour la catégorie
    private Categorie categorie;

    @OneToMany(mappedBy = "pilote" , cascade = CascadeType.ALL)
    private List<Position> positions;

    @ManyToOne
    private Equipe equipes;


}