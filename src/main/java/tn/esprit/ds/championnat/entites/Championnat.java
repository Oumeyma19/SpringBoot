package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;

@Entity
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChampionnat; // ID du championnat

    private String code; // Code du championnat

    private String description; // Description du championnat

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @OneToOne(mappedBy = "championnat")
    private DetailChampionnat detailChampionnat;
}
