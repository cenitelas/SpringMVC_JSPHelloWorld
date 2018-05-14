package app.service;

import app.entities.UserEntity;

import java.io.Serializable;
import java.util.List;

public interface  userService{
    public void addUser(UserEntity contact);

    public List<String> listUserName();

    public UserEntity getUser(Integer id);

    public int getUserId(String name);

    public void removeUser(Integer id);

    public void updateUser(UserEntity user);
}
