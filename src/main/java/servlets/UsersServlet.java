package servlets;

import models.Message;
import models.User;
import services.MessageService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getRequestURI();
        String login = s.split("/")[s.split("/").length - 1];
        req.getSession().setAttribute("currLogin", login);
        req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
        String message = req.getParameter("message");
        String s = req.getRequestURI();
        String loginTo = s.split("/")[s.split("/").length - 1];
        String login = (String)req.getSession().getAttribute("login");
        User fromUser = new UserService().findUserByLogin(login);
        User toUser = new UserService().findUserByLogin(loginTo);

        if (login != null) {
            Message message1 = new Message(fromUser.getId(), toUser.getId(), message);
            new MessageService().save(message1);
        }


//        System.out.println(message);

    }
}
