package app.service;

import app.dao.daoUser;
import app.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private daoUser userDAO;

    @Transactional
    public boolean addUser(Map<String, String> map){
        Date data = new Date();
        UserEntity user = new UserEntity();
        user.setPass(map.get("pass"));
        user.setName(map.get("name"));
        user.setYear(map.get("year"));
        user.setDate(data);
        boolean check = true;
        for (String userName : listUserName()) {
            if (map.get("name").equals(userName)) {
                check = false;
                break;
            }
        }
        if (check) {
            userDAO.addUser(user);
            return true;
        } else {
            return false;
        }

    }

    @Transactional
    public List<String> listUserName(){
        System.out.println("Service");
        return userDAO.listUserName().stream().map(UserEntity::getName).collect(Collectors.toList());
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
    public Boolean updatePass(Integer id, String pass1, String pass2){
        UserEntity user = userDAO.getUser(id);
        if(user.getPass().equals(pass1)) {
            user.setPass(pass2);
            userDAO.updateUser(user);
return true;
        }
        return false;
    }

    @Transactional
    public Map<String, String> logon(Map<String, String> map){
       Map<String, String> rMap=new HashMap<>();
        rMap.put("name","null");
        Integer id=userDAO.getUserId(map.get("name"));
        if(id!=0) {
                    UserEntity user = userDAO.getUser(id);
                    if (user.getPass().equals(map.get("pass"))) {
                        System.out.println(user.getPass());
                        rMap.replace("name", user.getName());
                        rMap.put("year", user.getYear());
                        rMap.put("date", user.getDate().toString());
                        rMap.put("id", id.toString());
                    } else {
                        return rMap;
                    }
                }
        return rMap;
    }
}
