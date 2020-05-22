package com.rgr.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "Card", schema = "rgr_flower_system", catalog = "")
public class CardEntity {
    private int cardId;
    private String cardType;
    private String cardDiscount;
    private String cardBonus;

    @Id
    @Column(name = "card_id")
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "card_discount")
    public String getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(String cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

    @Basic
    @Column(name = "card_bonus")
    public String getCardBonus() {
        return cardBonus;
    }

    public void setCardBonus(String cardBonus) {
        this.cardBonus = cardBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (cardId != that.cardId) return false;
        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;
        if (cardDiscount != null ? !cardDiscount.equals(that.cardDiscount) : that.cardDiscount != null) return false;
        if (cardBonus != null ? !cardBonus.equals(that.cardBonus) : that.cardBonus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (cardDiscount != null ? cardDiscount.hashCode() : 0);
        result = 31 * result + (cardBonus != null ? cardBonus.hashCode() : 0);
        return result;
    }
}
