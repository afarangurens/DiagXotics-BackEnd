package com.afas.diagxotics.service;

import com.afas.diagxotics.dao.UserDao;
import com.afas.diagxotics.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("fakeDao") UserDao userDao) {
        this.userDao = userDao;
    }   

    public int addUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> getAllPeople(){
        return userDao.selectAllPeople();
    }
}