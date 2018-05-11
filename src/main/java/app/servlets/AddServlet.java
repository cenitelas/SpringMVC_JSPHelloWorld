package app.servlets;

import app.entities.UserEntity;
import app.model.Model;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
    public AddServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String year = req.getParameter("year");
        Date data = new Date();
        UserEntity user = new UserEntity();
        user.setPass(password);
        user.setName(name);
        user.setYear(year);
        user.setDate(data);
        Model model = Model.getInstance();
        boolean check = model.add(user);
        req.setAttribute("userName", name);
        if(check)
        req.setAttribute("check", "true");
        else
            req.setAttribute("check", "false");
        this.doGet(req, resp);
    }
}