package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSponsor;

    private String nom;
    private String pays;
    private Float budgetAnnuel;
    private Boolean bloquerContrat;

    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;


}