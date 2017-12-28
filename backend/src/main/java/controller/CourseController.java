package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import bean.Course;
import service.CourseService;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("api/courses")
    public @ResponseBody ResponseEntity<?> getCourses() {
        try {
            return new ResponseEntity<List<Course>>(courseService.getCourses(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("api/course/{cod_course}")
    public @ResponseBody ResponseEntity<?> getCourse(@PathVariable String cod_course) {
        try {
            return new ResponseEntity<Course>(courseService.getCourse(cod_course), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}