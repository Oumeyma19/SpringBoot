package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSponsor;

    private String nom;
    private String pays;
    private Float budgetAnnuel;
    private Boolean bloquerContrat;
    private Boolean archived;
    private LocalDate dateCreation;
    private LocalDate dateDerniereModification;

    @OneToMany(mappedBy = "sponsor" , cascade = CascadeType.ALL)
    private List<Contrat> contrats;

    public void setDateCreation(LocalDate now) {
        this.dateCreation = now;
    }

    public void setArchived(boolean b) {
        this.archived = b;
    }

    public void setBloquerContrat(boolean b) {
        this.bloquerContrat = b;
    }

    public void setDateDerniereModification(LocalDate now) {
        this.dateDerniereModification = now;
    }
}