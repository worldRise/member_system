package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "card_id", type = IdType.AUTO)
    private Integer cardId;

    private String cardName;

    private Integer cardPrice;

    private Integer renewalPrice;

    private LocalDateTime cardLifetime;

    private LocalDateTime lastUpdatedTime;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(Integer cardPrice) {
        this.cardPrice = cardPrice;
    }

    public Integer getRenewalPrice() {
        return renewalPrice;
    }

    public void setRenewalPrice(Integer renewalPrice) {
        this.renewalPrice = renewalPrice;
    }

    public LocalDateTime getCardLifetime() {
        return cardLifetime;
    }

    public void setCardLifetime(LocalDateTime cardLifetime) {
        this.cardLifetime = cardLifetime;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public String toString() {
        return "Card{" +
            "cardId = " + cardId +
            ", cardName = " + cardName +
            ", cardPrice = " + cardPrice +
            ", renewalPrice = " + renewalPrice +
            ", cardLifetime = " + cardLifetime +
            ", lastUpdatedTime = " + lastUpdatedTime +
        "}";
    }
}
