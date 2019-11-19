package servlets;

import models.User;
import services.MessageService;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("isSignIn") != null) {
            UserService userService = new UserService();
            MessageService messageService = new MessageService();
            User user = userService.findUserByLogin((String)req.getSession().getAttribute("login"));
            req.getSession().setAttribute("messages", messageService.findAll(user.getId()));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
