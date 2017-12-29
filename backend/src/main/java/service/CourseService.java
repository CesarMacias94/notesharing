package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import bean.Course;
import dao.CourseDAO;

@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    public List<Course> getCourses() {
        return courseDAO.getCourses();
    }

    public Course getCourse(String cod_course) {
        return courseDAO.getCourse(cod_course);
    }
}