package app.servlets;

import app.entities.UserEntity;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePass extends HttpServlet {
    public ChangePass() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/repass.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        Model model = Model.getInstance();
        if (model.updatePass(id, pass)) {
            req.getSession().setAttribute("pass", "<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n   <span onclick=\"this.parentElement.style.display='none'\"\n   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n   <h5>Пароль изменен! Ваш пароль - \"" + pass + "\"</h5>\n</div>");
        } else {
            req.getSession().setAttribute("pass", "<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n   <span onclick=\"this.parentElement.style.display='none'\"\n   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n   <h5>Ошибка смены пароля!</h5>\n</div>");
        }
       // this.doGet(req, resp);
    }
}