package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;

@Entity
public class DetailChampionnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailChampionnat; // ID du détail du championnat

    private String code; // Code du détail du championnat
    private String description; // Description du détail du championnat

    @OneToOne
    private Championnat championnat; // Lien One-to-One avec Championnat

}
