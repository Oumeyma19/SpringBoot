package tn.esprit.ds.championnat.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    private String emplacement;
    private LocalDate dateCourse;

    @ManyToMany(mappedBy = "courses")
    private List<Championnat> championnats;

    @OneToMany(mappedBy = "course")
    private List<Position> positions;


}