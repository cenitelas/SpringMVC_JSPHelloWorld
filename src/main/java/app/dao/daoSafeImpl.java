package app.dao;

import app.entities.UserEntity;
import app.entities.safe.SafeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class daoSafeImpl implements daoSafe{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void addSafe(SafeEntity safe){
        getSession().save(safe);
    }

    @SuppressWarnings("unchecked")
    public List<SafeEntity> listSafe(){
        List<SafeEntity> list= getSession().createCriteria(SafeEntity.class).list();
        return list;
    }

    @Transactional
    public SafeEntity getSafe(Integer id){
        SafeEntity safe = (SafeEntity) getSession().get(SafeEntity.class, id);
        return safe;
    }

    @Transactional
    public void updateSafe(SafeEntity safe){
        getSession().update(safe);
    }

    @Transactional
    public void removeSafe(Integer id){
        getSession().delete(sessionFactory.getCurrentSession().get(SafeEntity.class, id));
    }
}
