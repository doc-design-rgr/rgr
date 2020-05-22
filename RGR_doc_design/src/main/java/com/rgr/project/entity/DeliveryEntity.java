package com.rgr.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "Delivery", schema = "rgr_flower_system", catalog = "")
public class DeliveryEntity {
    private int deliveryId;
    private String deliveryType;
    private Double deliveryPrice;

    @Id
    @Column(name = "delivery_id")
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "delivery_type")
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Basic
    @Column(name = "delivery_price")
    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryEntity that = (DeliveryEntity) o;

        if (deliveryId != that.deliveryId) return false;
        if (deliveryType != null ? !deliveryType.equals(that.deliveryType) : that.deliveryType != null) return false;
        if (deliveryPrice != null ? !deliveryPrice.equals(that.deliveryPrice) : that.deliveryPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryId;
        result = 31 * result + (deliveryType != null ? deliveryType.hashCode() : 0);
        result = 31 * result + (deliveryPrice != null ? deliveryPrice.hashCode() : 0);
        return result;
    }
}
