package services;

import com.github.kagkarlsson.scheduler.task.VoidExecutionHandler;
import com.github.kagkarlsson.scheduler.task.helper.OneTimeTask;
import com.github.kagkarlsson.scheduler.task.helper.Tasks;
import models.Bet;
import models.Lot;
import models.Message;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LotService {
    private ConnectBd connectBd = new ConnectBd();
    private List<Lot> lotWithProduct;

    public Lot findLotById(Long id) {
        Lot lot = connectBd.lotRepository.find(id).get();
        lot.setProduct(connectBd.productRepository.find(lot.getProductId()).get());
        return lot;
    }

    public List<Lot> getLotWithProduct() {
        findProducts();
        return lotWithProduct;
    }

    private  void findProducts() {

        lotWithProduct =  connectBd.lotRepository.findAll();
        for (Lot lot : lotWithProduct) {
            if (lot.getProduct() == null) {
                lot.setProduct(connectBd.productRepository.find(lot.getProductId()).get());
            }
        }
    }

    public Lot findLotByHash(int hashId) {
        List<Lot> lots = getLotWithProduct();
        for (Lot lot : lots) {
            if (lot.getId().hashCode() == hashId) {
                return lot;
            }
        }
        return null;
    }

    public List<Lot> findUserLots(Long id) {
       List<Lot> list = connectBd.lotRepository.findUsersLot(id);
        for (Lot lot : list) {
            if (lot.getProduct() == null) {
                lot.setProduct(connectBd.productRepository.find(lot.getProductId()).get());
            }
        }
        return list;
    }

    public void save (Lot lot) {
        update(lot);
        connectBd.lotRepository.save(lot);
    }

    private void update(Lot lot) {
        Bet bet = new BetService().findLatest(lot.getId());
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            lot.setStatus(true);
            if (bet != null) {
                lot.setBuyerId(bet.getpBuyerId());
                Message message = new Message(13L, bet.getpBuyerId(), "Ваша ставка сыграла: <a href=\"/auction/lot/" + bet.getLotId().hashCode() + "\">" + lot.getProduct().getName() + "</a>");
                new MessageService().save(message);
            }
            connectBd.lotRepository.update(lot);
        };

        System.out.println(lot.getFinishDate().toString());
        long delay = lot.getFinishDate().getTime() - new Date().getTime();
        pool.schedule(task, delay, TimeUnit.MILLISECONDS);
    }

    public void setTransactionStatus(Lot lot) {
        lot.setTransactionStatus(true);
        connectBd.lotRepository.update(lot);
    }

}
