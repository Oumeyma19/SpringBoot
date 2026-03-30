package tn.esprit.ds.championnat.controller;

import tn.esprit.ds.championnat.entites.Championnat;
import tn.esprit.ds.championnat.entites.Course;
import tn.esprit.ds.championnat.repositories.ChampRepository;
import tn.esprit.ds.championnat.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseController {
    CourseRepository courRep;
    ChampRepository champRep;
    String affecterCourseAchampionnat(long idcourse,long idchampionnat){
        Course c= courRep.findById(idcourse).get();
        Championnat ch= champRep.findById(idchampionnat).get();
        List <Course> courses= new ArrayList<Course>();
        if(ch.getCourses()!=null){
            courses.addAll(ch.getCourses());
        }
        courses.add(c);
        ch.setCourses(courses);
        champRep.save(ch);
        return "success";
    }
}
