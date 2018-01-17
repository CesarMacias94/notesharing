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

import project.noteapp.bean.Note;
import project.noteapp.bean.User;
import project.noteapp.bean.UserDTO;

@Repository
@Qualifier(value="UserDAO")
public class UserDAO {
    private static SessionFactory factory;

    public UserDAO() {
        super();

        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Restituisce i dati di un utente
    public UserDTO getUser(String cod_user) {
        UserDTO user = new UserDTO();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("cod_user", Integer.parseInt(cod_user)));
            List<User> u = (List<User>)cr.list();

            user.setCod_user(u.get(0).getCod_user());
            user.setUsername(u.get(0).getUsername());
            user.setPassword(u.get(0).getPassword());
            user.setName(u.get(0).getName());
            user.setSurname(u.get(0).getSurname());
            user.setDate_of_birth(u.get(0).getDate_of_birth());
            user.setEmail(u.get(0).getEmail());
            user.setPassword(u.get(0).getPassword());

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }

        return user;
    }

    //Restituisce la lista di tutti gli utenti
    public List<UserDTO> getUsers() {
        List<User> users;
        List<UserDTO> list = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(User.class);
            users = (List<User>)cr.list();

            for(User u: users) {
                UserDTO user = new UserDTO();
                user.setCod_user(u.getCod_user());
                user.setUsername(u.getUsername());
                user.setPassword(u.getPassword());
                user.setName(u.getName());
                user.setSurname(u.getSurname());
                user.setDate_of_birth(u.getDate_of_birth());
                user.setEmail(u.getEmail());

                list.add(user);
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

    //Crea un utente
    public Integer createUser(UserDTO user) {
        Session session = factory.openSession();
        Transaction transaction = null;

        Integer id_db = null;

        try{
            transaction = session.beginTransaction();

            List<Note> notes = new ArrayList<>();
            User new_user = new User(user.getCod_user(), user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getDate_of_birth(), user.getEmail(), notes);

            id_db = (Integer) session.save(new_user);

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