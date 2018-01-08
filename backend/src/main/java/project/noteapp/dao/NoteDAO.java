package project.noteapp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import project.noteapp.bean.Course;
import project.noteapp.bean.Note;
import project.noteapp.bean.User;
import project.noteapp.bean.NoteDTO;

@Repository
@Qualifier(value="NoteDAO")
public class NoteDAO {
    private static SessionFactory factory;

    public NoteDAO() {
        super();

        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Restituisce la lista di tutte le note di un corso
    public List<NoteDTO> getNotesByCourse(String cod_course) {
        List<Note> notes;
        List<NoteDTO> list = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            String hql = "FROM Note n WHERE n.course.cod_course = :p";
            Query query = session.createQuery(hql);
            query.setParameter("p", Integer.parseInt(cod_course));

            notes = (List<Note>) query.list();

            for(Note n: notes) {
                NoteDTO note = new NoteDTO();
                note.setCod_note(n.getCod_note());
                note.setName(n.getName());
                note.setText(n.getText());

                list.add(note);
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

    //Restituisce i dati di una nota
    public NoteDTO getNote(String cod_note) {
        NoteDTO note = new NoteDTO();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(Note.class);
            cr.add(Restrictions.eq("cod_note", Integer.parseInt(cod_note)));
            List<Note> n = (List<Note>)cr.list();

            note.setCod_note(n.get(0).getCod_note());
            note.setName(n.get(0).getName());
            note.setText(n.get(0).getText());

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }

        return note;
    }

    //Crea una nota
    public Integer createNote(NoteDTO note) {
        Session session = factory.openSession();
        Transaction transaction = null;

        Integer id_db = null;

        try{
            transaction = session.beginTransaction();

            User user = (User) session.load(User.class, note.getCod_user());
            Course course = (Course) session.load(Course.class, note.getCod_course());
            Note new_note = new Note(note.getCod_note(), note.getText(), note.getName(), user, course);

            id_db = (Integer) session.save(new_note);

            transaction.commit();

        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
                e.printStackTrace();
        }
        finally {
            session.close();
        }
        return id_db;
    }
}