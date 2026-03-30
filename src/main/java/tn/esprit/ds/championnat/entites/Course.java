package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    private String emplacement;
    private LocalDate dateCourse;

    @OneToMany(mappedBy="courses",cascade= CascadeType.ALL)
    List<Position> positions;

    @ManyToMany(mappedBy = "courses", cascade=CascadeType.ALL)
    List<Championnat> championnats;


}