package models;

import repositories.LotRepository;

import java.util.List;

public class Lot {
    private Long id;
    private Long ownerId;
    private Boolean status;
    private Long buyerId;
    private String startDate;
    private String finishDate;
    private Boolean transactionStatus;
    private Long productId;
    private Product product;

    public Lot(Long id, Long ownerId,  Boolean status, Long buyerId,
               String startDate, String finishDate, Boolean transactionStatus, Long productId) {
        this.id = id;
        this.ownerId = ownerId;
        this.status = status;
        this.buyerId = buyerId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.transactionStatus = transactionStatus;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public Lot setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Lot setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public Lot setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public Lot setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Lot setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public Lot setFinishDate(String finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public Lot setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public Lot setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Lot setProduct(Product product) {
        this.product = product;
        return this;
    }
}
