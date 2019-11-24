package servlets;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import models.Lot;
import services.LotService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {
    private LotService lotService = new LotService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/lots.jsp");
        List<Lot> lots = lotService.getLotWithProduct();
        req.getSession().setAttribute("lots", lots);
        dispatcher.forward(req, resp);

        String search = req.getParameter("search");
        System.out.println(search);
//        System.out.println(req.getSession().getAttribute("successR"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/lots.jsp").forward(req, resp);
    }


}
