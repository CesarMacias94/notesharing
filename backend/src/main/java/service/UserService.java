package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.User;
import dao.UserDAO;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User getUser(String cod_user) {
        return userDAO.getUser(cod_user);
    }
}