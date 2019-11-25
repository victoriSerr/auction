package services;

import models.Bet;
import models.Lot;
import models.Message;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LotService {
    private ConnectBd connectBd = new ConnectBd();
    private List<Lot> lotWithProduct;
    private ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

    public Lot findLotById(Long id) {
        Lot lot = connectBd.lotRepository.find(id).get();
        lot.setProduct(connectBd.productRepository.find(lot.getProductId()).get());
        return lot;
    }

    public List<Lot> getLotWithProduct() {
        findProducts();
        return lotWithProduct;
    }

    private void findProducts() {

        lotWithProduct = connectBd.lotRepository.findAll();
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

    public void save(Lot lot) {
        connectBd.lotRepository.save(lot);
    }

    private void update(Lot lot) {
        Runnable task = () -> {
            Bet bet = new BetService().findLatest(lot.getId());
            if (lot.getFinishDate().before(new Date())) {
                lot.setStatus(true);
                if (bet != null && lot.getStatus()) {
                    lot.setBuyerId(bet.getpBuyerId());
                    Message message = new Message(13L, bet.getpBuyerId(), "Ваша ставка сыграла: <a href=\"/auction/lot/" + bet.getLotId().hashCode() + "\">" + lot.getProduct().getName() + "</a>");
                    new MessageService().save(message);
                    System.out.println("aaaaaaaaaaaa");
                } else {
                    lot.setBuyerId(null);
                }
                System.out.println("qqqqqqqqqqq");
                connectBd.lotRepository.update(lot);
            }
        };

        pool.scheduleAtFixedRate(task, 0, 1 ,TimeUnit.SECONDS);
    }

    public void updateStatus(Lot lot) {
        connectBd.lotRepository.update(lot);
    }

    public void setTransactionStatus(Lot lot) {
        lot.setTransactionStatus(true);
        connectBd.lotRepository.update(lot);
    }


    public static void main(String[] args) {
        LotService lotService = new LotService();
        Lot lot = lotService.getLotWithProduct().get(10);

//        lotService.update(lot);

    }

}
