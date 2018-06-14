package app.servlets;

import app.entities.UserEntity;
import app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class ContrServlet {
    @Autowired
    private userService usr;

    @Autowired
    MessageSource messageSource;

    //Link to all user
    @RequestMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("userNames",usr.listUser());
        return "list";
    }

    //Link to home page
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    //Link to add user
    @RequestMapping(value = "/add")
    public String add(){
        return "add";
    }

    //Logic for add user
    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public String goReg(Model model,@RequestParam Map<String, String> map) {

            return "add";
        }


    //Link logon user
    @RequestMapping(value = "/logon")
    public String logon() {
        return "logon";
    }

    //Logic logon user
    @RequestMapping(value = "/cab",method=RequestMethod.POST)
    public String goCab(Model model,@RequestParam Map<String, String> map) {
        model.addAttribute("user",usr.getUserName(map.get("name"),map.get("pass")));
        if(usr.getUserName(map.get("name"),map.get("pass"))!=null) {
            return "cab";
        }
        return "logon";
    }

    @RequestMapping(value = "/pass",method=RequestMethod.POST)
    public String repasslc(Model model,@ModelAttribute("user") UserEntity user,@RequestParam Map<String, String> map) {
        if(map.get("passr").equals(map.get("passr2"))){
            if(map.get("password").equals(user.getPass())){
                if(user.checkUser(usr.getUser(user.getUserId()))){
                    user.setPass(map.get("passr"));
                    usr.updateUser(user);
                    model.addAttribute("user",user);
                    model.addAttribute("message","Пороль обновлен!");
                }else{
                    model.addAttribute("message", "Предупреждение!");
                    return "index";
                }
            }else {
                model.addAttribute("user", user);
                model.addAttribute("message", "Не верный старый пароль");
            }
        }else {
            model.addAttribute("user",user);
            model.addAttribute("message","Новые пароли не совпадают");
        }
        return "cab";
    }
}