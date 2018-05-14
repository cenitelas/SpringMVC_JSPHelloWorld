package app.servlets;

import app.entities.UserEntity;
import app.service.userService;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
    private app.service.userService userService;
    public DateServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/cab.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer id = userService.getUserId(name);
        UserEntity user = userService.getUser(id);
        req.setAttribute("userName", user.getName());
        req.setAttribute("year", user.getYear());
        req.setAttribute("date", user.getDate());
        req.setAttribute("id", id);
        this.doGet(req, resp);
    }
}

