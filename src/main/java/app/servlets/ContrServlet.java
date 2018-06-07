package app.servlets;

import app.entities.UserEntity;
import app.service.userService;
import app.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Map;


@Controller
@RequestMapping("/")
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

    //Link repass user
    @RequestMapping(value = "/repass",method=RequestMethod.POST)
    public String repass(Model model,@RequestParam Map<String, String> map) {
        model.addAttribute("id", map.get("id"));
        model.addAttribute("name", map.get("name"));
        return "repass";
    }

    //Logon repass user
    @RequestMapping(value = "/repasslc",method=RequestMethod.POST)
    public String repasslc(Model model,@RequestParam Map<String, String> map) {

        return "cab";
    }
}