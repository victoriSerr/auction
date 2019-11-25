package services;

import models.Bet;
import models.Lot;
import models.Message;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebListener
public class UpdateStatus implements ServletContextListener {

    private ScheduledExecutorService scheduler;
    private BetService betService = new BetService();
    private LotService lotService = new LotService();


    @Override
    public void contextInitialized(ServletContextEvent event) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
//        System.out.println(event.getServletContext().getServerInfo());
        scheduler.scheduleAtFixedRate(new Task(), 0,1 , TimeUnit.MINUTES);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

    public class Task implements Runnable {
        @Override
        public void run() {
            List<Lot> lost = lotService.getLotWithProduct();
            for (Lot lot : lost) {
                if (lot.getFinishDate().before(new Date()) && !lot.getStatus() ) {
                    Bet bet = betService.findLatest(lot.getId());
                    lot.setStatus(true);
                    System.out.println(lot.getProduct().getName());
                    if (bet != null) {
                        lot.setBuyerId(bet.getpBuyerId());
                        Message message = new Message(13L, bet.getpBuyerId(), "Ваша ставка сыграла: <a href=\"/auction/lot/" + bet.getLotId().hashCode() + "\">" + lot.getProduct().getName() + "</a>");
                        new MessageService().save(message);
                        System.out.println("aaaaaaaaaaaa");
                    } else {
                        lot.setBuyerId(null);
                    }
                    System.out.println("qqqqqqqqqqq");
                    lotService.updateStatus(lot);
                }
            }
        }
    }
}
