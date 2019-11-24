package servlets;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.function.LongToDoubleFunction;

@WebServlet("/lot/*")
public class LotServlet extends HttpServlet {
    private LotService lotService = new LotService();
    private BetService betService = new BetService();
    private UserService userService = new UserService();
    private MessageService messageService = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String s = req.getRequestURI();
        String lotIdH = s.split("/")[s.split("/").length - 1];
//        System.out.println(lotIdH);
        Lot lot = lotService.findLotByHash(Integer.parseInt(lotIdH));
        System.out.println(lot);
        if (lot != null) {
            Bet betLatest = betService.findLatest(lot.getId());

            Timestamp finishDate = lot.getFinishDate();


            if (betLatest != null) {
                User userWithLatestBet = userService.findUserById(betLatest.getpBuyerId());
                session.setAttribute("userWithLatestBet", userWithLatestBet.getLogin());
                session.setAttribute("currentPrice", betService.findLatest(lot.getId()).getBetValue());
            }
//

            session.setAttribute("lot", lot);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/lot.jsp");
            requestDispatcher.forward(req, resp);


        } else {
            resp.sendError(404);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Lot lot = (Lot) session.getAttribute("lot");
        Bet betLatest = betService.findLatest(lot.getId());


        Long betVal = Long.parseLong(req.getParameter("bet"));
        System.out.println(betVal);
        if (betVal > (betLatest != null ? betLatest.getBetValue() : lot.getProduct().getPrice())) {
            User user = new UserService().findUserByLogin((String) session.getAttribute("login"));
            Bet bet = new Bet(lot.getId(), new Timestamp(new Date().getTime()), user.getId(), betVal);
            betService.saveBet(bet);
        } else {
            session.setAttribute("invalidBet", Boolean.TRUE);
        }
        resp.sendRedirect(req.getContextPath() + "/lot/" + lot.getId().hashCode());
    }

}
