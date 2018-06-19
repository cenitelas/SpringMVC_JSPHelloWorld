package app.dao;

import app.entities.safe.SafeEntity;
import app.entities.safe.SafeNumberEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class daoSafeNumberImpl implements daoSafeNumber{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void addSafeNumber(SafeNumberEntity safeNumber){
        getSession().save(safeNumber);
    }

    @SuppressWarnings("unchecked")
    public List<SafeNumberEntity> listSafeNumber(){
        List<SafeNumberEntity> list= getSession().createCriteria(SafeNumberEntity.class).list();
        return list;
    }

    @Transactional
    public SafeNumberEntity getSafeNumber(Integer id){
        SafeNumberEntity safeNumber = (SafeNumberEntity) getSession().get(SafeNumberEntity.class, id);
        return safeNumber;
    }

    @Transactional
    public void updateSafeNumber(SafeNumberEntity safeNumber){
        getSession().update(safeNumber);
    }

    @Transactional
    public void removeSafeNumber(Integer id){
        getSession().delete(sessionFactory.getCurrentSession().get(SafeNumberEntity.class, id));
    }
}
