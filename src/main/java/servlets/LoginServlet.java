package servlets;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.UserRepository;
import services.ConnectBd;
import models.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");

        if (req.getSession().getAttribute("isSignIn") != null) {
            resp.sendRedirect(req.getContextPath() + "/profile");

        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = userService.findUserByLogin(login);

        if (user == null) {
            req.getSession().setAttribute("wrongLogin", "wrong login");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
            requestDispatcher.forward(req, resp);
        } else if (!encoder.matches(req.getParameter("password"), user.getHashPassword())) {
//        } else if (!user.getHashPassword().equals(req.getParameter("password"))) {
            req.getSession().setAttribute("wrongPassword", "wrong password");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            if (req.getParameterValues("remember_me") != null) {
                Cookie cookie = new Cookie("login", user.getLogin());
                cookie.setMaxAge(60*240);
                resp.addCookie(cookie);
            }
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("isSignIn", Boolean.TRUE);

            resp.sendRedirect(req.getContextPath() + "/profile");
        }
    }
}
