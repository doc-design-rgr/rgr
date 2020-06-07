package com.rgr.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "Packing", schema = "rgr_flower_system", catalog = "")
public class PackingEntity {
    private int packingId;
    private String packingType;
    private Double packingPrice;

    @Id
    @Column(name = "packing_id")
    public int getPackingId() {
        return packingId;
    }

    public void setPackingId(int packingId) {
        this.packingId = packingId;
    }

    @Basic
    @Column(name = "packing_type")
    public String getPackingType() {
        return packingType;
    }

    public void setPackingType(String packingType) {
        this.packingType = packingType;
    }

    @Basic
    @Column(name = "packing_price")
    public Double getPackingPrice() {
        return packingPrice;
    }

    public void setPackingPrice(Double packingPrice) {
        this.packingPrice = packingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackingEntity that = (PackingEntity) o;

        if (packingId != that.packingId) return false;
        if (packingType != null ? !packingType.equals(that.packingType) : that.packingType != null) return false;
        if (packingPrice != null ? !packingPrice.equals(that.packingPrice) : that.packingPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packingId;
        result = 31 * result + (packingType != null ? packingType.hashCode() : 0);
        result = 31 * result + (packingPrice != null ? packingPrice.hashCode() : 0);
        return result;
    }
}
