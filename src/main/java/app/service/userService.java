package app.service;

import app.entities.UserEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface  userService{
    public boolean addUser(Map<String, String> map);

    public List<String> listUserName();

    public UserEntity getUser(Integer id);

    public int getUserId(String name);

    public void removeUser(Integer id);

    public void updatePass(Integer id,String pass);

    public Map<String, String> logon(Map<String, String> map);
}
