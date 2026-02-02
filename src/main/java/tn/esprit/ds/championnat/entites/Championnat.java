package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;

import java.util.List;

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

    @ManyToMany
    private List<Course> courses;


}
