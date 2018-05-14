package app.servlets;

import app.entities.UserEntity;
import app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
public class ContrServlet {
    @Autowired
    private userService usr;

    //Link to all user
    @RequestMapping(value = "/list")
    public String list(Model model){

        System.out.println(usr.listUserName());
        model.addAttribute("userNames",usr.listUserName());
        return "list";
    }

    //Link to home page
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    //Ling to add user
    @RequestMapping(value = "/add")
    public String add(){
        return "add";
    }

    //Logic for add user
    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public String goReg(Model model,@RequestParam("name") String name,@RequestParam("pass") String pass,@RequestParam("year") String year ) {
        Date data = new Date();
        UserEntity user = new UserEntity();
        user.setPass(pass);
        user.setName(name);
        user.setYear(year);
        user.setDate(data);
        boolean check = true;
        for (String userName : usr.listUserName()) {
            if (name.equals(userName)) {
                check = false;
                break;
            }
        }
            if (check) {
                model.addAttribute("message", "<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                        "   <h5>Пользователь " + name + " успешно зарегистрирован!</h5>\n" +
                        "</div>");
                usr.addUser(user);
            } else {
                model.addAttribute("message", "<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>Пользователь " + name + " сушествует!</h5>\n" +
                        "</div>");
            }
            return "add";
        }
    }
