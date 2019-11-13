package services;

import models.Product;
import repositories.ProductRepository;

public class ProductService {
    private ConnectBd connectBd = new ConnectBd();

    public void save(Product product) {
        connectBd.productRepository.save(product);
    }
}
