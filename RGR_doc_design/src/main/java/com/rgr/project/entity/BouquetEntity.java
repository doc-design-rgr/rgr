package com.rgr.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "Bouquet", schema = "rgr_flower_system", catalog = "")
public class BouquetEntity {
    private int bouquetId;
    private String bouquetName;
    private String bouquetPicture;
    private Double price;
    private String bouquetEvent;

    @Id
    @Column(name = "bouquet_id")
    public int getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(int bouquetId) {
        this.bouquetId = bouquetId;
    }

    @Basic
    @Column(name = "bouquet_name")
    public String getBouquetName() {
        return bouquetName;
    }

    public void setBouquetName(String bouquetName) {
        this.bouquetName = bouquetName;
    }

    @Basic
    @Column(name = "bouquet_picture")
    public String getBouquetPicture() {
        return bouquetPicture;
    }

    public void setBouquetPicture(String bouquetPicture) {
        this.bouquetPicture = bouquetPicture;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "bouquet_event")
    public String getBouquetEvent() {
        return bouquetEvent;
    }

    public void setBouquetEvent(String bouquetEvent) {
        this.bouquetEvent = bouquetEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BouquetEntity that = (BouquetEntity) o;

        if (bouquetId != that.bouquetId) return false;
        if (bouquetName != null ? !bouquetName.equals(that.bouquetName) : that.bouquetName != null) return false;
        if (bouquetPicture != null ? !bouquetPicture.equals(that.bouquetPicture) : that.bouquetPicture != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (bouquetEvent != null ? !bouquetEvent.equals(that.bouquetEvent) : that.bouquetEvent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bouquetId;
        result = 31 * result + (bouquetName != null ? bouquetName.hashCode() : 0);
        result = 31 * result + (bouquetPicture != null ? bouquetPicture.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (bouquetEvent != null ? bouquetEvent.hashCode() : 0);
        return result;
    }
}
