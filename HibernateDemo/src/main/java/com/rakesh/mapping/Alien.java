package com.rakesh.mapping;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Alien {
    @Id
    @Column(name="alien_id")
    private int aId;
    @Column(name="alien_name")
    private String aName;
    @Column(name="alien_tech")
    private String aTech;
    @OneToMany(mappedBy = "alien",fetch=FetchType.LAZY)
    private List<Laptop> aLaptop;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public List<Laptop> getaLaptop() {
        return aLaptop;
    }

    public void setaLaptop(List<Laptop> aLaptop) {
        this.aLaptop = aLaptop;
    }

    public String getaTech() {
        return aTech;
    }

    public void setaTech(String aTech) {
        this.aTech = aTech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aTech='" + aTech + '\'' +
                '}';
    }
}
