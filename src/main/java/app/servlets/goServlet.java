package app.servlets;

import app.entities.UserEntity;
import app.service.userService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class goServlet extends HttpServlet {
    private app.service.userService userService;
    public goServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/logon.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        try {
            Integer id = userService.getUserId(name);
            UserEntity user = userService.getUser(id);
            if (name.equals(user.getName())) {
                if (pass.equals(user.getPass())) {
                    req.setAttribute("userName", name);
                    req.getRequestDispatcher("/cab").forward(req, resp);
                }
                req.setAttribute("userName", "<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n   <span onclick=\"this.parentElement.style.display='none'\"\n   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n   <h5>Не верный пароль!</h5>\n</div>");
            }else
                req.setAttribute("userName", "<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n   <span onclick=\"this.parentElement.style.display='none'\"\n   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n   <h5>Нет такого пользователя!</h5>\n</div>");
        }
        catch (Exception e) {
            req.setAttribute("userName", "<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n   <span onclick=\"this.parentElement.style.display='none'\"\n   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n   <h5>Нет такого пользователя!</h5>\n</div>");
        }
        this.doGet(req, resp);
    }
}

