package app.dao;

import app.entities.UserEntity;

import java.util.List;

public interface daoUser {
    public void addUser(UserEntity contact);

    public List<UserEntity> listUserName();

    public UserEntity getUser(Integer id);

    public int getUserId(String name);

    public void removeUser(Integer id);

    public void updateUser(UserEntity user);
}
