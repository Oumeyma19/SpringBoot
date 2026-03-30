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
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
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

    @ManyToMany(cascade=CascadeType.ALL)
    List<Course> courses;


    public void setC(DetailChampionnat dt1) {
        this.detailChampionnat=dt1;
        dt1.setChampionnat(this);
    }
}
