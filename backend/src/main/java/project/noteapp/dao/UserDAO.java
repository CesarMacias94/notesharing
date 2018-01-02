package project.noteapp.dao;

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

import project.noteapp.bean.User;

@Repository
@Qualifier(value="UserDAO")
public class UserDAO {
    private static SessionFactory factory;

    public UserDAO() {
        super();

        try {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Restituisce i dati di un utente
    public User getUser(String cod_user) {
        User user = new User();
        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("cod_user", cod_user));
            List<User> u = (List<User>)cr.list();

            user.setCod_user(u.get(0).getCod_user());
            user.setUsername(u.get(0).getUsername());
            user.setName(u.get(0).getName());
            user.setSurname(u.get(0).getSurname());
            user.setDate_of_birth(u.get(0).getDate_of_birth());
            user.setEmail(u.get(0).getEmail());
            user.setNotes(u.get(0).getNotes());

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }

        return user;
    }
}