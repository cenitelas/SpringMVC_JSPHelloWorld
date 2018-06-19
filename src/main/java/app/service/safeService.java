package app.service;

import app.entities.safe.SafeEntity;
import app.entities.safe.SafeNumberEntity;

public interface safeService {
    public boolean addSafe(SafeEntity safe, int userId);

    public boolean addSafeNumber(SafeNumberEntity safeNumber, int userId);

    public SafeEntity getSafe(Integer id);

    public SafeNumberEntity getSafeNumber(Integer id);

    public void updateSafe(SafeEntity safe);

    public void updateSafeNumber(SafeNumberEntity safeNumber);

    public void removeSafe(Integer id);

    public void removeSafeNumber(Integer id);

    public SafeNumberEntity random(int id);
}
