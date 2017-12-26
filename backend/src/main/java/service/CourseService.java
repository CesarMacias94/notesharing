package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourseDAO;

@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;
}