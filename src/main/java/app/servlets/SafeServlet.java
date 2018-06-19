package app.servlets;

import app.entities.UserEntity;
import app.entities.safe.SafeEntity;
import app.entities.safe.SafeNumberEntity;
import app.service.safeService;
import app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/safe")
@SessionAttributes("user")
public class SafeServlet {
    @Autowired
    private userService usr;

    @Autowired
    private safeService safeSer;

    @Autowired
    MessageSource messageSource;

    //Link to all user
    @RequestMapping(value = "/safeGame",method=RequestMethod.POST)
    public String safe(Model model,@ModelAttribute("user") UserEntity user) {
        model.addAttribute("user",user);
        SafeEntity safe = safeSer.getSafe(user.getUserId());
        model.addAttribute("safe",safe);
        return "safe";
    }

    @RequestMapping(value = "/safeGo",method=RequestMethod.POST)
    public String safeGo(Model model,@ModelAttribute("user") UserEntity user, @RequestParam Map<String,String> map) {
        model.addAttribute("user",user);
        SafeEntity safe = safeSer.getSafe(user.getUserId());
        SafeNumberEntity safeNumber = safeSer.getSafeNumber(user.getUserId());
        if(safeNumber.getS1().equals(map.get("s1")) && safeNumber.getS2().equals(map.get("s2")) && safeNumber.getS3().equals(map.get("s3")) && safeNumber.getS4().equals(map.get("s4"))){
            safe.setHod(5);
            safeSer.updateSafe(safe);
            model.addAttribute("message", "Сейф вскрыт! Пароль - "+safeNumber.getS1()+""+safeNumber.getS2()+""+safeNumber.getS3()+""+safeNumber.getS4());
        }
        model.addAttribute("hod",safe.getHod());
        int poz=0;
        int check=0;
        if(safeNumber.getS1().equals(map.get("s1")))poz++;
        if(safeNumber.getS2().equals(map.get("s2")))poz++;
        if(safeNumber.getS3().equals(map.get("s3")))poz++;
        if(safeNumber.getS4().equals(map.get("s4")))poz++;

        if(safeNumber.getS1().equals(map.get("s1")) || safeNumber.getS1().equals(map.get("s2")) || safeNumber.getS1().equals(map.get("s3")) || safeNumber.getS1().equals(map.get("s4")))check++;
        if(safeNumber.getS2().equals(map.get("s2")) || safeNumber.getS2().equals(map.get("s3")) || safeNumber.getS2().equals(map.get("s4")))check++;
        if(safeNumber.getS3().equals(map.get("s3")) || safeNumber.getS3().equals(map.get("s4")))check++;
        if(safeNumber.getS4().equals(map.get("s4")))check++;

        model.addAttribute("poz",poz);
        model.addAttribute("check",check);
        if(!safe.getHod().equals(5))safe.setHod(safe.getHod()+1); else safe.setHod(safe.getHod());
        if((!safeNumber.getS1().equals(map.get("s1")) || !safeNumber.getS2().equals(map.get("s2")) || !safeNumber.getS3().equals(map.get("s3")) || !safeNumber.getS4().equals(map.get("s4"))) && safe.getHod().equals(5)){
            safeSer.updateSafe(safe);
            model.addAttribute("message", "Сейф не вскрыт! Пароль - "+safeNumber.getS1()+""+safeNumber.getS2()+""+safeNumber.getS3()+""+safeNumber.getS4());
        }
        return "safe";
    }
}
