package app.service;

import app.dao.daoUser;
import app.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private daoUser userDAO;

    @Transactional
    public void addUser(UserEntity user){
        userDAO.addUser(user);
    }

    @Transactional
    public List<String> listUserName(){
        System.out.println("Service");
        return userDAO.listUserName();
    }

    @Transactional
    public UserEntity getUser(Integer id){
        return userDAO.getUser(id);
    }

    @Transactional
    public int getUserId(String name){
        return userDAO.getUserId(name);
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
