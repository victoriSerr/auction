package servlets;

import models.Bet;
import models.Lot;
import models.User;
import services.BetService;
import services.LotService;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LotService lotService = new LotService();
        BetService betService = new BetService();
        HttpSession session = req.getSession();

        String s = req.getRequestURI();
        String lotIdH = s.split("/")[s.split("/").length - 1];
        System.out.println(lotIdH);
        Lot lot = lotService.findLotByHash(Integer.parseInt(lotIdH));
        session.setAttribute("lot", lot);


        Bet betLatest = betService.findLatest(lot.getId());
        if (betLatest != null) {
            session.setAttribute("currentPrice", betService.findLatest(lot.getId()).getBetValue());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/lot.jsp");
        requestDispatcher.forward(req, resp);


        Long betVal = Long.parseLong(req.getParameter("bet"));
        System.out.println(betVal);
        if (betVal > (betLatest != null ? betLatest.getBetValue() : lot.getProduct().getPrice())) {
            User user = new UserService().findUserByLogin((String) session.getAttribute("login"));
            Bet bet = new Bet(lot.getId(), new Timestamp(new Date().getTime()), user.getId(), betVal);
            betService.saveBet(bet);
        } else {
            session.setAttribute("invalidBet" , Boolean.TRUE);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer bet = Integer.parseInt(req.getParameter("bet"));
//        System.out.println(bet);
    }
}
