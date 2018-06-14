package app.service;

import app.entities.UserEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface  userService{
    public boolean addUser(UserEntity user);

    public List<String> listUser();

    public UserEntity getUser(Integer id);

    public UserEntity getUserName (String name, String pass);

    public void removeUser(Integer id);

    public void updateUser(UserEntity user);

}
