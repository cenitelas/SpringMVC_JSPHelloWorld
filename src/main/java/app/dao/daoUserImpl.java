package app.dao;

import app.entities.HibernateSessionFactory;
import app.entities.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class daoUserImpl implements daoUser {
 private SessionFactory sessionFactory;
    public void addUser(UserEntity user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session.beginTransaction() != null) {
                session.beginTransaction().rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> listUserName() {
        System.out.println("go");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<UserEntity> list = new ArrayList();
        try {
            session.beginTransaction();
            list= session.createCriteria(UserEntity.class).list();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session.beginTransaction() != null) {
                session.beginTransaction().rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }
        System.out.println("end");
        return list;
    }

    @SuppressWarnings("unchecked")
    public UserEntity getUser(Integer id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        UserEntity user = new UserEntity();
        try {
            session.beginTransaction();
            user= session.get(UserEntity.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session.beginTransaction() != null) {
                session.beginTransaction().rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public int getUserId(String name){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        UserEntity user = new UserEntity();
        List<UserEntity> list = listUserName();
        int index=0;
       for(String username:list.stream().map(UserEntity::getName).collect(Collectors.toList())){
         if(username.equals(name)){
             user=list.get(index);
             break;
         }
             index++;
        }
        return user.getUserId();
    }

    public void removeUser(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        UserEntity user = new UserEntity();
        try {
            session.beginTransaction();
            user= session.get(UserEntity.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session.beginTransaction() != null) {
                session.beginTransaction().rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }
    }

    public void updateUser(UserEntity user){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session.beginTransaction() != null) {
                session.beginTransaction().rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }
    }
}
