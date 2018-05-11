package app.model;

import app.entities.HibernateSessionFactory;
import app.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.security.MessageDigest;

public class Model {
    private static Model instance = new Model();
    private List<UserEntity> model = new ArrayList();

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            model.clear();
            model = session.createCriteria(UserEntity.class).list();
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
    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public boolean add (UserEntity user) {

        for(UserEntity x : model){
            if(x.getName().equals(user.getName())){
                return false;
            }
        }
       user.setPass(sha256(user.getPass()));
        model.add(user);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public List<String> listName() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            model.clear();
            model = session.createCriteria(UserEntity.class).list();
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
        return model.stream().map(UserEntity::getName).collect(Collectors.toList());
    }

    public boolean updatePass(String id,String pass){
        int index=0;
        for(UserEntity x:model) {
            if (id.equals(x.getUserId()+"")) {
                model.get(index).setPass(sha256(pass));
                break;
            }
            index++;
        }
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update( model.get(index));
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при вставке");
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    public String getYear(int index) {
        return model.get(index).getYear();
    }

    public String getPass(int index) {
        return model.get(index).getPass();
    }

    public String getUserDate(int index) {
        return model.get(index).getDate().toString();
    }

    public String getUserid(int index) {
        return model.get(index).getUserId()+"";
    }
}