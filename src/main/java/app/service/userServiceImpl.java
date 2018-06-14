package app.service;

import app.dao.daoUser;
import app.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private daoUser userDAO;

    @Transactional
    public boolean addUser(UserEntity user){
        if(user.getName().equals(listUser()))return false;
            userDAO.addUser(user);
            return true;
    }

    @Transactional
    public List<String> listUser(){
        return userDAO.listUser().stream().map(UserEntity::getName).collect(Collectors.toList());
    }

    @Transactional
    public UserEntity getUserName (String name, String pass){
        UserEntity user = userDAO.getUserName(name);
        if(user.getPass().equals(pass)){
            return user;
        }
        return null;
    }

    @Transactional
    public UserEntity getUser(Integer id){
        return userDAO.getUser(id);
    }

    @Transactional
    public void removeUser(Integer id){
        userDAO.removeUser(id);
    }

    @Transactional
    public void updateUser(UserEntity user){
        userDAO.updateUser(user);
    }

}
