package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    private String libelle;
    private Integer nbPointsTotal;
    private Integer classementGeneral;


}