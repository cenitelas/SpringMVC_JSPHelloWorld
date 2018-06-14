package app.dao;

import app.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class daoUserImpl implements daoUser {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addUser(UserEntity user) {
        getSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> listUser() {
        List<UserEntity> list= getSession().createCriteria(UserEntity.class).list();
        return list;
    }

    @Transactional
    public UserEntity getUser(Integer id){
        try {
            UserEntity user = (UserEntity) getSession().get(UserEntity.class, id);
            return user;
        }
        catch (Throwable t)
        {
            return null;
        }
    }

    @Transactional
    public UserEntity getUserName (String name){
        for(UserEntity user:listUser()){
            if(name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }

    @Transactional
    public void removeUser(Integer id) {
        getSession().delete(sessionFactory.getCurrentSession().get(UserEntity.class, id));
    }

    @Transactional
    public void updateUser(UserEntity user){
        getSession().update(user);
    }
}
