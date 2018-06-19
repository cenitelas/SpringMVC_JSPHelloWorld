package app.service;

import app.dao.daoSafe;
import app.dao.daoSafeNumber;
import app.entities.safe.SafeEntity;
import app.entities.safe.SafeNumberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class safeServiceImpl implements safeService {

    @Autowired
    private daoSafe dSafe;

    @Autowired
    private daoSafeNumber dSafeNumber;

    public boolean addSafe(SafeEntity safe, int userId){
        for(SafeEntity id:dSafe.listSafe())
        {
            if(id.getIdUser().equals(userId)){
                addSafeNumber(random(userId),userId);
                return false;
            }
        }
        addSafeNumber(random(userId),userId);
        dSafe.addSafe(safe);
        return true;
    }

    public boolean addSafeNumber(SafeNumberEntity safeNumber, int userId){
        for(SafeNumberEntity id:dSafeNumber.listSafeNumber())
        {
            if(id.getIdUser().equals(userId)){
                updateSafeNumber(random(userId));
                return false;
            }
        }
        dSafeNumber.addSafeNumber(safeNumber);
        return true;
    }

    public SafeEntity getSafe(Integer id){
        for(SafeEntity id_user:dSafe.listSafe())
        {
            if(id_user.getIdUser().equals(id)){
                    if(id_user.getHod().equals(0) || id_user.getHod().equals(5))
                    addSafeNumber(random(id),id);
                dSafe.updateSafe(id_user);
                return id_user;
            }
        }
        SafeEntity safe = new SafeEntity();
        safe.setHod(0);
        safe.setIdUser(id);
        addSafe(safe,id);
        return safe;
    }

    public SafeNumberEntity getSafeNumber(Integer id){
        for(SafeNumberEntity id_user:dSafeNumber.listSafeNumber())
        {
            if(id_user.getIdUser().equals(id)){
                return id_user;
            }
        }
        return null;
    }

    public void updateSafe(SafeEntity safe){
        dSafe.updateSafe(safe);
    }

    public void updateSafeNumber(SafeNumberEntity safeNumber){
        dSafeNumber.updateSafeNumber(safeNumber);
    }

    public void removeSafe(Integer id){
    dSafe.removeSafe(id);
    }

    public void removeSafeNumber(Integer id){
        dSafeNumber.removeSafeNumber(id);
    }

    public SafeNumberEntity random(int id){
        SafeNumberEntity safeNumber = new SafeNumberEntity();
        safeNumber.setIdUser(id);
        for(int i=0;i<4;i++){
            int temp = (int)Math.random()*10;
            if(!safeNumber.getS1().equals(temp) && !safeNumber.getS2().equals(temp) && !safeNumber.getS3().equals(temp) && !safeNumber.getS4().equals(temp)){
                if(i==0)safeNumber.setS1(temp);
                if(i==1)safeNumber.setS2(temp);
                if(i==2)safeNumber.setS3(temp);
                if(i==3)safeNumber.setS4(temp);
            }else{
                i--;
            }
        }
        return safeNumber;
    }
}
