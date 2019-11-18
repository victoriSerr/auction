package services;

import models.Lot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    private void findProducts() {
        lotWithProduct =  connectBd.lotRepository.findAll();
        for (Lot lot : lotWithProduct) {
            if (lot.getFinishDate().before(new Date())) {
                lot.setStatus(true);
            }
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

    public void save (Lot lot) {
        connectBd.lotRepository.save(lot);
    }
}
