package app.servlets;

import app.model.Model;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
    public DateServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/cab.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Model model = Model.getInstance();
        List<String> names = model.listName();
        int index = 0;

        for(Iterator var7 = names.iterator(); var7.hasNext(); ++index) {
            String nameCheck = (String)var7.next();
            if (nameCheck.equals(name)) {
                req.setAttribute("userName", name);
                req.setAttribute("year", model.getYear(index));
                req.setAttribute("date", model.getUserDate(index));
                req.setAttribute("id", model.getUserid(index));
                break;
            }
        }

        this.doGet(req, resp);
    }
}

