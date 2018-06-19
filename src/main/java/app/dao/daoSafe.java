package app.dao;

import app.entities.safe.SafeEntity;

import java.util.List;

public interface daoSafe {
    public void addSafe(SafeEntity safe);

    public SafeEntity getSafe(Integer id);

    public List<SafeEntity> listSafe();

    public void updateSafe(SafeEntity safe);

    public void removeSafe(Integer id);

}