package services;

import models.Lot;

import java.util.List;

public class LotService {
    private ConnectBd connectBd = new ConnectBd();
    private List<Lot> lotWithProduct;

    public List<Lot> getLotWithProduct() {
        findProducts();
        return lotWithProduct;
    }

    private void findProducts() {
        lotWithProduct =  connectBd.lotRepository.findAll();
        for (Lot lot : lotWithProduct) {
            if (lot.getProduct() == null) {
                lot.setProduct(connectBd.productRepository.find(lot.getProductId()).get());
            }
        }
    }
}
