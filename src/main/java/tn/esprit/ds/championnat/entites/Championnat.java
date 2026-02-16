package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChampionnat;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    private String libelleC; // Présent sur le diagramme
    private Integer annee;   // Présent sur le diagramme

    @OneToOne(mappedBy = "championnat")
    private DetailChampionnat detailChampionnat;

    @ManyToMany
    private List<Course> courses;


}
