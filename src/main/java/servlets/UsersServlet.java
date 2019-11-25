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
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getRequestURI();
        String login = s.split("/")[s.split("/").length - 1];
        if (userService.findUserByLogin(login) != null) {
            if (login.equals(req.getSession().getAttribute("login"))) {
                resp.sendRedirect(req.getContextPath() + "/profile");
            } else {
                req.getSession().setAttribute("currLogin", login);
                req.getRequestDispatcher("/jsp/anotherProfile.jsp").forward(req, resp);
            }
        } else {
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        req.setCharacterEncoding("UTF-8");


        String message = req.getParameter("message");
        String s = req.getRequestURI();
        String loginTo = s.split("/")[s.split("/").length - 1];
        String login = (String) req.getSession().getAttribute("login");
        User fromUser = userService.findUserByLogin(login);
        User toUser = userService.findUserByLogin(loginTo);

        if (login != null) {
            Message message1 = new Message(fromUser.getId(), toUser.getId(), message);
            new MessageService().save(message1);
        }

        doGet(req, resp);


//        System.out.println(message);

    }
}
