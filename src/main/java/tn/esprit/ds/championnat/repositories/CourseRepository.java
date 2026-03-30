package tn.esprit.ds.championnat.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ds.championnat.entites.Course;

public interface CourseRepository extends CrudRepository<Course,Long> {
}
