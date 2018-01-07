package project.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import project.noteapp.bean.Course;
import project.noteapp.bean.CourseDTO;
import project.noteapp.dao.CourseDAO;

@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    public List<CourseDTO> getCourses() {
        return courseDAO.getCourses();
    }

    public CourseDTO getCourse(String cod_course) {
        return courseDAO.getCourse(cod_course);
    }
}