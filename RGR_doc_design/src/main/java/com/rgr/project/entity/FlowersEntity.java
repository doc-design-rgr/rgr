package com.rgr.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "Flowers", schema = "rgr_flower_system", catalog = "")
public class FlowersEntity {
    private int flowerId;
    private String flowerName;
    private Double flowerPrice;

    @Id
    @Column(name = "flower_id")
    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    @Basic
    @Column(name = "flower_name")
    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    @Basic
    @Column(name = "flower_price")
    public Double getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(Double flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowersEntity that = (FlowersEntity) o;

        if (flowerId != that.flowerId) return false;
        if (flowerName != null ? !flowerName.equals(that.flowerName) : that.flowerName != null) return false;
        if (flowerPrice != null ? !flowerPrice.equals(that.flowerPrice) : that.flowerPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowerId;
        result = 31 * result + (flowerName != null ? flowerName.hashCode() : 0);
        result = 31 * result + (flowerPrice != null ? flowerPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlowersEntity{" +
                "flowerId=" + flowerId +
                ", flowerName='" + flowerName + '\'' +
                ", flowerPrice=" + flowerPrice +
                '}';
    }
}
