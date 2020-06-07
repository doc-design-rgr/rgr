package com.rgr.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Order_info", schema = "rgr_flower_system", catalog = "")
public class OrderInfoEntity {
    private int orderId;
    private Integer customerId;
    private Integer customBouquet;
    private Integer bouquetId;
    private Integer deliveryId;
    private Double cost;
    private Integer packingId;
    private Date orderDate;

    @Id
    @Column(name = "order_id")
    @GeneratedValue
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "customer_id")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "custom_bouquet")
    public Integer getCustomBouquet() {
        return customBouquet;
    }

    public void setCustomBouquet(Integer customBouquet) {
        this.customBouquet = customBouquet;
    }

    @Basic
    @Column(name = "bouquet_id")
    public Integer getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(Integer bouquetId) {
        this.bouquetId = bouquetId;
    }

    @Basic
    @Column(name = "delivery_id")
    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "packing_id")
    public Integer getPackingId() {
        return packingId;
    }

    public void setPackingId(Integer packingId) {
        this.packingId = packingId;
    }

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfoEntity that = (OrderInfoEntity) o;

        if (orderId != that.orderId) return false;
        if (bouquetId != null ? !bouquetId.equals(that.bouquetId) : that.bouquetId != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (customBouquet != null ? !customBouquet.equals(that.customBouquet) : that.customBouquet != null)
            return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (deliveryId != null ? !deliveryId.equals(that.deliveryId) : that.deliveryId != null) return false;
        if (packingId != null ? !packingId.equals(that.packingId) : that.packingId != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (bouquetId != null ? bouquetId.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (customBouquet != null ? customBouquet.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (deliveryId != null ? deliveryId.hashCode() : 0);
        result = 31 * result + (packingId != null ? packingId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }
}
