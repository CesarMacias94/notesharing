package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import bean.Note;

@Repository
@Qualifier(value="NoteDAO")
public class NoteDAO {
    private static SessionFactory factory;

    public NoteDAO() {
        super();

        try {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Restituisce i dati di una nota
    public Note getNote(String cod_note) {
        Note note = new Note();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(Note.class);
            cr.add(Restrictions.eq("cod_note", cod_note));
            List<Note> n = (List<Note>)cr.list();

            note.setCod_note(n.get(0).getCod_note());
            note.setName(n.get(0).getName());
            note.setText(n.get(0).getText());
            note.setCod_user(n.get(0).getCod_user());
            note.setCod_course(n.get(0).getCod_course());

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
    public Integer createNote(Note note) {
        //CODICE DA RIVEDERE
        Session session = factory.openSession();
        Transaction transaction = null;

        Integer id_db = null;

        try{
            transaction = session.beginTransaction();

            id_db = (Integer) session.save(note);

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