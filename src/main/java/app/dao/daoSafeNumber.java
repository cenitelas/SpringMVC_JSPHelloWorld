package app.dao;

import app.entities.safe.SafeNumberEntity;

import java.util.List;

public interface daoSafeNumber {

    public void addSafeNumber(SafeNumberEntity safeNumber);

    public SafeNumberEntity getSafeNumber(Integer id);

    public void updateSafeNumber(SafeNumberEntity safeNumber);

    public List<SafeNumberEntity> listSafeNumber();

    public void removeSafeNumber(Integer id);
}