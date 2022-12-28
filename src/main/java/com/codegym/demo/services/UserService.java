package com.codegym.demo.services;

import com.codegym.demo.dao.UserDAO;
import com.codegym.demo.models.Account;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public Account checkLogin(String username, String password){
        return userDAO.checkLogin(username,password);
    }
}
