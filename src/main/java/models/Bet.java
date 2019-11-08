package models;

import java.util.Date;

public class Bet {
    private Long id;
    private Long lotId;
    private Date date;
    private Long pBuyerId;
    private Long betValue;

    public Bet(Long id, Long lotId, Date date, Long pBuyerId, Long betValue) {
        this.id = id;
        this.lotId = lotId;
        this.date = date;
        this.pBuyerId = pBuyerId;
        this.betValue = betValue;
    }

    public Long getId() {
        return id;
    }

    public Bet setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getLotId() {
        return lotId;
    }

    public Bet setLotId(Long lotId) {
        this.lotId = lotId;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Bet setDate(Date date) {
        this.date = date;
        return this;
    }

    public Long getpBuyerId() {
        return pBuyerId;
    }

    public Bet setpBuyerId(Long pBuyerId) {
        this.pBuyerId = pBuyerId;
        return this;
    }

    public Long getBetValue() {
        return betValue;
    }

    public Bet setBetValue(Long betValue) {
        this.betValue = betValue;
        return this;
    }
}
