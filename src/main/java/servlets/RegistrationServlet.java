package servlets;

import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("isSignIn") == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/register.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/profile");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user;

        UserService userService = new UserService();

        String login = req.getParameter("login");


        String hashPassword1 = encoder.encode(req.getParameter("password1"));
//        String hashPassword2 = encoder.encode(req.getParameter("password2"));
        String email = req.getParameter("email");


        System.out.println(login);
        if (!userService.checkLogin(login) && login != null && hashPassword1 != null && email!= null) {
            userService.saveUser(new User(login, hashPassword1, email));

            req.getSession().setAttribute("successR", Boolean.TRUE);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration");
            requestDispatcher.forward(req, resp);
        }

    }
}
