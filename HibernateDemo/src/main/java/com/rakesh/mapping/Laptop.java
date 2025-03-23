package com.rakesh.mapping;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {
    @Id
    @Column(name="laptop_id")
    private int lId;
    @Column(name="laptop_brand")
    private String lBrand;
    @Column(name="laptop_model")
    private String lModel;

    @ManyToOne
    @JoinColumn(name="alien_id")
    private Alien alien;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlBrand() {
        return lBrand;
    }

    public void setlBrand(String lBrand) {
        this.lBrand = lBrand;
    }

    public String getlModel() {
        return lModel;
    }

    public void setlModel(String lModel) {
        this.lModel = lModel;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lBrand='" + lBrand + '\'' +
                ", lModel='" + lModel + '\'' +
                ", alien=" + alien +
                '}';
    }
}
