package servlets;

import dto.MessageDto;
import models.Bet;
import models.Lot;
import models.Message;
import models.User;
import services.BetService;
import services.LotService;
import services.MessageService;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserService userService = new UserService();
    private MessageService messageService = new MessageService();
   private LotService lotService = new LotService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("isSignIn") != null) {


            User user = userService.findUserByLogin((String)req.getSession().getAttribute("login"));
            List<Message> list =  messageService.findAll(user.getId());
            List<MessageDto> listDto = new ArrayList<>();
            for (Message message : list) {
                listDto.add(userService.from(message));
            }


            req.getSession().setAttribute("messages", listDto);

            System.out.println(user.getLogin());
            List<Lot> lotList = lotService.findUserLots(user.getId());

            req.getSession().setAttribute("lots", lotList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("lotId"));
        lotService.setTransactionStatus(lotService.findLotById(id));
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
