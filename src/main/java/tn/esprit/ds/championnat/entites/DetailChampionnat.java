package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailChampionnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailChampionnat; // ID du détail du championnat

    private String code; // Code du détail du championnat
    private String description; // Description du détail du championnat

    @OneToOne(mappedBy = "detailChampionnat")
    private Championnat championnat; // Lien One-to-One avec Championnat

}
