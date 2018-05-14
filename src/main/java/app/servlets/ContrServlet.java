package app.servlets;

import app.entities.UserEntity;
import app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ContrServlet {
    @Autowired
    private userService usr;

    //Link to all user
    @RequestMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("userNames",usr.listUserName());
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
            if (usr.addUser(map)) {
                model.addAttribute("message", "true");
                model.addAttribute("name", map.get("name"));
            } else {
                model.addAttribute("message", "false");
                model.addAttribute("name", map.get("name"));
            }
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
        Map<String, String> rMap=usr.logon(map);
        if (rMap.get("name")!="null") {
            model.addAttribute("name", rMap.get("name"));
            model.addAttribute("year", rMap.get("year"));
            model.addAttribute("date", rMap.get("date"));
            model.addAttribute("id", rMap.get("id"));
            model.addAttribute("message", "");
            return "cab";
        } else {
            model.addAttribute("message", "false");
            return "logon";
        }
    }

    @RequestMapping(value = "/repass",method=RequestMethod.POST)
    public String repass(Model model,@RequestParam Map<String, String> map) {
        model.addAttribute("id", map.get("id"));
        return "repass";
    }

    @RequestMapping(value = "/repasslc",method=RequestMethod.POST)
    public String repasslc(Model model,@RequestParam Map<String, String> map) {
        usr.updatePass(Integer.parseInt(map.get("id")),map.get("pass"));
        model.addAttribute("repass","true");
            return "logon";
    }
}