package models;

import repositories.LotRepository;

import java.sql.Timestamp;
import java.util.List;

public class Lot {
    private Long id;
    private Long ownerId;
    private Boolean status;
    private Long buyerId;
    private Timestamp startDate;
    private Timestamp finishDate;
    private Boolean transactionStatus;
    private Long productId;
    private Product product;

    public Lot(Long id, Long ownerId, Boolean status, Long buyerId,
               Timestamp startDate, Timestamp finishDate, Boolean transactionStatus, Long productId) {
        this.id = id;
        this.ownerId = ownerId;
        this.status = status;
        this.buyerId = buyerId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.transactionStatus = transactionStatus;
        this.productId = productId;
    }

    public Lot(Long ownerId, Boolean status, Long buyerId,
               Timestamp startDate, Timestamp finishDate, Boolean transactionStatus, Long productId) {
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public Lot setStartDate(Timestamp startDate) {
        this.startDate = startDate;
        return this;
    }

    public Timestamp getFinishDate() {
        return finishDate;
    }

    public Lot setFinishDate(Timestamp finishDate) {
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
