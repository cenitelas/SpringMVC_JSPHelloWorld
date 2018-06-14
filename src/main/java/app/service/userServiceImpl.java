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


    public boolean addUser(UserEntity user){
        if(user.getName().equals(listUser()))return false;
            userDAO.addUser(user);
            return true;
    }


    public List<String> listUser(){
        return userDAO.listUser().stream().map(UserEntity::getName).collect(Collectors.toList());
    }


    public UserEntity getUserName (String name, String pass){
        try {
            UserEntity user = userDAO.getUserName(name);
            if (user != null) {
                if (user.getPass().equals(pass)) {
                    return user;
                }
            }
        }
        catch (Throwable t) {
            return null;
        }
        return null;
    }


    public UserEntity getUser(Integer id){
        return userDAO.getUser(id);
    }


    public void removeUser(Integer id){
        userDAO.removeUser(id);
    }


    public void updateUser(UserEntity user){
        userDAO.updateUser(user);
    }

}
