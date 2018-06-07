package app.dao;

import app.entities.UserEntity;

import java.util.List;

public interface daoUser {
    public void addUser(UserEntity user);

    public List<UserEntity> listUser();

    public UserEntity getUser(Integer id);

    public UserEntity getUserName (String name);

    public void removeUser(Integer id);

    public void updateUser(UserEntity user);

}
