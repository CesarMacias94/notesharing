package project.noteapp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import project.noteapp.bean.Course;
import project.noteapp.bean.CourseDTO;

@Repository
@Qualifier(value="CourseDAO")
public class CourseDAO {
    private static SessionFactory factory;

    public CourseDAO() {
        super();

        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Restituisce la lista di tutti i corsi
    public List<CourseDTO> getCourses() {
        List<Course> courses;
        List<CourseDTO> list = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(Course.class);
            courses = (List<Course>)cr.list();

            for(Course c: courses) {
                CourseDTO course = new CourseDTO();
                course.setCod_course(c.getCod_course());
                course.setName(c.getName());
                course.setDescription(c.getDescription());

                list.add(course);
            }

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }

        return list;
    }

    //Restituisce i dati di un corso, ma non le sue note
    public CourseDTO getCourse(String cod_course) {
        CourseDTO course = new CourseDTO();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("cod_course", Integer.parseInt(cod_course)));
            List<Course> c = (List<Course>)cr.list();

            course.setCod_course(c.get(0).getCod_course());
            course.setName(c.get(0).getName());
            course.setDescription(c.get(0).getDescription());

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }

        return course;
    }
}